package com.awesomeshot5051.plantfarms.blocks.tileentity.theend;

import com.awesomeshot5051.corelib.blockentity.*;
import com.awesomeshot5051.corelib.inventory.*;
import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.storage.loot.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.plantfarms.datacomponents.AxeEnchantments.*;

public class ChorusFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    private static final ResourceKey<LootTable> OAK_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/blaze"));
    protected NonNullList<ItemStack> inventory;
    protected long timer;
    public Map<ResourceKey<Enchantment>, Boolean> axeEnchantments = initializeAxeEnchantments();
    public ItemStack axeType = new ItemStack(Items.WOODEN_AXE);
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public ChorusFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.CHORUS_FARM.get(), ModBlocks.CHORUS_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getChorusSpawnTime() {
        return Main.SERVER_CONFIG.chorusSpawnTime.get() - 20 * 4;
    }

    public static int getChorusDeathTime() {
        return getChorusSpawnTime() + 20 * 4;
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        timer++;
        setChanged();
        if (timer == getChorusSpawnTime()) {
            sync();
        } else if (timer >= getChorusDeathTime()) {
            for (ItemStack drop : getDrops()) {
                for (int i = 0; i < itemHandler.getSlots(); i++) {
                    drop = itemHandler.insertItem(i, drop, false);
                    if (drop.isEmpty()) {
                        break;
                    }
                }
            }
            timer = 0L;
            sync();
        }
    }

    private List<ItemStack> getDrops() {
        if (!(level instanceof ServerLevel serverWorld)) {
            return Collections.emptyList();
        }
        double dropChance = 0.5;
        List<ItemStack> drops = new ArrayList<>();
        if (serverWorld.random.nextDouble() < dropChance) {
            int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 4);
            drops.add(new ItemStack(Items.CHORUS_PLANT, dropCount));
            drops.add(new ItemStack(Items.CHORUS_FLOWER));
        }
        drops.add(new ItemStack(Items.CHORUS_FRUIT));
        return drops;
    }

    public Container getOutputInventory() {
        return new ItemListInventory(inventory, this::setChanged);
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        super.saveAdditional(compound, provider);
        ContainerHelper.saveAllItems(compound, inventory, false, provider);
        compound.putLong("Timer", timer);
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        ContainerHelper.loadAllItems(compound, inventory, provider);
        timer = compound.getLong("Timer");
        super.loadAdditional(compound, provider);
    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }
}
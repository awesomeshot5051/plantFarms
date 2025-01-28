package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants;

import com.awesomeshot5051.corelib.blockentity.*;
import com.awesomeshot5051.corelib.inventory.*;
import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.state.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.plantfarms.datacomponents.HoeEnchantments.*;

public class leafFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    protected NonNullList<ItemStack> inventory;
    protected long timer;
    public Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments = initializeHoeEnchantments();
    public ItemStack hoeType = new ItemStack(Items.WOODEN_HOE);
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public leafFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.LEAF_FARM.get(), ModBlocks.LEAF_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getLeafSpawnTime() {
        return Main.SERVER_CONFIG.leafSpawnTime.get() - 20 * 4;
    }

    public static int getLeafDeathTime() {
        return getLeafSpawnTime() + 20 * 4;
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        timer++;
        setChanged();
        if (timer == getLeafSpawnTime()) {
            sync();
        } else if (timer >= getLeafDeathTime()) {
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
        List<ItemStack> drops = new ArrayList<>();
        int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 4);
        if (serverWorld.random.nextFloat() < .5) {
            drops.add(new ItemStack(Items.SMALL_DRIPLEAF, dropCount));
        }
        if (serverWorld.random.nextFloat() < .05) {
            drops.add(new ItemStack(Items.BIG_DRIPLEAF));
        }
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
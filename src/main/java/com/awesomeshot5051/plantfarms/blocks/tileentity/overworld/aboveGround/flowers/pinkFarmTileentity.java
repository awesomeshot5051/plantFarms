package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.OutputItemHandler;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.plantfarms.blocks.tileentity.SyncableTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.VillagerTileentity;
import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
import de.maxhenkel.corelib.inventory.ItemListInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.awesomeshot5051.plantfarms.datacomponents.HoeEnchantments.initializeHoeEnchantments;

public class pinkFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

//private static final ResourceKey<LootTable> ACACIA_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/acacia"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    public Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments = initializeHoeEnchantments();
    public ItemStack hoeType;
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;


    public pinkFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.PINK_FARM.get(), ModBlocks.PINK_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getPinkSpawnTime() {
        return Main.SERVER_CONFIG.pinkSpawnTime.get() - 20 * 4;
    }

    public static int getPinkDeathTime() {
        return getPinkSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {

        timer++;
        setChanged();

        if (timer == getPinkSpawnTime()) {
            sync();
//            }
        } else if (timer >= getPinkDeathTime()) {
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
        drops.add(new ItemStack(Items.PINK_TULIP, dropCount)); // Drop 1 blaze rod

        return drops;
    }

    public Container getOutputInventory() {
        return new ItemListInventory(inventory, this::setChanged);
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        super.saveAdditional(compound, provider);
        if (hoeType != null) {
            CompoundTag hoeTypeTag = new CompoundTag();
            hoeTypeTag.putString("id", BuiltInRegistries.ITEM.getKey(hoeType.getItem()).toString()); // Save the item ID
            hoeTypeTag.putInt("count", hoeType.getCount()); // Save the count
            compound.put("HoeType", hoeTypeTag); // Add the tag to the main compound
        }
        ContainerHelper.saveAllItems(compound, inventory, false, provider);
        compound.putLong("Timer", timer);
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        ContainerHelper.loadAllItems(compound, inventory, provider);
        if (compound.contains("HoeType")) {
            SyncableTileentity.loadHoeType(compound, provider).ifPresent(stack -> this.hoeType = stack);
        }
        if (hoeType == null) {
// If no pickType is saved, set a default one (e.g., Stone Pickaxe)
            hoeType = new ItemStack(Items.WOODEN_HOE);
        }
        timer = compound.getLong("Timer");
        super.loadAdditional(compound, provider);
    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }

}

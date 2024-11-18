package com.awesomeshot5051.plantfarms.blocks.tileentity.nether.other;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.OutputItemHandler;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.plantfarms.blocks.tileentity.VillagerTileentity;
import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
import de.maxhenkel.corelib.inventory.ItemListInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class netherWartFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

//private static final ResourceKey<LootTable> ACACIA_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/acacia"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public netherWartFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.WART_FARM.get(), ModBlocks.WART_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getWartSpawnTime() {
        return Main.SERVER_CONFIG.wartSpawnTime.get() - 20 * 4;
    }

    public static int getWartDeathTime() {
        return getWartSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        assert level != null;
        BlockState blockBelow = level.getBlockState(getBlockPos().below());
        if (blockBelow.is(Blocks.SOUL_SAND) || blockBelow.is(Blocks.SOUL_SOIL)) {
            // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.ACACIA_PRIMED);

            timer++;
            setChanged();

            if (timer == getWartSpawnTime()) {
//            // Play acacia spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ACACIA_PRIMED);
                sync();
//        } else if (timer > getcrimsonSpawnTime() && timer < getcrimsonDeathTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ACACIA_HURT);
//            }
            } else if (timer >= getWartDeathTime()) {
                // Play acacia death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ACACIA_DEATH);
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
        } else {
            timer = 0L;
            setChanged();
        }
    }

    private List<ItemStack> getDrops() {
        if (!(level instanceof ServerLevel serverWorld)) {
            return Collections.emptyList();
        }

        // Chance to drop blaze rod
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(Items.NETHER_WART));
        // Optionally, you can add other items to drop here if needed
        // drops.add(new ItemStack(Items.SOME_OTHER_ITEM, 1));

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

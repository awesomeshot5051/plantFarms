package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees;

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

import static com.awesomeshot5051.plantfarms.datacomponents.AxeEnchantments.initializeAxeEnchantments;

public class SpruceFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    // private static final ResourceKey<LootTable> SPRUCE_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/spruce"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    public Map<ResourceKey<Enchantment>, Boolean> axeEnchantments = initializeAxeEnchantments();
    public ItemStack axeType;
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;


    public SpruceFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.SPRUCE_FARM.get(), ModBlocks.SPRUCE_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getSpruceSpawnTime() {
        return Main.SERVER_CONFIG.spruceSpawnTime.get() - 20 * 4;
    }

    public static int getSpruceDeathTime() {
        return getSpruceSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.SPRUCE_PRIMED);

        timer++;
        setChanged();

        if (timer == getSpruceSpawnTime()) {
//            // Play spruce spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.SPRUCE_PRIMED);
            sync();
//        } else if (timer > getSpruceSpawnTime() && timer < getSpruceDeathTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.SPRUCE_HURT);
//            }
        } else if (timer >= getSpruceDeathTime()) {
            // Play spruce death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.SPRUCE_DEATH);
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

        // Chance to drop blaze rod
        double dropChance = 0.5; // 50% chance to drop blaze rod
        List<ItemStack> drops = new ArrayList<>();

        if (serverWorld.random.nextDouble() < dropChance) {
            int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 4);
            drops.add(new ItemStack(Items.SPRUCE_SAPLING, dropCount)); // Drop 1 blaze rod
        }
        drops.add(new ItemStack(Items.SPRUCE_LOG));
        drops.add(new ItemStack(Items.SPRUCE_LEAVES));
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

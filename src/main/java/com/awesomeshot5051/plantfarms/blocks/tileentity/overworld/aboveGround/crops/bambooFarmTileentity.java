package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.OutputItemHandler;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.plantfarms.blocks.tileentity.SyncableTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.VillagerTileentity;
import com.awesomeshot5051.plantfarms.datacomponents.AxeEnchantments;
import com.awesomeshot5051.plantfarms.enums.AxeType;
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
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.awesomeshot5051.plantfarms.datacomponents.AxeEnchantments.initializeAxeEnchantments;

public class bambooFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

//private static final ResourceKey<LootTable> BAMBOO_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/bamboo"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    public Map<ResourceKey<Enchantment>, Boolean> axeEnchantments = initializeAxeEnchantments();
    public ItemStack axeType;
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;


    public bambooFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.BAMBOO_FARM.get(), ModBlocks.BAMBOO_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
        axeType = new ItemStack(Items.WOODEN_AXE);
    }

    public static double getBambooSpawnTime(bambooFarmTileentity farm) {
        AxeType axe = AxeType.fromItem(farm.getAxeType().getItem());
        return (double) Main.SERVER_CONFIG.bambooSpawnTime.get() /
                (axe.equals(AxeType.NETHERITE) ? 30 :
                        axe.equals(AxeType.DIAMOND) ? 25 :
                                axe.equals(AxeType.GOLDEN) ? 20 :
                                        axe.equals(AxeType.IRON) ? 15 :
                                                axe.equals(AxeType.STONE) ? 10
                                                        : 1);
    }

    public static double getBambooDeathTime(bambooFarmTileentity farm) {
        // Iterate through the enchantments
        AxeType axe = AxeType.fromItem(farm.getAxeType().getItem());
        if (farm.getAxeType().isEnchanted()) {
            farm.setAxeEnchantmentStatus(farm);
        }
        int baseValue = 20;
        if (AxeEnchantments.getAxeEnchantmentStatus(farm.axeEnchantments, Enchantments.EFFICIENCY)) {
            baseValue = 10;
        }
        return getBambooSpawnTime(farm) + (axe.equals(AxeType.NETHERITE) ? (baseValue * 3.2) :
                axe.equals(AxeType.DIAMOND) ? (baseValue * 5.6) :
                        axe.equals(AxeType.IRON) ? (baseValue * 4.8) :
                                axe.equals(AxeType.STONE) ? (baseValue * 6.4) :
                                        axe.equals(AxeType.WOODEN) ? (baseValue * 6.4) :
                                                6.4);
    }

    public long getTimer() {
        return timer;
    }


    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.BAMBOO_PRIMED);

        timer++;
        setChanged();

        if (timer == getBambooSpawnTime(this)) {
//            // Play bamboo spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.BAMBOO_PRIMED);
            sync();
//        } else if (timer > getBambooSpawnTime() && timer < getBambooDeathTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.BAMBOO_HURT);
//            }
        } else if (timer >= getBambooDeathTime(this)) {
            // Play bamboo death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.BAMBOO_DEATH);
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

        int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 4);
        drops.add(new ItemStack(Items.BAMBOO, dropCount)); // Drop 1 blaze rod

        return drops;
    }

    public Container getOutputInventory() {
        return new ItemListInventory(inventory, this::setChanged);
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        super.saveAdditional(compound, provider);
        if (axeType != null) {
            CompoundTag axeTypeTag = new CompoundTag();
            axeTypeTag.putString("id", BuiltInRegistries.ITEM.getKey(axeType.getItem()).toString()); // Save the item ID
            axeTypeTag.putInt("count", axeType.getCount()); // Save the count
            compound.put("AxeType", axeTypeTag); // Add the tag to the main compound
        }
        ContainerHelper.saveAllItems(compound, inventory, false, provider);
        compound.putLong("Timer", timer);
    }

    public ItemStack getAxeType() {
        return axeType;
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        ContainerHelper.loadAllItems(compound, inventory, provider);
        if (compound.contains("AxeType")) {
            SyncableTileentity.loadAxeType(compound, provider).ifPresent(stack -> this.axeType = stack);
        }
        if (axeType == null) {
// If no pickType is saved, set a default one (e.g., Stone Pickaxe)
            axeType = new ItemStack(Items.WOODEN_AXE);
        }
        timer = compound.getLong("Timer");
        super.loadAdditional(compound, provider);
    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }

}

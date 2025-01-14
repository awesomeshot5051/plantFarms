package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.awesomeshot5051.plantfarms.enums.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.inventory.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
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

public class melonFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

//private static final ResourceKey<LootTable> MELON_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/melon"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    public Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments = initializeHoeEnchantments();
    public ItemStack hoeType = new ItemStack(Items.WOODEN_HOE);
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;


    public melonFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.MELON_FARM.get(), ModBlocks.MELON_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static double getMelonSpawnTime(melonFarmTileentity farm) {
        HoeType hoe = HoeType.fromItem(farm.getHoeType().getItem());
        return (double) Main.SERVER_CONFIG.melonSpawnTime.get() /
                (hoe.equals(HoeType.NETHERITE) ? 30 :
                        hoe.equals(HoeType.DIAMOND) ? 25 :
                                hoe.equals(HoeType.GOLDEN) ? 20 :
                                        hoe.equals(HoeType.IRON) ? 15 :
                                                hoe.equals(HoeType.STONE) ? 10
                                                        : 1);
    }

    public static double getMelonDeathTime(melonFarmTileentity farm) {
        // Iterate through the enchantments
        HoeType hoe = HoeType.fromItem(farm.getHoeType().getItem());
        if (farm.getHoeType().isEnchanted()) {
            farm.setHoeEnchantmentStatus(farm);
        }
        int baseValue = 20;
        if (HoeEnchantments.getHoeEnchantmentStatus(farm.hoeEnchantments, Enchantments.EFFICIENCY)) {
            baseValue = 10;
        }
        return getMelonSpawnTime(farm) + (hoe.equals(HoeType.NETHERITE) ? (baseValue * 3.2) :
                hoe.equals(HoeType.DIAMOND) ? (baseValue * 5.6) :
                        hoe.equals(HoeType.IRON) ? (baseValue * 4.8) :
                                hoe.equals(HoeType.STONE) ? (baseValue * 6.4) :
                                        hoe.equals(HoeType.WOODEN) ? (baseValue * 6.4) :
                                                6.4); // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public ItemStack getHoeType() {
        return hoeType;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.MELON_PRIMED);

        timer++;
        setChanged();

        if (timer == getMelonSpawnTime(this)) {
//            // Play melon spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.MELON_PRIMED);
            sync();
//        } else if (timer > getMelonSpawnTime() && timer < getMelonDeathTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.MELON_HURT);
//            }
        } else if (timer >= getMelonDeathTime(this)) {
            // Play melon death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.MELON_DEATH);
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
            drops.add(new ItemStack(Items.MELON_SLICE, dropCount));
        }
        drops.add(new ItemStack(Items.MELON));
        drops.add(new ItemStack(Items.MELON_SEEDS));
        if (serverWorld.random.nextDouble() < .003) {
            drops.add(new ItemStack(Items.GLISTERING_MELON_SLICE));
        }
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

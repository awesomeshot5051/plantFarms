package com.awesomeshot5051.plantfarms.blocks.tileentity.nether.crimsonForest;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.enums.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.inventory.*;
import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.plantfarms.datacomponents.HoeEnchantments.*;

public class crimsonFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

//private static final ResourceKey<LootTable> ACACIA_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/acacia"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;
    public Map<ResourceKey<Enchantment>, Boolean> axeEnchantments = initializeHoeEnchantments();
    public ItemStack axeType;
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;


    public crimsonFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.CRIMSON_FARM.get(), ModBlocks.CRIMSON_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static double getCrimsonSpawnTime(crimsonFarmTileentity farm) {
        AxeType axe = AxeType.fromItem(farm.getAxeType().getItem());
        return (double) Main.SERVER_CONFIG.acaciaSpawnTime.get() /
                (axe.equals(AxeType.NETHERITE) ? 30 :
                        axe.equals(AxeType.DIAMOND) ? 25 :
                                axe.equals(AxeType.GOLDEN) ? 20 :
                                        axe.equals(AxeType.IRON) ? 15 :
                                                axe.equals(AxeType.STONE) ? 10
                                                        : 1);
    }

    public static double getCrimsonDeathTime(crimsonFarmTileentity farm) {
        return getCrimsonSpawnTime(farm) + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
        assert level != null;
        BlockState blockBelow = level.getBlockState(getBlockPos().below());
        if (blockBelow.is(Blocks.CRIMSON_NYLIUM)) {
            timer++;
            setChanged();

            if (timer == getCrimsonSpawnTime(this)) {
//            // Play acacia spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ACACIA_PRIMED);
                sync();
//        } else if (timer > getcrimsonSpawnTime() && timer < getcrimsonDeathTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ACACIA_HURT);
//            }
            } else if (timer >= getCrimsonDeathTime(this)) {
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
            // If not on Crimson Nylium, reset the timer and do nothing
            timer = 0L;
            setChanged();
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
            drops.add(new ItemStack(Items.CRIMSON_FUNGUS, dropCount)); // Drop 1 blaze rod
        }
        if (serverWorld.random.nextDouble() < .7) {
            int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 4);
            drops.add(new ItemStack(Items.SHROOMLIGHT, dropCount));
        }
        drops.add(new ItemStack(Items.CRIMSON_STEM));
        if (serverWorld.random.nextDouble() < .005) {
            drops.add(new ItemStack(Items.STRIPPED_CRIMSON_STEM));
        }
        if (serverWorld.random.nextDouble() < .2) {
            int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 4);
            drops.add(new ItemStack(Items.WEEPING_VINES, dropCount));
        }
        drops.add(new ItemStack(Items.CRIMSON_HYPHAE));
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

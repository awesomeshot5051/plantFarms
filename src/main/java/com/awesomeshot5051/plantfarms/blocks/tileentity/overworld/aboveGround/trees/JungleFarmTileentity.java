package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
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

import static com.awesomeshot5051.plantfarms.datacomponents.AxeEnchantments.*;

public class JungleFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    // private static final ResourceKey<LootTable> JUNGLE_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/jungle"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    public Map<ResourceKey<Enchantment>, Boolean> axeEnchantments = initializeAxeEnchantments();
    public ItemStack axeType = new ItemStack(Items.WOODEN_AXE);
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;


    public JungleFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.JUNGLE_FARM.get(), ModBlocks.JUNGLE_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static double getJungleSpawnTime(JungleFarmTileentity farm) {
        AxeType axe = AxeType.fromItem(farm.getAxeType().getItem());
        return (double) Main.SERVER_CONFIG.jungleSpawnTime.get() - 20 * 4;
    }

    public static double getJungleDeathTime(JungleFarmTileentity farm) {
        return getJungleSpawnTime(farm) + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.JUNGLE_PRIMED);

        timer++;
        setChanged();

        if (timer == getJungleSpawnTime(this)) {
//            // Play jungle spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.JUNGLE_PRIMED);
            sync();
//        } else if (timer > getJungleSpawnTime() && timer < getJungleDeathTime(this)) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.JUNGLE_HURT);
//            }
        } else if (timer >= getJungleDeathTime(this)) {
            // Play jungle death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.JUNGLE_DEATH);
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
            drops.add(new ItemStack(Items.JUNGLE_SAPLING, dropCount)); // Drop 1 blaze rod
        }
        drops.add(new ItemStack(Items.JUNGLE_LOG));
        if (serverWorld.random.nextDouble() < .005) {
            drops.add(new ItemStack(Items.STRIPPED_JUNGLE_LOG));
        }

        drops.add(new ItemStack(Items.JUNGLE_LEAVES));
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

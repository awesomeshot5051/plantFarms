package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.miscellaneous;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
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

public class mushroomFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {


    protected NonNullList<ItemStack> inventory;
    protected long timer;

    public Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments = initializeHoeEnchantments();
    public ItemStack hoeType = new ItemStack(Items.WOODEN_HOE);
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;


    public mushroomFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.MUSHROOM_FARM.get(), ModBlocks.MUSHROOM_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getMushroomSpawnTime() {
        return Main.SERVER_CONFIG.mushroomSpawnTime.get() - 20 * 4;
    }

    public static int getMushroomDeathTime() {
        return getMushroomSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {

        timer++;
        setChanged();

        if (timer == getMushroomSpawnTime()) {
            sync();
//            }
        } else if (timer >= getMushroomDeathTime()) {
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
        drops.add(new ItemStack(Items.BROWN_MUSHROOM, dropCount)); // Drop 1 blaze rod
        if (serverWorld.random.nextFloat() < .05) {
            drops.add(new ItemStack(Items.MUSHROOM_STEM, dropCount)); // Drop 1 blaze rod
        }
        if (serverWorld.random.nextFloat() < .005) {
            drops.add(new ItemStack(Items.MUSHROOM_STEM, dropCount));
        }

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

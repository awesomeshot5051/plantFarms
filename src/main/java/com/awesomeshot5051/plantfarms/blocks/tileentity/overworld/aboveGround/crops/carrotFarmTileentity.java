package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops;

import com.awesomeshot5051.corelib.blockentity.*;
import com.awesomeshot5051.corelib.inventory.*;
import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.awesomeshot5051.plantfarms.enums.*;
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

public class carrotFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    protected NonNullList<ItemStack> inventory;
    protected long timer;
    public Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments = initializeHoeEnchantments();
    public ItemStack hoeType = new ItemStack(Items.WOODEN_HOE);
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public carrotFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.CARROT_FARM.get(), ModBlocks.CARROT_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static double getCarrotSpawnTime(carrotFarmTileentity farm) {
        HoeType hoe = HoeType.fromItem(farm.getHoeType().getItem());
        return (double) Main.SERVER_CONFIG.carrotSpawnTime.get() / (hoe.equals(HoeType.NETHERITE) ? 30 : hoe.equals(HoeType.DIAMOND) ? 25 : hoe.equals(HoeType.GOLDEN) ? 20 : hoe.equals(HoeType.IRON) ? 15 : hoe.equals(HoeType.STONE) ? 10 : 1);
    }

    public static double getCarrotDeathTime(carrotFarmTileentity farm) {
        HoeType hoe = HoeType.fromItem(farm.getHoeType().getItem());
        if (farm.getHoeType().isEnchanted()) {
            farm.setHoeEnchantmentStatus(farm);
        }
        int baseValue = 20;
        if (HoeEnchantments.getHoeEnchantmentStatus(farm.hoeEnchantments, Enchantments.EFFICIENCY)) {
            baseValue = 10;
        }
        return getCarrotSpawnTime(farm) + (hoe.equals(HoeType.NETHERITE) ? (baseValue * 3.2) : hoe.equals(HoeType.DIAMOND) ? (baseValue * 5.6) : hoe.equals(HoeType.IRON) ? (baseValue * 4.8) : hoe.equals(HoeType.STONE) ? (baseValue * 6.4) : hoe.equals(HoeType.WOODEN) ? (baseValue * 6.4) : 6.4);
    }

    public long getTimer() {
        return timer;
    }

    protected Map<ResourceKey<Enchantment>, Boolean> getHoeEnchantments() {
        return hoeEnchantments;
    }

    @Override
    public ItemStack getHoeType() {
        return hoeType;
    }


    @Override
    public void tick() {
        timer++;
        setChanged();
        if (timer == getCarrotSpawnTime(this)) {
            sync();
        } else if (timer >= getCarrotDeathTime(this)) {
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
        drops.add(new ItemStack(Items.CARROT));
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
            hoeTypeTag.putString("id", BuiltInRegistries.ITEM.getKey(hoeType.getItem()).toString());
            hoeTypeTag.putInt("count", hoeType.getCount());
            compound.put("HoeType", hoeTypeTag);
        }
        if (!hoeEnchantments.isEmpty()) {
            ListTag enchantmentsList = new ListTag();
            for (Map.Entry<ResourceKey<Enchantment>, Boolean> entry : hoeEnchantments.entrySet()) {
                if (entry.getValue()) {
                    CompoundTag enchantmentTag = new CompoundTag();
                    enchantmentTag.putString("id", entry.getKey().location().toString());
                    enchantmentsList.add(enchantmentTag);
                }
            }
            compound.put("HoeEnchantments", enchantmentsList);
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
        if (compound.contains("HoeEnchantments")) {
            hoeEnchantments = SyncableTileentity.loadHoeEnchantments(compound, provider, this);
        }
        if (hoeType == null) {
            hoeType = new ItemStack(Items.WOODEN_HOE);
        }
        timer = compound.getLong("Timer");
        super.loadAdditional(compound, provider);
    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }
}
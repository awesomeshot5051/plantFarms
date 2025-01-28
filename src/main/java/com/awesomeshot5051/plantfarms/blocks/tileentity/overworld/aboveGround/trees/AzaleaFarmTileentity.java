package com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees;

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

import static com.awesomeshot5051.plantfarms.datacomponents.AxeEnchantments.*;

public class AzaleaFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {
    protected NonNullList<ItemStack> inventory;
    protected long timer;
    public Map<ResourceKey<Enchantment>, Boolean> axeEnchantments = initializeAxeEnchantments();
    public ItemStack axeType = new ItemStack(Items.WOODEN_AXE);
    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public AzaleaFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.AZALEA_FARM.get(), ModBlocks.AZALEA_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static double getAzaleaSpawnTime(AzaleaFarmTileentity farm) {
        AxeType axe = AxeType.fromItem(farm.getAxeType().getItem());
        return (double) Main.SERVER_CONFIG.azaleaSpawnTime.get() / (axe.equals(AxeType.NETHERITE) ? 30 : axe.equals(AxeType.DIAMOND) ? 25 : axe.equals(AxeType.GOLDEN) ? 20 : axe.equals(AxeType.IRON) ? 15 : axe.equals(AxeType.STONE) ? 10 : 1);
    }

    public static double getAzaleaDeathTime(AzaleaFarmTileentity farm) {
        AxeType axe = AxeType.fromItem(farm.getAxeType().getItem());
        if (farm.getAxeType().isEnchanted()) {
            farm.setAxeEnchantmentStatus(farm);
        }
        int baseValue = 20;
        if (AxeEnchantments.getAxeEnchantmentStatus(farm.axeEnchantments, Enchantments.EFFICIENCY)) {
            baseValue = 10;
        }
        return getAzaleaSpawnTime(farm) + (axe.equals(AxeType.NETHERITE) ? (baseValue * 3.2) : axe.equals(AxeType.DIAMOND) ? (baseValue * 5.6) : axe.equals(AxeType.IRON) ? (baseValue * 4.8) : axe.equals(AxeType.STONE) ? (baseValue * 6.4) : axe.equals(AxeType.WOODEN) ? (baseValue * 6.4) : 6.4);
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        timer++;
        setChanged();
        if (timer == getAzaleaSpawnTime(this)) {
            sync();
        } else if (timer >= getAzaleaDeathTime(this)) {
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
        double dropChance = 0.5;
        List<ItemStack> drops = new ArrayList<>();
        if (serverWorld.random.nextDouble() < dropChance) {
            int dropCount = serverWorld.random.nextIntBetweenInclusive(1, 4);
            drops.add(new ItemStack(Items.AZALEA, dropCount));
        }
        if (serverWorld.random.nextDouble() < .005) {
            drops.add(new ItemStack(Items.STRIPPED_OAK_LOG));
            drops.add(new ItemStack(Items.FLOWERING_AZALEA_LEAVES));
        }
        drops.add(new ItemStack(Items.AZALEA_LEAVES));
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
            axeTypeTag.putString("id", BuiltInRegistries.ITEM.getKey(axeType.getItem()).toString());
            axeTypeTag.putInt("count", axeType.getCount());
            compound.put("AxeType", axeTypeTag);
        }
        if (!axeEnchantments.isEmpty()) {
            ListTag enchantmentsList = new ListTag();
            for (Map.Entry<ResourceKey<Enchantment>, Boolean> entry : axeEnchantments.entrySet()) {
                if (entry.getValue()) {
                    CompoundTag enchantmentTag = new CompoundTag();
                    enchantmentTag.putString("id", entry.getKey().location().toString());
                    enchantmentsList.add(enchantmentTag);
                }
            }
            compound.put("AxeEnchantments", enchantmentsList);
        }
        ContainerHelper.saveAllItems(compound, inventory, false, provider);
        compound.putLong("Timer", timer);
    }

    public ItemStack getAxeType() {
        return axeType;
    }

    protected Map<ResourceKey<Enchantment>, Boolean> getAxeEnchantments() {
        return axeEnchantments;
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        ContainerHelper.loadAllItems(compound, inventory, provider);
        if (compound.contains("AxeType")) {
            SyncableTileentity.loadAxeType(compound, provider).ifPresent(stack -> this.axeType = stack);
        }
        if (compound.contains("AxeEnchantments")) {
            axeEnchantments = SyncableTileentity.loadAxeEnchantments(compound, provider, this);
        }
        if (axeType == null) {
            axeType = new ItemStack(Items.WOODEN_AXE);
        }
        timer = compound.getLong("Timer");
        super.loadAdditional(compound, provider);
    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }
}
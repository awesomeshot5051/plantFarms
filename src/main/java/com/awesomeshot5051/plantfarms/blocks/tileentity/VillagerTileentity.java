package com.awesomeshot5051.plantfarms.blocks.tileentity;

//import com.awesomeshot5051.plantfarms.datacomponents.VillagerData;

import com.awesomeshot5051.plantfarms.datacomponents.AxeEnchantments;
import com.awesomeshot5051.plantfarms.datacomponents.HoeEnchantments;
import com.awesomeshot5051.plantfarms.datacomponents.VillagerData;
import com.awesomeshot5051.plantfarms.entity.EasyVillagerEntity;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.Map;

public class VillagerTileentity extends FakeWorldTileentity {

    protected ItemStack villager;
    protected EasyVillagerEntity villagerEntity;

    public VillagerTileentity(BlockEntityType<?> type, BlockState defaultState, BlockPos pos, BlockState state) {
        super(type, defaultState, pos, state);
        villager = ItemStack.EMPTY;
    }

    public boolean hasVillager() {
        return !villager.isEmpty();
    }

    @Nullable
    public EasyVillagerEntity getVillagerEntity() {
        if (villagerEntity == null && !villager.isEmpty()) {
            villagerEntity = VillagerData.createEasyVillager(villager, level);
        }
        return villagerEntity;
    }

    public ItemStack getHoeType() {
        return ItemStack.EMPTY;
    }

    public ItemStack getAxeType() {
        return ItemStack.EMPTY;
    }

    public <T extends VillagerTileentity> void setHoeEnchantmentStatus(T farm) {
        Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments = farm.getHoeEnchantments();
        ItemEnchantments enchantments = farm.getHoeType().getTagEnchantments();
        for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantments.entrySet()) {
            // Check and toggle enchantments based on their presence in the map
            if (entry.getKey().is(Enchantments.MENDING.location())) {
                HoeEnchantments.toggleHoeEnchantment(hoeEnchantments, Enchantments.MENDING, true);
            } else if (entry.getKey().is(Enchantments.EFFICIENCY.location())) {
                HoeEnchantments.toggleHoeEnchantment(hoeEnchantments, Enchantments.EFFICIENCY, true);
            } else if (entry.getKey().is(Enchantments.UNBREAKING.location())) {
                HoeEnchantments.toggleHoeEnchantment(hoeEnchantments, Enchantments.UNBREAKING, true);
            } else if (entry.getKey().is(Enchantments.FORTUNE.location())) {
                HoeEnchantments.toggleHoeEnchantment(hoeEnchantments, Enchantments.FORTUNE, true);
            } else if (entry.getKey().is(Enchantments.SILK_TOUCH.location())) {
                HoeEnchantments.toggleHoeEnchantment(hoeEnchantments, Enchantments.SILK_TOUCH, true);
            }
        }

    }

    public <T extends VillagerTileentity> void setAxeEnchantmentStatus(T farm) {
        Map<ResourceKey<Enchantment>, Boolean> axeEnchantments = farm.getAxeEnchantments();
        ItemEnchantments enchantments = farm.getAxeType().getTagEnchantments();
        for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantments.entrySet()) {
            // Check and toggle enchantments based on their presence in the map
            if (entry.getKey().is(Enchantments.MENDING.location())) {
                AxeEnchantments.toggleAxeEnchantment(axeEnchantments, Enchantments.MENDING, true);
            } else if (entry.getKey().is(Enchantments.EFFICIENCY.location())) {
                AxeEnchantments.toggleAxeEnchantment(axeEnchantments, Enchantments.EFFICIENCY, true);
            } else if (entry.getKey().is(Enchantments.UNBREAKING.location())) {
                AxeEnchantments.toggleAxeEnchantment(axeEnchantments, Enchantments.UNBREAKING, true);
            } else if (entry.getKey().is(Enchantments.FORTUNE.location())) {
                AxeEnchantments.toggleAxeEnchantment(axeEnchantments, Enchantments.FORTUNE, true);
            } else if (entry.getKey().is(Enchantments.SILK_TOUCH.location())) {
                AxeEnchantments.toggleAxeEnchantment(axeEnchantments, Enchantments.SILK_TOUCH, true);
            }
        }
    }

    protected Map<ResourceKey<Enchantment>, Boolean> getHoeEnchantments() {
        return null;
    }

    protected Map<ResourceKey<Enchantment>, Boolean> getAxeEnchantments() {
        return null;
    }

    protected void onAddVillager(EasyVillagerEntity villager) {

    }

}

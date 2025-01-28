package com.awesomeshot5051.plantfarms.blocks.tileentity;

import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.awesomeshot5051.plantfarms.entity.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.core.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

import javax.annotation.*;
import java.util.*;

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
}
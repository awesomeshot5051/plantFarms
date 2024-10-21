package com.awesomeshot5051.plantfarms.blocks.tileentity;

//import com.awesomeshot5051.plantfarms.datacomponents.VillagerData;
import com.awesomeshot5051.plantfarms.datacomponents.VillagerData;
import com.awesomeshot5051.plantfarms.entity.EasyVillagerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

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

        protected void onAddVillager(EasyVillagerEntity villager) {

    }

}

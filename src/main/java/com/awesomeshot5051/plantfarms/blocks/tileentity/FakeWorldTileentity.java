package com.awesomeshot5051.plantfarms.blocks.tileentity;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import org.jetbrains.annotations.*;

public class FakeWorldTileentity extends SyncableTileentity {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected boolean fakeWorld;
    protected BlockState defaultState;

    public FakeWorldTileentity(BlockEntityType<?> type, BlockState defaultState, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.defaultState = defaultState;
    }

    public void setFakeWorld(Level w) {
        level = w;
        fakeWorld = true;
    }

    public boolean isFakeWorld() {
        return fakeWorld;
    }

    @Override
    public @NotNull BlockState getBlockState() {
        if (fakeWorld) {
            return defaultState;
        }
        return super.getBlockState();
    }
}
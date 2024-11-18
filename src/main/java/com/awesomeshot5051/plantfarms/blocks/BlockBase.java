package com.awesomeshot5051.plantfarms.blocks;

import de.maxhenkel.corelib.block.VoxelUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class BlockBase extends HorizontalRotatableBlock {

    private static final VoxelShape SHAPE = VoxelUtils.combine(
            Block.box(0D, 0D, 0D, 16D, 1D, 16D),
            Block.box(0D, 15D, 0D, 16D, 16D, 16D),
            Block.box(0D, 0D, 0D, 1D, 16D, 16D),
            Block.box(15D, 0D, 0D, 16D, 16D, 16D),
            Block.box(0D, 0D, 0D, 16D, 16D, 1D),
            Block.box(0D, 0D, 15D, 16D, 16D, 16D)
    );

    public BlockBase(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

}

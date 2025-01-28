package com.awesomeshot5051.plantfarms.blocks;

import com.awesomeshot5051.corelib.block.*;
import com.awesomeshot5051.plantfarms.*;
import net.minecraft.core.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.*;

public class BlockBase extends HorizontalRotatableBlock {
    private static final VoxelShape SHAPE = VoxelUtils.combine(Block.box(0D, 0D, 0D, 16D, 1D, 16D), Block.box(0D, 15D, 0D, 16D, 16D, 16D), Block.box(0D, 0D, 0D, 1D, 16D, 16D), Block.box(15D, 0D, 0D, 16D, 16D, 16D), Block.box(0D, 0D, 0D, 16D, 16D, 1D), Block.box(0D, 0D, 15D, 16D, 16D, 16D));

    public BlockBase(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    public static Item createItemWithDynamicRenderer(Block block) {
        Main.LOGGER.debug("Not using this method because you are on a server");
        return null;
    }
}
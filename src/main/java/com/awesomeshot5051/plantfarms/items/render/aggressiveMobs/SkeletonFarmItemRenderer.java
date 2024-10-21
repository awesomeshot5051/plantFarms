package com.awesomeshot5051.plantfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.SkeletonFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.SkeletonFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SkeletonFarmItemRenderer extends BlockItemRendererBase<SkeletonFarmRenderer, SkeletonFarmTileentity> {

    public SkeletonFarmItemRenderer() {
        super(SkeletonFarmRenderer::new, () -> new SkeletonFarmTileentity(BlockPos.ZERO, ModBlocks.SKELETON_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.nether.warpedForest;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.warpedForest.warpedFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.warpedForest.warpedFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class warpedFarmItemRenderer extends BlockItemRendererBase<warpedFarmRenderer, warpedFarmTileentity> {

    public warpedFarmItemRenderer() {
        super(warpedFarmRenderer::new, () -> new warpedFarmTileentity(BlockPos.ZERO, ModBlocks.WARPED_FARM.get().defaultBlockState()));
    }

}

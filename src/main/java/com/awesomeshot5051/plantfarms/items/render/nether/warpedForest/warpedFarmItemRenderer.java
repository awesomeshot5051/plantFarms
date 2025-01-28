package com.awesomeshot5051.plantfarms.items.render.nether.warpedForest;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.warpedForest.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.warpedForest.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class warpedFarmItemRenderer extends BlockItemRendererBase<warpedFarmRenderer, warpedFarmTileentity> {
    public warpedFarmItemRenderer() {
        super(warpedFarmRenderer::new, () -> new warpedFarmTileentity(BlockPos.ZERO, ModBlocks.WARPED_FARM.get().defaultBlockState()));
    }
}
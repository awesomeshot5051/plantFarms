package com.awesomeshot5051.plantfarms.items.render.nether.crimsonForest;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.crimsonForest.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.crimsonForest.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class crimsonFarmItemRenderer extends BlockItemRendererBase<crimsonFarmRenderer, crimsonFarmTileentity> {
    public crimsonFarmItemRenderer() {
        super(crimsonFarmRenderer::new, () -> new crimsonFarmTileentity(BlockPos.ZERO, ModBlocks.CRIMSON_FARM.get().defaultBlockState()));
    }
}
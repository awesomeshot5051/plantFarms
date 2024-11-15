package com.awesomeshot5051.plantfarms.items.render.nether.crimsonForest;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.crimsonForest.crimsonFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.crimsonForest.crimsonFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class crimsonFarmItemRenderer extends BlockItemRendererBase<crimsonFarmRenderer, crimsonFarmTileentity> {

    public crimsonFarmItemRenderer() {
        super(crimsonFarmRenderer::new, () -> new crimsonFarmTileentity(BlockPos.ZERO, ModBlocks.CRIMSON_FARM.get().defaultBlockState()));
    }

}

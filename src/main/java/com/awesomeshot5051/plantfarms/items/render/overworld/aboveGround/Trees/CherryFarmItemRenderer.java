package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class CherryFarmItemRenderer extends BlockItemRendererBase<CherryFarmRenderer, CherryFarmTileentity> {
    public CherryFarmItemRenderer() {
        super(CherryFarmRenderer::new, () -> new CherryFarmTileentity(BlockPos.ZERO, ModBlocks.CHERRY_FARM.get().defaultBlockState()));
    }
}
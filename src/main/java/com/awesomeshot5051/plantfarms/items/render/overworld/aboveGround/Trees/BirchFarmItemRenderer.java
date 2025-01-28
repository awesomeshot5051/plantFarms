package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class BirchFarmItemRenderer extends BlockItemRendererBase<BirchFarmRenderer, BirchFarmTileentity> {
    public BirchFarmItemRenderer() {
        super(BirchFarmRenderer::new, () -> new BirchFarmTileentity(BlockPos.ZERO, ModBlocks.BIRCH_FARM.get().defaultBlockState()));
    }
}
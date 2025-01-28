package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class OakFarmItemRenderer extends BlockItemRendererBase<OakFarmRenderer, OakFarmTileentity> {
    public OakFarmItemRenderer() {
        super(OakFarmRenderer::new, () -> new OakFarmTileentity(BlockPos.ZERO, ModBlocks.OAK_FARM.get().defaultBlockState()));
    }
}
package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class pinkFarmItemRenderer extends BlockItemRendererBase<pinkFarmRenderer, pinkFarmTileentity> {
    public pinkFarmItemRenderer() {
        super(pinkFarmRenderer::new, () -> new pinkFarmTileentity(BlockPos.ZERO, ModBlocks.PINK_FARM.get().defaultBlockState()));
    }
}
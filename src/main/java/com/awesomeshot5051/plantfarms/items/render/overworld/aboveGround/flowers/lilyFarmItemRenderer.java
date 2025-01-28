package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class lilyFarmItemRenderer extends BlockItemRendererBase<lilyFarmRenderer, lilyFarmTileentity> {
    public lilyFarmItemRenderer() {
        super(lilyFarmRenderer::new, () -> new lilyFarmTileentity(BlockPos.ZERO, ModBlocks.LILY_FARM.get().defaultBlockState()));
    }
}
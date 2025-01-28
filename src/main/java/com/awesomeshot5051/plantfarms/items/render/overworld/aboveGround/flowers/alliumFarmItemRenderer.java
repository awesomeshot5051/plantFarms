package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class alliumFarmItemRenderer extends BlockItemRendererBase<alliumFarmRenderer, alliumFarmTileentity> {
    public alliumFarmItemRenderer() {
        super(alliumFarmRenderer::new, () -> new alliumFarmTileentity(BlockPos.ZERO, ModBlocks.ALLIUM_FARM.get().defaultBlockState()));
    }
}
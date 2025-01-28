package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class poppyFarmItemRenderer extends BlockItemRendererBase<poppyFarmRenderer, poppyFarmTileentity> {
    public poppyFarmItemRenderer() {
        super(poppyFarmRenderer::new, () -> new poppyFarmTileentity(BlockPos.ZERO, ModBlocks.POPPY_FARM.get().defaultBlockState()));
    }
}
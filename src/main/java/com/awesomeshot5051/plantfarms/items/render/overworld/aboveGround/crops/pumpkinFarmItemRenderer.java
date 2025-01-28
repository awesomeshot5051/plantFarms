package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class pumpkinFarmItemRenderer extends BlockItemRendererBase<pumpkinFarmRenderer, pumpkinFarmTileentity> {
    public pumpkinFarmItemRenderer() {
        super(pumpkinFarmRenderer::new, () -> new pumpkinFarmTileentity(BlockPos.ZERO, ModBlocks.PUMPKIN_FARM.get().defaultBlockState()));
    }
}
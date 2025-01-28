package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class daisyFarmItemRenderer extends BlockItemRendererBase<daisyFarmRenderer, daisyFarmTileentity> {
    public daisyFarmItemRenderer() {
        super(daisyFarmRenderer::new, () -> new daisyFarmTileentity(BlockPos.ZERO, ModBlocks.DAISY_FARM.get().defaultBlockState()));
    }
}
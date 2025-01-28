package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class potatoFarmItemRenderer extends BlockItemRendererBase<potatoFarmRenderer, potatoFarmTileentity> {
    public potatoFarmItemRenderer() {
        super(potatoFarmRenderer::new, () -> new potatoFarmTileentity(BlockPos.ZERO, ModBlocks.POTATO_FARM.get().defaultBlockState()));
    }
}
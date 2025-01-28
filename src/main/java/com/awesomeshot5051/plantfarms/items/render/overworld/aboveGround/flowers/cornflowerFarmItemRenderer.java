package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class cornflowerFarmItemRenderer extends BlockItemRendererBase<cornflowerFarmRenderer, cornflowerFarmTileentity> {
    public cornflowerFarmItemRenderer() {
        super(cornflowerFarmRenderer::new, () -> new cornflowerFarmTileentity(BlockPos.ZERO, ModBlocks.CORNFLOWER_FARM.get().defaultBlockState()));
    }
}
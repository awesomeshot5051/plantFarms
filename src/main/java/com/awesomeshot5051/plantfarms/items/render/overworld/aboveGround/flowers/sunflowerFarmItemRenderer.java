package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class sunflowerFarmItemRenderer extends BlockItemRendererBase<sunflowerFarmRenderer, sunflowerFarmTileentity> {
    public sunflowerFarmItemRenderer() {
        super(sunflowerFarmRenderer::new, () -> new sunflowerFarmTileentity(BlockPos.ZERO, ModBlocks.SUNFLOWER_FARM.get().defaultBlockState()));
    }
}
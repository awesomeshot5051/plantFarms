package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class bambooFarmItemRenderer extends BlockItemRendererBase<bambooFarmRenderer, bambooFarmTileentity> {
    public bambooFarmItemRenderer() {
        super(bambooFarmRenderer::new, () -> new bambooFarmTileentity(BlockPos.ZERO, ModBlocks.BAMBOO_FARM.get().defaultBlockState()));
    }
}
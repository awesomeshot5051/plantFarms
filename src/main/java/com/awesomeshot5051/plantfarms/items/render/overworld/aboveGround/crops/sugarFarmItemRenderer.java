package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class sugarFarmItemRenderer extends BlockItemRendererBase<sugarFarmRenderer, sugarFarmTileentity> {
    public sugarFarmItemRenderer() {
        super(sugarFarmRenderer::new, () -> new sugarFarmTileentity(BlockPos.ZERO, ModBlocks.SUGAR_FARM.get().defaultBlockState()));
    }
}
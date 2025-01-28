package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class lilacFarmItemRenderer extends BlockItemRendererBase<lilacFarmRenderer, lilacFarmTileentity> {
    public lilacFarmItemRenderer() {
        super(lilacFarmRenderer::new, () -> new lilacFarmTileentity(BlockPos.ZERO, ModBlocks.LILAC_FARM.get().defaultBlockState()));
    }
}
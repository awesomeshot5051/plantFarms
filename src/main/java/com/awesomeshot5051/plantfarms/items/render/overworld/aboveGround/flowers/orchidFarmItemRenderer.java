package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class orchidFarmItemRenderer extends BlockItemRendererBase<orchidFarmRenderer, orchidFarmTileentity> {
    public orchidFarmItemRenderer() {
        super(orchidFarmRenderer::new, () -> new orchidFarmTileentity(BlockPos.ZERO, ModBlocks.ORCHID_FARM.get().defaultBlockState()));
    }
}
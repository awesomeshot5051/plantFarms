package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class whiteFarmItemRenderer extends BlockItemRendererBase<whiteFarmRenderer, whiteFarmTileentity> {
    public whiteFarmItemRenderer() {
        super(whiteFarmRenderer::new, () -> new whiteFarmTileentity(BlockPos.ZERO, ModBlocks.WHITE_FARM.get().defaultBlockState()));
    }
}
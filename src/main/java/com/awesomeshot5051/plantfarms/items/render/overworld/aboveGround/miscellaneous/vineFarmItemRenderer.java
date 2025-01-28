package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.miscellaneous;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.miscellaneous.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.miscellaneous.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class vineFarmItemRenderer extends BlockItemRendererBase<vineFarmRenderer, vineFarmTileentity> {
    public vineFarmItemRenderer() {
        super(vineFarmRenderer::new, () -> new vineFarmTileentity(BlockPos.ZERO, ModBlocks.VINE_FARM.get().defaultBlockState()));
    }
}
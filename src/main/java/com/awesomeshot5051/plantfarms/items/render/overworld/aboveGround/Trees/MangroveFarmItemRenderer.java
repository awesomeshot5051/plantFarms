package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class MangroveFarmItemRenderer extends BlockItemRendererBase<MangroveFarmRenderer, MangroveFarmTileentity> {
    public MangroveFarmItemRenderer() {
        super(MangroveFarmRenderer::new, () -> new MangroveFarmTileentity(BlockPos.ZERO, ModBlocks.MANGROVE_FARM.get().defaultBlockState()));
    }
}
package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class SpruceFarmItemRenderer extends BlockItemRendererBase<SpruceFarmRenderer, SpruceFarmTileentity> {
    public SpruceFarmItemRenderer() {
        super(SpruceFarmRenderer::new, () -> new SpruceFarmTileentity(BlockPos.ZERO, ModBlocks.SPRUCE_FARM.get().defaultBlockState()));
    }
}
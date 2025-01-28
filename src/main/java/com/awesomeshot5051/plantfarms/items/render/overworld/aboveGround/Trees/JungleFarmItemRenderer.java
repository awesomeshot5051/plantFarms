package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class JungleFarmItemRenderer extends BlockItemRendererBase<JungleFarmRenderer, JungleFarmTileentity> {
    public JungleFarmItemRenderer() {
        super(JungleFarmRenderer::new, () -> new JungleFarmTileentity(BlockPos.ZERO, ModBlocks.JUNGLE_FARM.get().defaultBlockState()));
    }
}
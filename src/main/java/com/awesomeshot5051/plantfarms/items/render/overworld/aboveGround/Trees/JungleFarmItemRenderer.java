package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.JungleFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.JungleFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class JungleFarmItemRenderer extends BlockItemRendererBase<JungleFarmRenderer, JungleFarmTileentity> {

    public JungleFarmItemRenderer() {
        super(JungleFarmRenderer::new, () -> new JungleFarmTileentity(BlockPos.ZERO, ModBlocks.JUNGLE_FARM.get().defaultBlockState()));
    }

}

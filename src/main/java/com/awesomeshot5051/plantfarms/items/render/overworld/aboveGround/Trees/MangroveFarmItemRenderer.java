package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.MangroveFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.MangroveFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class MangroveFarmItemRenderer extends BlockItemRendererBase<MangroveFarmRenderer, MangroveFarmTileentity> {

    public MangroveFarmItemRenderer() {
        super(MangroveFarmRenderer::new, () -> new MangroveFarmTileentity(BlockPos.ZERO, ModBlocks.MANGROVE_FARM.get().defaultBlockState()));
    }

}

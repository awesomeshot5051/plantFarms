package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.miscellaneous;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.miscellaneous.vineFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.miscellaneous.vineFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class vineFarmItemRenderer extends BlockItemRendererBase<vineFarmRenderer, vineFarmTileentity> {

    public vineFarmItemRenderer() {
        super(vineFarmRenderer::new, () -> new vineFarmTileentity(BlockPos.ZERO, ModBlocks.VINE_FARM.get().defaultBlockState()));
    }

}

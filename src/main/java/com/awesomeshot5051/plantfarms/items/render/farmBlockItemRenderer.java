package com.awesomeshot5051.plantfarms.items.render;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.farmBlockTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.farmBlockRenderer;
import net.minecraft.core.BlockPos;

public class farmBlockItemRenderer extends BlockItemRendererBase<farmBlockRenderer, farmBlockTileentity> {

    public farmBlockItemRenderer() {
        super(farmBlockRenderer::new, () -> new farmBlockTileentity(BlockPos.ZERO, ModBlocks.FARM_BLOCK.get().defaultBlockState()));
    }

}
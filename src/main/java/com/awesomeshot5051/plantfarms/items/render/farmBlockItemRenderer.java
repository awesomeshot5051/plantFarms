package com.awesomeshot5051.plantfarms.items.render;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import net.minecraft.core.*;

public class farmBlockItemRenderer extends BlockItemRendererBase<farmBlockRenderer, farmBlockTileentity> {
    public farmBlockItemRenderer() {
        super(farmBlockRenderer::new, () -> new farmBlockTileentity(BlockPos.ZERO, ModBlocks.FARM_BLOCK.get().defaultBlockState()));
    }
}
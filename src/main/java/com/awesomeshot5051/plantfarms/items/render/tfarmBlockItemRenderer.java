package com.awesomeshot5051.plantfarms.items.render;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import net.minecraft.core.*;

public class tfarmBlockItemRenderer extends BlockItemRendererBase<tfarmBlockRenderer, tfarmBlockTileentity> {
    public tfarmBlockItemRenderer() {
        super(tfarmBlockRenderer::new, () -> new tfarmBlockTileentity(BlockPos.ZERO, ModBlocks.TFARM_BLOCK.get().defaultBlockState()));
    }
}
package com.awesomeshot5051.plantfarms.items.render;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.tfarmBlockRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.tfarmBlockTileentity;
import net.minecraft.core.BlockPos;

public class tfarmBlockItemRenderer extends BlockItemRendererBase<tfarmBlockRenderer, tfarmBlockTileentity> {

    public tfarmBlockItemRenderer() {
        super(tfarmBlockRenderer::new, () -> new tfarmBlockTileentity(BlockPos.ZERO, ModBlocks.TFARM_BLOCK.get().defaultBlockState()));
    }

}
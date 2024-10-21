package com.awesomeshot5051.plantfarms.items.render;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.InventoryViewerTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.InventoryViewerRenderer;
import net.minecraft.core.BlockPos;

public class InventoryViewerItemRenderer extends BlockItemRendererBase<InventoryViewerRenderer, InventoryViewerTileentity> {

    public InventoryViewerItemRenderer() {
        super(InventoryViewerRenderer::new, () -> new InventoryViewerTileentity(BlockPos.ZERO, ModBlocks.INVENTORY_VIEWER.get().defaultBlockState()));
    }

}

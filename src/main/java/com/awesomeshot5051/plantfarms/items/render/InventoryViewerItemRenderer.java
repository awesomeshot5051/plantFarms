package com.awesomeshot5051.plantfarms.items.render;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import net.minecraft.core.*;

public class InventoryViewerItemRenderer extends BlockItemRendererBase<InventoryViewerRenderer, InventoryViewerTileentity> {
    public InventoryViewerItemRenderer() {
        super(InventoryViewerRenderer::new, () -> new InventoryViewerTileentity(BlockPos.ZERO, ModBlocks.INVENTORY_VIEWER.get().defaultBlockState()));
    }
}
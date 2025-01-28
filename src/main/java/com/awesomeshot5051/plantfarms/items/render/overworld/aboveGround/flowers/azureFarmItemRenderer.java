package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class azureFarmItemRenderer extends BlockItemRendererBase<azureFarmRenderer, azureFarmTileentity> {
    public azureFarmItemRenderer() {
        super(azureFarmRenderer::new, () -> new azureFarmTileentity(BlockPos.ZERO, ModBlocks.AZURE_FARM.get().defaultBlockState()));
    }
}
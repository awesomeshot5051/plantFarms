package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.azureFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.azureFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class azureFarmItemRenderer extends BlockItemRendererBase<azureFarmRenderer, azureFarmTileentity> {

    public azureFarmItemRenderer() {
        super(azureFarmRenderer::new, () -> new azureFarmTileentity(BlockPos.ZERO, ModBlocks.AZURE_FARM.get().defaultBlockState()));
    }

}

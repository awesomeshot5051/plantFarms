package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.lilyFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.lilyFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class lilyFarmItemRenderer extends BlockItemRendererBase<lilyFarmRenderer, lilyFarmTileentity> {

    public lilyFarmItemRenderer() {
        super(lilyFarmRenderer::new, () -> new lilyFarmTileentity(BlockPos.ZERO, ModBlocks.LILY_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.pinkFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.pinkFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class pinkFarmItemRenderer extends BlockItemRendererBase<pinkFarmRenderer, pinkFarmTileentity> {

    public pinkFarmItemRenderer() {
        super(pinkFarmRenderer::new, () -> new pinkFarmTileentity(BlockPos.ZERO, ModBlocks.PINK_FARM.get().defaultBlockState()));
    }

}

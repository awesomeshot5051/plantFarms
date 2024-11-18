package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.whiteFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.whiteFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class whiteFarmItemRenderer extends BlockItemRendererBase<whiteFarmRenderer, whiteFarmTileentity> {

    public whiteFarmItemRenderer() {
        super(whiteFarmRenderer::new, () -> new whiteFarmTileentity(BlockPos.ZERO, ModBlocks.WHITE_FARM.get().defaultBlockState()));
    }

}

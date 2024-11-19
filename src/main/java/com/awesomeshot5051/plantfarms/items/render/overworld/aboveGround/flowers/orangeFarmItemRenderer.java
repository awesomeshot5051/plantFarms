package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.orangeFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.orangeFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class orangeFarmItemRenderer extends BlockItemRendererBase<orangeFarmRenderer, orangeFarmTileentity> {

    public orangeFarmItemRenderer() {
        super(orangeFarmRenderer::new, () -> new orangeFarmTileentity(BlockPos.ZERO, ModBlocks.ORANGE_FARM.get().defaultBlockState()));
    }

}

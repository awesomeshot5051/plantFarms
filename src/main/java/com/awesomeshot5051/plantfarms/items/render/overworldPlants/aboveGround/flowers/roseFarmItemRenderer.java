package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.roseFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.roseFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class roseFarmItemRenderer extends BlockItemRendererBase<roseFarmRenderer, roseFarmTileentity> {

    public roseFarmItemRenderer() {
        super(roseFarmRenderer::new, () -> new roseFarmTileentity(BlockPos.ZERO, ModBlocks.ROSE_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class roseFarmItemRenderer extends BlockItemRendererBase<roseFarmRenderer, roseFarmTileentity> {
    public roseFarmItemRenderer() {
        super(roseFarmRenderer::new, () -> new roseFarmTileentity(BlockPos.ZERO, ModBlocks.ROSE_FARM.get().defaultBlockState()));
    }
}
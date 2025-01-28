package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class orangeFarmItemRenderer extends BlockItemRendererBase<orangeFarmRenderer, orangeFarmTileentity> {
    public orangeFarmItemRenderer() {
        super(orangeFarmRenderer::new, () -> new orangeFarmTileentity(BlockPos.ZERO, ModBlocks.ORANGE_FARM.get().defaultBlockState()));
    }
}
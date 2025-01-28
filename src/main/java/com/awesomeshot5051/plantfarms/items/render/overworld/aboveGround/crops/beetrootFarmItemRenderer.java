package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class beetrootFarmItemRenderer extends BlockItemRendererBase<beetrootFarmRenderer, beetrootFarmTileentity> {
    public beetrootFarmItemRenderer() {
        super(beetrootFarmRenderer::new, () -> new beetrootFarmTileentity(BlockPos.ZERO, ModBlocks.BEETROOT_FARM.get().defaultBlockState()));
    }
}
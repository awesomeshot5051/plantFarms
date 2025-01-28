package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class AcaciaFarmItemRenderer extends BlockItemRendererBase<AcaciaFarmRenderer, AcaciaFarmTileentity> {
    public AcaciaFarmItemRenderer() {
        super(AcaciaFarmRenderer::new, () -> new AcaciaFarmTileentity(BlockPos.ZERO, ModBlocks.ACACIA_FARM.get().defaultBlockState()));
    }
}
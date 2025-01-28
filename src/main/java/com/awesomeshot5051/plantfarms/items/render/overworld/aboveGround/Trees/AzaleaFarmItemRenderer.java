package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class AzaleaFarmItemRenderer extends BlockItemRendererBase<AzaleaFarmRenderer, AzaleaFarmTileentity> {
    public AzaleaFarmItemRenderer() {
        super(AzaleaFarmRenderer::new, () -> new AzaleaFarmTileentity(BlockPos.ZERO, ModBlocks.AZALEA_FARM.get().defaultBlockState()));
    }
}
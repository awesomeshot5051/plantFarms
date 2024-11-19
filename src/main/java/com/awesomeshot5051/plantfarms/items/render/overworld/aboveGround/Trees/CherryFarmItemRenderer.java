package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.CherryFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.CherryFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class CherryFarmItemRenderer extends BlockItemRendererBase<CherryFarmRenderer, CherryFarmTileentity> {

    public CherryFarmItemRenderer() {
        super(CherryFarmRenderer::new, () -> new CherryFarmTileentity(BlockPos.ZERO, ModBlocks.CHERRY_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.BirchFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.BirchFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class BirchFarmItemRenderer extends BlockItemRendererBase<BirchFarmRenderer, BirchFarmTileentity> {

    public BirchFarmItemRenderer() {
        super(BirchFarmRenderer::new, () -> new BirchFarmTileentity(BlockPos.ZERO, ModBlocks.BIRCH_FARM.get().defaultBlockState()));
    }

}

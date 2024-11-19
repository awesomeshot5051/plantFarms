package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.OakFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.OakFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class OakFarmItemRenderer extends BlockItemRendererBase<OakFarmRenderer, OakFarmTileentity> {

    public OakFarmItemRenderer() {
        super(OakFarmRenderer::new, () -> new OakFarmTileentity(BlockPos.ZERO, ModBlocks.OAK_FARM.get().defaultBlockState()));
    }

}

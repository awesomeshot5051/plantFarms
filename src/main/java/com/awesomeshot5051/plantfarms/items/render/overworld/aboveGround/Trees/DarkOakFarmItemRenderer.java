package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.DarkOakFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.DarkOakFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class DarkOakFarmItemRenderer extends BlockItemRendererBase<DarkOakFarmRenderer, DarkOakFarmTileentity> {

    public DarkOakFarmItemRenderer() {
        super(DarkOakFarmRenderer::new, () -> new DarkOakFarmTileentity(BlockPos.ZERO, ModBlocks.DARK_OAK_FARM.get().defaultBlockState()));
    }

}

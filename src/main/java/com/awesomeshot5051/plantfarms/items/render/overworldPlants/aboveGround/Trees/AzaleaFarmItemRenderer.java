package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.AzaleaFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.AzaleaFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class AzaleaFarmItemRenderer extends BlockItemRendererBase<AzaleaFarmRenderer, AzaleaFarmTileentity> {

    public AzaleaFarmItemRenderer() {
        super(AzaleaFarmRenderer::new, () -> new AzaleaFarmTileentity(BlockPos.ZERO, ModBlocks.AZALEA_FARM.get().defaultBlockState()));
    }

}

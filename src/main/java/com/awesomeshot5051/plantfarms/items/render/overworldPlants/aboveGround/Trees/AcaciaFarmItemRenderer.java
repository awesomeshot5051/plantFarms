package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.AcaciaFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.AcaciaFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class AcaciaFarmItemRenderer extends BlockItemRendererBase<AcaciaFarmRenderer, AcaciaFarmTileentity> {

    public AcaciaFarmItemRenderer() {
        super(AcaciaFarmRenderer::new, () -> new AcaciaFarmTileentity(BlockPos.ZERO, ModBlocks.ACACIA_FARM.get().defaultBlockState()));
    }

}

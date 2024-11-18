package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.pumpkinFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.pumpkinFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class pumpkinFarmItemRenderer extends BlockItemRendererBase<pumpkinFarmRenderer, pumpkinFarmTileentity> {

    public pumpkinFarmItemRenderer() {
        super(pumpkinFarmRenderer::new, () -> new pumpkinFarmTileentity(BlockPos.ZERO, ModBlocks.PUMPKIN_FARM.get().defaultBlockState()));
    }

}

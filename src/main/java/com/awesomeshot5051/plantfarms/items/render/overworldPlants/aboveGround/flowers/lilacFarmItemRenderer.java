package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.lilacFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.lilacFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class lilacFarmItemRenderer extends BlockItemRendererBase<lilacFarmRenderer, lilacFarmTileentity> {

    public lilacFarmItemRenderer() {
        super(lilacFarmRenderer::new, () -> new lilacFarmTileentity(BlockPos.ZERO, ModBlocks.LILAC_FARM.get().defaultBlockState()));
    }

}

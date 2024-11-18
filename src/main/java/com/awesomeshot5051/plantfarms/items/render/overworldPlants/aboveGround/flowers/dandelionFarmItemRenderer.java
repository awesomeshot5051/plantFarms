package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.dandelionFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.dandelionFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class dandelionFarmItemRenderer extends BlockItemRendererBase<dandelionFarmRenderer, dandelionFarmTileentity> {

    public dandelionFarmItemRenderer() {
        super(dandelionFarmRenderer::new, () -> new dandelionFarmTileentity(BlockPos.ZERO, ModBlocks.DANDELION_FARM.get().defaultBlockState()));
    }

}

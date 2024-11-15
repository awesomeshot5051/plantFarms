package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.alliumFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.alliumFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class alliumFarmItemRenderer extends BlockItemRendererBase<alliumFarmRenderer, alliumFarmTileentity> {

    public alliumFarmItemRenderer() {
        super(alliumFarmRenderer::new, () -> new alliumFarmTileentity(BlockPos.ZERO, ModBlocks.ALLIUM_FARM.get().defaultBlockState()));
    }

}

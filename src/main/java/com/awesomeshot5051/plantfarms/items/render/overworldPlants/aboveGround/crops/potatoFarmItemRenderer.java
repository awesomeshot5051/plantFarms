package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.potatoFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.potatoFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class potatoFarmItemRenderer extends BlockItemRendererBase<potatoFarmRenderer, potatoFarmTileentity> {

    public potatoFarmItemRenderer() {
        super(potatoFarmRenderer::new, () -> new potatoFarmTileentity(BlockPos.ZERO, ModBlocks.POTATO_FARM.get().defaultBlockState()));
    }

}

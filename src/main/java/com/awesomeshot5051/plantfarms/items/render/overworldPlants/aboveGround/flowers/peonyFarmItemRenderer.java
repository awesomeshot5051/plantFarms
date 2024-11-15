package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.peonyFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.peonyFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class peonyFarmItemRenderer extends BlockItemRendererBase<peonyFarmRenderer, peonyFarmTileentity> {

    public peonyFarmItemRenderer() {
        super(peonyFarmRenderer::new, () -> new peonyFarmTileentity(BlockPos.ZERO, ModBlocks.PEONY_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.daisyFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.daisyFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class daisyFarmItemRenderer extends BlockItemRendererBase<daisyFarmRenderer, daisyFarmTileentity> {

    public daisyFarmItemRenderer() {
        super(daisyFarmRenderer::new, () -> new daisyFarmTileentity(BlockPos.ZERO, ModBlocks.DAISY_FARM.get().defaultBlockState()));
    }

}

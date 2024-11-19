package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.bambooFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.bambooFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class bambooFarmItemRenderer extends BlockItemRendererBase<bambooFarmRenderer, bambooFarmTileentity> {

    public bambooFarmItemRenderer() {
        super(bambooFarmRenderer::new, () -> new bambooFarmTileentity(BlockPos.ZERO, ModBlocks.BAMBOO_FARM.get().defaultBlockState()));
    }

}

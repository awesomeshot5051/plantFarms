package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.sugarFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.sugarFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class sugarFarmItemRenderer extends BlockItemRendererBase<sugarFarmRenderer, sugarFarmTileentity> {

    public sugarFarmItemRenderer() {
        super(sugarFarmRenderer::new, () -> new sugarFarmTileentity(BlockPos.ZERO, ModBlocks.SUGAR_FARM.get().defaultBlockState()));
    }

}

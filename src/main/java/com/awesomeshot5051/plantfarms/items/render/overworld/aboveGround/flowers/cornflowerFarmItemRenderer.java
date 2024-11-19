package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.cornflowerFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.cornflowerFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class cornflowerFarmItemRenderer extends BlockItemRendererBase<cornflowerFarmRenderer, cornflowerFarmTileentity> {

    public cornflowerFarmItemRenderer() {
        super(cornflowerFarmRenderer::new, () -> new cornflowerFarmTileentity(BlockPos.ZERO, ModBlocks.CORNFLOWER_FARM.get().defaultBlockState()));
    }

}

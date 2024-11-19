package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.sunflowerFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.sunflowerFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class sunflowerFarmItemRenderer extends BlockItemRendererBase<sunflowerFarmRenderer, sunflowerFarmTileentity> {

    public sunflowerFarmItemRenderer() {
        super(sunflowerFarmRenderer::new, () -> new sunflowerFarmTileentity(BlockPos.ZERO, ModBlocks.SUNFLOWER_FARM.get().defaultBlockState()));
    }

}

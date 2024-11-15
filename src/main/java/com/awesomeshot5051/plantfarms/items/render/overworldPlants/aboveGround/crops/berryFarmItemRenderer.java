package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.berryFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.berryFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class berryFarmItemRenderer extends BlockItemRendererBase<berryFarmRenderer, berryFarmTileentity> {

    public berryFarmItemRenderer() {
        super(berryFarmRenderer::new, () -> new berryFarmTileentity(BlockPos.ZERO, ModBlocks.BERRY_FARM.get().defaultBlockState()));
    }

}

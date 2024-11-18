package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.carrotFarmTileentity;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.carrotFarmRenderer;
import net.minecraft.core.BlockPos;

public class carrotFarmItemRenderer extends BlockItemRendererBase<carrotFarmRenderer, carrotFarmTileentity> {

    public carrotFarmItemRenderer() {
        super(carrotFarmRenderer::new, () -> new carrotFarmTileentity(BlockPos.ZERO, ModBlocks.CARROT_FARM.get().defaultBlockState()));
    }

}

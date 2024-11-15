package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.cocoFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.cocoFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class cocoaFarmItemRenderer extends BlockItemRendererBase<cocoFarmRenderer, cocoFarmTileentity> {

    public cocoaFarmItemRenderer() {
        super(cocoFarmRenderer::new, () -> new cocoFarmTileentity(BlockPos.ZERO, ModBlocks.COCO_FARM.get().defaultBlockState()));
    }

}

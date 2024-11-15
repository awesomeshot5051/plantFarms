package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.wheatFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.wheatFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class wheatFarmItemRenderer extends BlockItemRendererBase<wheatFarmRenderer, wheatFarmTileentity> {

    public wheatFarmItemRenderer() {
        super(wheatFarmRenderer::new, () -> new wheatFarmTileentity(BlockPos.ZERO, ModBlocks.WHEAT_FARM.get().defaultBlockState()));
    }

}

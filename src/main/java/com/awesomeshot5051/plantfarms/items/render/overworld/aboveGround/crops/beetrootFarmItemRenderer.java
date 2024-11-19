package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.beetrootFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.beetrootFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class beetrootFarmItemRenderer extends BlockItemRendererBase<beetrootFarmRenderer, beetrootFarmTileentity> {

    public beetrootFarmItemRenderer() {
        super(beetrootFarmRenderer::new, () -> new beetrootFarmTileentity(BlockPos.ZERO, ModBlocks.BEETROOT_FARM.get().defaultBlockState()));
    }

}

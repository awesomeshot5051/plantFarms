package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.redFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.redFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class redFarmItemRenderer extends BlockItemRendererBase<redFarmRenderer, redFarmTileentity> {

    public redFarmItemRenderer() {
        super(redFarmRenderer::new, () -> new redFarmTileentity(BlockPos.ZERO, ModBlocks.RED_FARM.get().defaultBlockState()));
    }

}

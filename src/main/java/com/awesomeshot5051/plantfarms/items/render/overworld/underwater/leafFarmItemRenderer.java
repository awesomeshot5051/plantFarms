package com.awesomeshot5051.plantfarms.items.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.leafFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.leafFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class leafFarmItemRenderer extends BlockItemRendererBase<leafFarmRenderer, leafFarmTileentity> {

    public leafFarmItemRenderer() {
        super(leafFarmRenderer::new, () -> new leafFarmTileentity(BlockPos.ZERO, ModBlocks.LEAF_FARM.get().defaultBlockState()));
    }

}

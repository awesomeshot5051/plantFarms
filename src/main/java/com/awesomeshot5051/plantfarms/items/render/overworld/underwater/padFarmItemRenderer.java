package com.awesomeshot5051.plantfarms.items.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.padFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.padFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class padFarmItemRenderer extends BlockItemRendererBase<padFarmRenderer, padFarmTileentity> {

    public padFarmItemRenderer() {
        super(padFarmRenderer::new, () -> new padFarmTileentity(BlockPos.ZERO, ModBlocks.PAD_FARM.get().defaultBlockState()));
    }

}

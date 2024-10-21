package com.awesomeshot5051.plantfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.HoglinFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.HoglinFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class HoglinFarmItemRenderer extends BlockItemRendererBase<HoglinFarmRenderer, HoglinFarmTileentity> {

    public HoglinFarmItemRenderer() {
        super(HoglinFarmRenderer::new, () -> new HoglinFarmTileentity(BlockPos.ZERO, ModBlocks.HOGLIN_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.OakFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.OakFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class OakFarmItemRenderer extends BlockItemRendererBase<OakFarmRenderer, OakFarmTileentity> {

    public OakFarmItemRenderer() {
        super(OakFarmRenderer::new, () -> new OakFarmTileentity(BlockPos.ZERO, ModBlocks.OAK_FARM.get().defaultBlockState()));
    }

}

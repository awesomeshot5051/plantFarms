package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.GhastFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.GhastFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class GhastFarmItemRenderer extends BlockItemRendererBase<GhastFarmRenderer, GhastFarmTileentity> {

    public GhastFarmItemRenderer() {
        super(GhastFarmRenderer::new, () -> new GhastFarmTileentity(BlockPos.ZERO, ModBlocks.GHAST_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.PillagerFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.PillagerFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class PillagerFarmItemRenderer extends BlockItemRendererBase<PillagerFarmRenderer, PillagerFarmTileentity> {

    public PillagerFarmItemRenderer() {
        super(PillagerFarmRenderer::new, () -> new PillagerFarmTileentity(BlockPos.ZERO, ModBlocks.PILLAGER_FARM.get().defaultBlockState()));
    }

}

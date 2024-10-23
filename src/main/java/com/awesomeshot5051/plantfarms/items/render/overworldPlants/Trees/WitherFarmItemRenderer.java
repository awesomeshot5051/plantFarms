package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.WitherFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.WitherFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class WitherFarmItemRenderer extends BlockItemRendererBase<WitherFarmRenderer, WitherFarmTileentity> {

    public WitherFarmItemRenderer() {
        super(WitherFarmRenderer::new, () -> new WitherFarmTileentity(BlockPos.ZERO, ModBlocks.WITHER_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.RavagerFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.RavagerFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class RavagerFarmItemRenderer extends BlockItemRendererBase<RavagerFarmRenderer, RavagerFarmTileentity> {

    public RavagerFarmItemRenderer() {
        super(RavagerFarmRenderer::new, () -> new RavagerFarmTileentity(BlockPos.ZERO, ModBlocks.RAVAGER_FARM.get().defaultBlockState()));
    }

}

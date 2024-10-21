package com.awesomeshot5051.plantfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.VindicatorFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.VindicatorFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class VindicatorFarmItemRenderer extends BlockItemRendererBase<VindicatorFarmRenderer, VindicatorFarmTileentity> {

    public VindicatorFarmItemRenderer() {
        super(VindicatorFarmRenderer::new, () -> new VindicatorFarmTileentity(BlockPos.ZERO, ModBlocks.VINDICATOR_FARM.get().defaultBlockState()));
    }

}

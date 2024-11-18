package com.awesomeshot5051.plantfarms.items.render.overworldPlants.underwater;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.kelpFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.kelpFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class kelpFarmItemRenderer extends BlockItemRendererBase<kelpFarmRenderer, kelpFarmTileentity> {

    public kelpFarmItemRenderer() {
        super(kelpFarmRenderer::new, () -> new kelpFarmTileentity(BlockPos.ZERO, ModBlocks.KELP_FARM.get().defaultBlockState()));
    }

}

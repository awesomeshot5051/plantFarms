package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.IllusionerFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.IllusionerFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class IllusionerFarmItemRenderer extends BlockItemRendererBase<IllusionerFarmRenderer, IllusionerFarmTileentity> {

    public IllusionerFarmItemRenderer() {
        super(IllusionerFarmRenderer::new, () -> new IllusionerFarmTileentity(BlockPos.ZERO, ModBlocks.ILLUSIONER_FARM.get().defaultBlockState()));
    }

}

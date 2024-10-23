package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.WitchFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.WitchFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class WitchFarmItemRenderer extends BlockItemRendererBase<WitchFarmRenderer, WitchFarmTileentity> {

    public WitchFarmItemRenderer() {
        super(WitchFarmRenderer::new, () -> new WitchFarmTileentity(BlockPos.ZERO, ModBlocks.WITCH_FARM.get().defaultBlockState()));
    }

}

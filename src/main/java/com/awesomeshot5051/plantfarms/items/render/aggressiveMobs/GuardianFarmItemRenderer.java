package com.awesomeshot5051.plantfarms.items.render.aggressiveMobs;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.GuardianFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.GuardianFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class GuardianFarmItemRenderer extends BlockItemRendererBase<GuardianFarmRenderer, GuardianFarmTileentity> {

    public GuardianFarmItemRenderer() {
        super(GuardianFarmRenderer::new, () -> new GuardianFarmTileentity(BlockPos.ZERO, ModBlocks.GUARDIAN_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.passiveMobs;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.MooshroomFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.MooshroomFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class MooshroomFarmItemRenderer extends BlockItemRendererBase<MooshroomFarmRenderer, MooshroomFarmTileentity> {
    public MooshroomFarmItemRenderer() {
        super(MooshroomFarmRenderer::new, () -> new MooshroomFarmTileentity(BlockPos.ZERO, ModBlocks.MOOSHROOM_FARM.get().defaultBlockState()));
    }
}

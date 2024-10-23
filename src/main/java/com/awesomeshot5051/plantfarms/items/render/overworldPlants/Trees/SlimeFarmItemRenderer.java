package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.SlimeFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.SlimeFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SlimeFarmItemRenderer extends BlockItemRendererBase<SlimeFarmRenderer, SlimeFarmTileentity> {

    public SlimeFarmItemRenderer() {
        super(SlimeFarmRenderer::new, () -> new SlimeFarmTileentity(BlockPos.ZERO, ModBlocks.SLIME_FARM.get().defaultBlockState()));
    }

}

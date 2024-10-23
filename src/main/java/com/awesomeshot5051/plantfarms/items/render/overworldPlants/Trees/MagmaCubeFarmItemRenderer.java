package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.MagmaCubeFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.MagmaCubeFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class MagmaCubeFarmItemRenderer extends BlockItemRendererBase<MagmaCubeFarmRenderer, MagmaCubeFarmTileentity> {

    public MagmaCubeFarmItemRenderer() {
        super(MagmaCubeFarmRenderer::new, () -> new MagmaCubeFarmTileentity(BlockPos.ZERO, ModBlocks.MAGMA_CUBE_FARM.get().defaultBlockState()));
    }

}

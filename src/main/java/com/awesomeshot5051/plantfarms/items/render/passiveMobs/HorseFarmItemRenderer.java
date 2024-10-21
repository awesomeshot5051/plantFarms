package com.awesomeshot5051.plantfarms.items.render.passiveMobs;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.HorseFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.HorseFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class HorseFarmItemRenderer extends BlockItemRendererBase<HorseFarmRenderer, HorseFarmTileentity> {

    public HorseFarmItemRenderer() {
        super(HorseFarmRenderer::new, () -> new HorseFarmTileentity(BlockPos.ZERO, ModBlocks.HORSE_FARM.get().defaultBlockState()));
    }

}

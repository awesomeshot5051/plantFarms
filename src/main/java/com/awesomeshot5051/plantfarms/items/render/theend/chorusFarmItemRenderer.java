package com.awesomeshot5051.plantfarms.items.render.theend;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend.ChorusFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.ChorusFarmTileentity;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class chorusFarmItemRenderer extends BlockItemRendererBase<ChorusFarmRenderer, ChorusFarmTileentity> {

    public chorusFarmItemRenderer() {
        super(ChorusFarmRenderer::new, () -> new ChorusFarmTileentity(BlockPos.ZERO, ModBlocks.CHORUS_FARM.get().defaultBlockState()));
    }

}

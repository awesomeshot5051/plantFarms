package com.awesomeshot5051.plantfarms.items.render.theend;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class chorusFarmItemRenderer extends BlockItemRendererBase<ChorusFarmRenderer, ChorusFarmTileentity> {
    public chorusFarmItemRenderer() {
        super(ChorusFarmRenderer::new, () -> new ChorusFarmTileentity(BlockPos.ZERO, ModBlocks.CHORUS_FARM.get().defaultBlockState()));
    }
}
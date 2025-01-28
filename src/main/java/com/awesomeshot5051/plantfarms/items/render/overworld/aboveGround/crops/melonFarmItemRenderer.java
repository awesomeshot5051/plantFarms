package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class melonFarmItemRenderer extends BlockItemRendererBase<melonFarmRenderer, melonFarmTileentity> {
    public melonFarmItemRenderer() {
        super(melonFarmRenderer::new, () -> new melonFarmTileentity(BlockPos.ZERO, ModBlocks.MELON_FARM.get().defaultBlockState()));
    }
}
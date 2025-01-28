package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class wheatFarmItemRenderer extends BlockItemRendererBase<wheatFarmRenderer, wheatFarmTileentity> {
    public wheatFarmItemRenderer() {
        super(wheatFarmRenderer::new, () -> new wheatFarmTileentity(BlockPos.ZERO, ModBlocks.WHEAT_FARM.get().defaultBlockState()));
    }
}
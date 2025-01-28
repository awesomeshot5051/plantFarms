package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class DarkOakFarmItemRenderer extends BlockItemRendererBase<DarkOakFarmRenderer, DarkOakFarmTileentity> {
    public DarkOakFarmItemRenderer() {
        super(DarkOakFarmRenderer::new, () -> new DarkOakFarmTileentity(BlockPos.ZERO, ModBlocks.DARK_OAK_FARM.get().defaultBlockState()));
    }
}
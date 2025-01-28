package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class redFarmItemRenderer extends BlockItemRendererBase<redFarmRenderer, redFarmTileentity> {
    public redFarmItemRenderer() {
        super(redFarmRenderer::new, () -> new redFarmTileentity(BlockPos.ZERO, ModBlocks.RED_FARM.get().defaultBlockState()));
    }
}
package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class dandelionFarmItemRenderer extends BlockItemRendererBase<dandelionFarmRenderer, dandelionFarmTileentity> {
    public dandelionFarmItemRenderer() {
        super(dandelionFarmRenderer::new, () -> new dandelionFarmTileentity(BlockPos.ZERO, ModBlocks.DANDELION_FARM.get().defaultBlockState()));
    }
}
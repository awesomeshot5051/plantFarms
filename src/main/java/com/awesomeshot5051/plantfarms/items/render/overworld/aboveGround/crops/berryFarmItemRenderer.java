package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class berryFarmItemRenderer extends BlockItemRendererBase<berryFarmRenderer, berryFarmTileentity> {
    public berryFarmItemRenderer() {
        super(berryFarmRenderer::new, () -> new berryFarmTileentity(BlockPos.ZERO, ModBlocks.BERRY_FARM.get().defaultBlockState()));
    }
}
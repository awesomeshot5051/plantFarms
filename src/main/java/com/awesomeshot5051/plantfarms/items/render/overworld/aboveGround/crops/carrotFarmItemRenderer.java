package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class carrotFarmItemRenderer extends BlockItemRendererBase<carrotFarmRenderer, carrotFarmTileentity> {
    public carrotFarmItemRenderer() {
        super(carrotFarmRenderer::new, () -> new carrotFarmTileentity(BlockPos.ZERO, ModBlocks.CARROT_FARM.get().defaultBlockState()));
    }
}
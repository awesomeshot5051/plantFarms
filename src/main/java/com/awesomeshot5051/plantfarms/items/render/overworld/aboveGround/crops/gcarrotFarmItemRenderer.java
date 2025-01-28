package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class gcarrotFarmItemRenderer extends BlockItemRendererBase<gcarrotFarmRenderer, gcarrotFarmTileentity> {
    public gcarrotFarmItemRenderer() {
        super(gcarrotFarmRenderer::new, () -> new gcarrotFarmTileentity(BlockPos.ZERO, ModBlocks.GCARROT_FARM.get().defaultBlockState()));
    }
}
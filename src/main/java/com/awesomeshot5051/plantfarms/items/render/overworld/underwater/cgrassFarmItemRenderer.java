package com.awesomeshot5051.plantfarms.items.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class cgrassFarmItemRenderer extends BlockItemRendererBase<cgrassFarmRenderer, cgrassFarmTileentity> {
    public cgrassFarmItemRenderer() {
        super(cgrassFarmRenderer::new, () -> new cgrassFarmTileentity(BlockPos.ZERO, ModBlocks.CGRASS_FARM.get().defaultBlockState()));
    }
}
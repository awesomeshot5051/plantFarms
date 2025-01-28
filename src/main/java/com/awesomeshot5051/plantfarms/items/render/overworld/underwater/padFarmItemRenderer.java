package com.awesomeshot5051.plantfarms.items.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class padFarmItemRenderer extends BlockItemRendererBase<padFarmRenderer, padFarmTileentity> {
    public padFarmItemRenderer() {
        super(padFarmRenderer::new, () -> new padFarmTileentity(BlockPos.ZERO, ModBlocks.PAD_FARM.get().defaultBlockState()));
    }
}
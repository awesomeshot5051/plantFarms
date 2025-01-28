package com.awesomeshot5051.plantfarms.items.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class leafFarmItemRenderer extends BlockItemRendererBase<leafFarmRenderer, leafFarmTileentity> {
    public leafFarmItemRenderer() {
        super(leafFarmRenderer::new, () -> new leafFarmTileentity(BlockPos.ZERO, ModBlocks.LEAF_FARM.get().defaultBlockState()));
    }
}
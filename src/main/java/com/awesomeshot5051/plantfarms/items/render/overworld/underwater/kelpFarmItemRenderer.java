package com.awesomeshot5051.plantfarms.items.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class kelpFarmItemRenderer extends BlockItemRendererBase<kelpFarmRenderer, kelpFarmTileentity> {
    public kelpFarmItemRenderer() {
        super(kelpFarmRenderer::new, () -> new kelpFarmTileentity(BlockPos.ZERO, ModBlocks.KELP_FARM.get().defaultBlockState()));
    }
}
package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class cocoaFarmItemRenderer extends BlockItemRendererBase<cocoFarmRenderer, cocoFarmTileentity> {
    public cocoaFarmItemRenderer() {
        super(cocoFarmRenderer::new, () -> new cocoFarmTileentity(BlockPos.ZERO, ModBlocks.COCO_FARM.get().defaultBlockState()));
    }
}
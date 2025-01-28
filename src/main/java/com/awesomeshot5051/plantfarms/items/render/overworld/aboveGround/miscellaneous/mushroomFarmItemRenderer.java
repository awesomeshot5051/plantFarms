package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.miscellaneous;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.miscellaneous.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.miscellaneous.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class mushroomFarmItemRenderer extends BlockItemRendererBase<mushroomFarmRenderer, mushroomFarmTileentity> {
    public mushroomFarmItemRenderer() {
        super(mushroomFarmRenderer::new, () -> new mushroomFarmTileentity(BlockPos.ZERO, ModBlocks.MUSHROOM_FARM.get().defaultBlockState()));
    }
}
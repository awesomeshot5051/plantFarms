package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.poppyFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.poppyFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class poppyFarmItemRenderer extends BlockItemRendererBase<poppyFarmRenderer, poppyFarmTileentity> {

    public poppyFarmItemRenderer() {
        super(poppyFarmRenderer::new, () -> new poppyFarmTileentity(BlockPos.ZERO, ModBlocks.POPPY_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.cgrassFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.cgrassFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class cgrassFarmItemRenderer extends BlockItemRendererBase<cgrassFarmRenderer, cgrassFarmTileentity> {

    public cgrassFarmItemRenderer() {
        super(cgrassFarmRenderer::new, () -> new cgrassFarmTileentity(BlockPos.ZERO, ModBlocks.CGRASS_FARM.get().defaultBlockState()));
    }

}

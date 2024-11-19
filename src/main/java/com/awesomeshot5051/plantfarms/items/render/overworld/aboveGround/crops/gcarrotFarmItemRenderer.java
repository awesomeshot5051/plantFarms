package com.awesomeshot5051.plantfarms.items.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.gcarrotFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.gcarrotFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class gcarrotFarmItemRenderer extends BlockItemRendererBase<gcarrotFarmRenderer, gcarrotFarmTileentity> {

    public gcarrotFarmItemRenderer() {
        super(gcarrotFarmRenderer::new, () -> new gcarrotFarmTileentity(BlockPos.ZERO, ModBlocks.GCARROT_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.orchidFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.orchidFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class orchidFarmItemRenderer extends BlockItemRendererBase<orchidFarmRenderer, orchidFarmTileentity> {

    public orchidFarmItemRenderer() {
        super(orchidFarmRenderer::new, () -> new orchidFarmTileentity(BlockPos.ZERO, ModBlocks.ORCHID_FARM.get().defaultBlockState()));
    }

}

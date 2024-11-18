package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.miscellaneous;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.miscellaneous.mushroomFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.miscellaneous.mushroomFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class mushroomFarmItemRenderer extends BlockItemRendererBase<mushroomFarmRenderer, mushroomFarmTileentity> {

    public mushroomFarmItemRenderer() {
        super(mushroomFarmRenderer::new, () -> new mushroomFarmTileentity(BlockPos.ZERO, ModBlocks.MUSHROOM_FARM.get().defaultBlockState()));
    }

}

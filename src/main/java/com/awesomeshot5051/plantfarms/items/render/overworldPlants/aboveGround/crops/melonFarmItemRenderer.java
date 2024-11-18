package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.melonFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.melonFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class melonFarmItemRenderer extends BlockItemRendererBase<melonFarmRenderer, melonFarmTileentity> {

    public melonFarmItemRenderer() {
        super(melonFarmRenderer::new, () -> new melonFarmTileentity(BlockPos.ZERO, ModBlocks.MELON_FARM.get().defaultBlockState()));
    }

}

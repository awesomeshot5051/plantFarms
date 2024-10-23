package com.awesomeshot5051.plantfarms.items.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.ShulkerFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs.ShulkerFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ShulkerFarmItemRenderer extends BlockItemRendererBase<ShulkerFarmRenderer, ShulkerFarmTileentity> {

    public ShulkerFarmItemRenderer() {
        super(ShulkerFarmRenderer::new, () -> new ShulkerFarmTileentity(BlockPos.ZERO, ModBlocks.SHULKER_FARM.get().defaultBlockState()));
    }

}

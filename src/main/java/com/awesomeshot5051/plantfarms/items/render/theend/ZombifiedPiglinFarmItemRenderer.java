package com.awesomeshot5051.plantfarms.items.render.theend;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;

import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.ZombifiedPiglinFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend.ZombifiedPiglinFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ZombifiedPiglinFarmItemRenderer extends BlockItemRendererBase<ZombifiedPiglinFarmRenderer, ZombifiedPiglinFarmTileentity> {

    public ZombifiedPiglinFarmItemRenderer() {
        super(ZombifiedPiglinFarmRenderer::new, () -> new ZombifiedPiglinFarmTileentity(BlockPos.ZERO, ModBlocks.ZOMBIFIED_PIGLIN_FARM.get().defaultBlockState()));
    }

}

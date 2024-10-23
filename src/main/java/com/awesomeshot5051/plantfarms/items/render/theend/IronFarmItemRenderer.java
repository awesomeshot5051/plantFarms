package com.awesomeshot5051.plantfarms.items.render.theend;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.IronFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend.IronFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class IronFarmItemRenderer extends BlockItemRendererBase<IronFarmRenderer, IronFarmTileentity> {

    public IronFarmItemRenderer() {
        super(IronFarmRenderer::new, () -> new IronFarmTileentity(BlockPos.ZERO, ModBlocks.IRON_FARM.get().defaultBlockState()));
    }

}

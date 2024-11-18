package com.awesomeshot5051.plantfarms.items.render.nether.other;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.other.netherWartFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.other.netherWartFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class netherWartFarmItemRenderer extends BlockItemRendererBase<netherWartFarmRenderer, netherWartFarmTileentity> {

    public netherWartFarmItemRenderer() {
        super(netherWartFarmRenderer::new, () -> new netherWartFarmTileentity(BlockPos.ZERO, ModBlocks.WART_FARM.get().defaultBlockState()));
    }

}

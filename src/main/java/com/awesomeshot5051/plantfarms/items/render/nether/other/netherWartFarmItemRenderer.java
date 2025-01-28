package com.awesomeshot5051.plantfarms.items.render.nether.other;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.other.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.other.*;
import com.awesomeshot5051.plantfarms.items.render.*;
import net.minecraft.core.*;

public class netherWartFarmItemRenderer extends BlockItemRendererBase<netherWartFarmRenderer, netherWartFarmTileentity> {
    public netherWartFarmItemRenderer() {
        super(netherWartFarmRenderer::new, () -> new netherWartFarmTileentity(BlockPos.ZERO, ModBlocks.WART_FARM.get().defaultBlockState()));
    }
}
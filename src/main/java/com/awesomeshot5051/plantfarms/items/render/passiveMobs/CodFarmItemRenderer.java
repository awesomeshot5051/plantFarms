package com.awesomeshot5051.plantfarms.items.render.passiveMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.CodFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.CodFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class CodFarmItemRenderer extends BlockItemRendererBase<CodFarmRenderer, CodFarmTileentity> {

    public CodFarmItemRenderer() {
        super(CodFarmRenderer::new, () -> new CodFarmTileentity(BlockPos.ZERO, ModBlocks.COD_FARM.get().defaultBlockState()));
    }

}
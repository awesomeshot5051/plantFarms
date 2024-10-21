package com.awesomeshot5051.plantfarms.items.render.passiveMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.CowFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.CowFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class CowFarmItemRenderer extends BlockItemRendererBase<CowFarmRenderer, CowFarmTileentity> {

    public CowFarmItemRenderer() {
        super(CowFarmRenderer::new, () -> new CowFarmTileentity(BlockPos.ZERO, ModBlocks.COW_FARM.get().defaultBlockState()));
    }

}
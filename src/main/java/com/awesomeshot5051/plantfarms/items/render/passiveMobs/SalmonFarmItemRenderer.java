package com.awesomeshot5051.plantfarms.items.render.passiveMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.SalmonFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.SalmonFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SalmonFarmItemRenderer extends BlockItemRendererBase<SalmonFarmRenderer, SalmonFarmTileentity> {

    public SalmonFarmItemRenderer() {
        super(SalmonFarmRenderer::new, () -> new SalmonFarmTileentity(BlockPos.ZERO, ModBlocks.SALMON_FARM.get().defaultBlockState()));
    }

}

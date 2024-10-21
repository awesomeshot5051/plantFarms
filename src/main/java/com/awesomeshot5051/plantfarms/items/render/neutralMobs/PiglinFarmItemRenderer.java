package com.awesomeshot5051.plantfarms.items.render.neutralMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.neutralMobs.PiglinFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.neutralMobs.PiglinFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class PiglinFarmItemRenderer extends BlockItemRendererBase<PiglinFarmRenderer, PiglinFarmTileentity> {

    public PiglinFarmItemRenderer() {
        super(PiglinFarmRenderer::new, () -> new PiglinFarmTileentity(BlockPos.ZERO, ModBlocks.PIGLIN_FARM.get().defaultBlockState()));
    }

}

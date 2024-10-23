package com.awesomeshot5051.plantfarms.items.render.theend;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.PiglinFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend.PiglinFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class PiglinFarmItemRenderer extends BlockItemRendererBase<PiglinFarmRenderer, PiglinFarmTileentity> {

    public PiglinFarmItemRenderer() {
        super(PiglinFarmRenderer::new, () -> new PiglinFarmTileentity(BlockPos.ZERO, ModBlocks.PIGLIN_FARM.get().defaultBlockState()));
    }

}

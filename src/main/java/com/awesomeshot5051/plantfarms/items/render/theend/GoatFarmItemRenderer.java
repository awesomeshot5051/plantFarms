package com.awesomeshot5051.plantfarms.items.render.theend;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.GoatFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend.GoatFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class GoatFarmItemRenderer extends BlockItemRendererBase<GoatFarmRenderer, GoatFarmTileentity> {

    public GoatFarmItemRenderer() {
        super(GoatFarmRenderer::new, () -> new GoatFarmTileentity(BlockPos.ZERO, ModBlocks.GOAT_FARM.get().defaultBlockState()));
    }

}

package com.awesomeshot5051.plantfarms.items.render.theend;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.SpiderFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend.SpiderFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SpiderFarmItemRenderer extends BlockItemRendererBase<SpiderFarmRenderer, SpiderFarmTileentity> {

    public SpiderFarmItemRenderer() {
        super(SpiderFarmRenderer::new, () -> new SpiderFarmTileentity(BlockPos.ZERO, ModBlocks.SPIDER_FARM.get().defaultBlockState()));
    }

}

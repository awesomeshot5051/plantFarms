package com.awesomeshot5051.plantfarms.items.render.passiveMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.SnowGolemFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.SnowGolemFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SnowGolemFarmItemRenderer extends BlockItemRendererBase<SnowGolemFarmRenderer, SnowGolemFarmTileentity> {

    public SnowGolemFarmItemRenderer() {
        super(SnowGolemFarmRenderer::new, () -> new SnowGolemFarmTileentity(BlockPos.ZERO, ModBlocks.SNOW_GOLEM_FARM.get().defaultBlockState()));
    }

}

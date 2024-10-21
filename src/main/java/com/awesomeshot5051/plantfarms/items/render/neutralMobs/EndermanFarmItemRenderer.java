package com.awesomeshot5051.plantfarms.items.render.neutralMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.neutralMobs.EndermanFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.neutralMobs.EndermanFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class EndermanFarmItemRenderer extends BlockItemRendererBase<EndermanFarmRenderer, EndermanFarmTileentity> {

    public EndermanFarmItemRenderer() {
        super(EndermanFarmRenderer::new, () -> new EndermanFarmTileentity(BlockPos.ZERO, ModBlocks.ENDERMAN_FARM.get().defaultBlockState()));
    }

}

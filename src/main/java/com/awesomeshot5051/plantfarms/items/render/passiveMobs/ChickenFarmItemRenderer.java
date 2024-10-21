package com.awesomeshot5051.plantfarms.items.render.passiveMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.ChickenFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.ChickenFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class ChickenFarmItemRenderer extends BlockItemRendererBase<ChickenFarmRenderer, ChickenFarmTileentity> {

    public ChickenFarmItemRenderer() {
        super(ChickenFarmRenderer::new, () -> new ChickenFarmTileentity(BlockPos.ZERO, ModBlocks.CHICKEN_FARM.get().defaultBlockState()));
    }

}

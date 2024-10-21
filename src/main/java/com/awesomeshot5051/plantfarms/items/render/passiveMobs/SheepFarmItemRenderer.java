package com.awesomeshot5051.plantfarms.items.render.passiveMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.SheepFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.SheepFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SheepFarmItemRenderer extends BlockItemRendererBase<SheepFarmRenderer, SheepFarmTileentity> {

    public SheepFarmItemRenderer() {
        super(SheepFarmRenderer::new, () -> new SheepFarmTileentity(BlockPos.ZERO, ModBlocks.SHEEP_FARM.get().defaultBlockState()));
    }

}

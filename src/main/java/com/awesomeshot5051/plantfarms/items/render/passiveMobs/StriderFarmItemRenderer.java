package com.awesomeshot5051.plantfarms.items.render.passiveMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.StriderFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.StriderFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class StriderFarmItemRenderer extends BlockItemRendererBase<StriderFarmRenderer, StriderFarmTileentity> {

    public StriderFarmItemRenderer() {
        super(StriderFarmRenderer::new, () -> new StriderFarmTileentity(BlockPos.ZERO, ModBlocks.STRIDER_FARM.get().defaultBlockState()));
    }

}

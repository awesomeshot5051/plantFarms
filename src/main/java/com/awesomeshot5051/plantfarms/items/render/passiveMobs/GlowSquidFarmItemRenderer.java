package com.awesomeshot5051.plantfarms.items.render.passiveMobs;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.passiveMobs.GlowSquidFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.passiveMobs.GlowSquidFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class GlowSquidFarmItemRenderer extends BlockItemRendererBase<GlowSquidFarmRenderer, GlowSquidFarmTileentity> {

    public GlowSquidFarmItemRenderer() {
        super(GlowSquidFarmRenderer::new, () -> new GlowSquidFarmTileentity(BlockPos.ZERO, ModBlocks.GLOW_SQUID_FARM.get().defaultBlockState()));
    }

}

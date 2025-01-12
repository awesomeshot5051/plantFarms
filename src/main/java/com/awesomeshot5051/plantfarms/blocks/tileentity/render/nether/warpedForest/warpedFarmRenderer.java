package com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.warpedForest;

import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.warpedForest.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class warpedFarmRenderer extends RendererBase<warpedFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public warpedFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(warpedFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= warpedFarmTileentity.getWarpedSpawnTime(farm) && farm.getTimer() < warpedFarmTileentity.getWarpedDeathTime(farm)) {
            renderSapling(matrixStack);
            // Render the warped Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.WARPED_FUNGUS.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

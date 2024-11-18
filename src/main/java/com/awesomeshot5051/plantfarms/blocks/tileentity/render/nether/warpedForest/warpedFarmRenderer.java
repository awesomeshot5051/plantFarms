package com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.warpedForest;

import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.warpedForest.warpedFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

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
        if (farm.getTimer() >= warpedFarmTileentity.getWarpedSpawnTime() && farm.getTimer() < warpedFarmTileentity.getWarpedDeathTime()) {
            renderSapling(matrixStack);
            // Render the warped Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.WARPED_FUNGUS.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class lilyFarmRenderer extends RendererBase<lilyFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public lilyFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(lilyFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= lilyFarmTileentity.getLilySpawnTime() && farm.getTimer() < lilyFarmTileentity.getLilyDeathTime()) {
            renderSapling(matrixStack);
            blockRenderDispatcher.renderSingleBlock(Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}
package com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend;

import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.*;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.core.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class ChorusFarmRenderer extends RendererBase<ChorusFarmTileentity> {
    private final net.minecraft.client.renderer.block.BlockRenderDispatcher blockRenderDispatcher;

    public ChorusFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(ChorusFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        Direction direction = Direction.SOUTH;
        if (farm.getTimer() >= ChorusFarmTileentity.getChorusSpawnTime() && farm.getTimer() < ChorusFarmTileentity.getChorusDeathTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0D, 0D, 0.2D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.scale(0.7F, 0.7F, 0.7F);
            blockRenderDispatcher.renderSingleBlock(Blocks.CHORUS_PLANT.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}
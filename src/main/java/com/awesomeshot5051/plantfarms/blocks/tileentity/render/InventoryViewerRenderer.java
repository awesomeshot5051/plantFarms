package com.awesomeshot5051.plantfarms.blocks.tileentity.render;

import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.*;

public class InventoryViewerRenderer extends RendererBase<InventoryViewerTileentity> {
    public InventoryViewerRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(InventoryViewerTileentity inventoryViewer, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(inventoryViewer, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        Direction direction = Direction.SOUTH;
        if (inventoryViewer.getVillagerEntity() != null) {
            matrixStack.pushPose();
            VillagerRenderer villagerRenderer = getVillagerRenderer();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.scale(0.45F, 0.45F, 0.45F);
            villagerRenderer.render(inventoryViewer.getVillagerEntity(), 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}
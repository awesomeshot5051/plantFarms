package com.awesomeshot5051.plantfarms.blocks.tileentity.render;

import com.awesomeshot5051.plantfarms.blocks.tileentity.farmBlockTileentity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.core.Direction;

public class farmBlockRenderer extends RendererBase<farmBlockTileentity> {

    public farmBlockRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

//    private VillagerRenderState villagerRenderState;

    @Override
    public void render(farmBlockTileentity inventoryViewer, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
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
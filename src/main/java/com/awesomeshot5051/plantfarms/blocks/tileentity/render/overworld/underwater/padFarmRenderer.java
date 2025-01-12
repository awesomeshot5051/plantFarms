package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.core.*;
import net.minecraft.world.item.*;

public class padFarmRenderer extends RendererBase<padFarmTileentity> {

    public padFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(padFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack goldenCarrotStack = new ItemStack(Items.LILY_PAD);
        Direction direction = getDirection();
        BakedModel model = Minecraft.getInstance().getItemRenderer().getModel(goldenCarrotStack, null, null, 1);
        if (farm.getTimer() >= padFarmTileentity.getPadSpawnTime() && farm.getTimer() < padFarmTileentity.getPadDeathTime()) {
            matrixStack.pushPose();
            switch (direction) {
                case NORTH -> {
                    matrixStack.translate(0.47, 0.1D, 0.5D); // Center the lily pad
                    matrixStack.mulPose(Axis.XP.rotationDegrees(90)); // Lay it flat
//                    matrixStack.mulPose(Axis.YP.rotationDegrees(90)); // Rotate to face North
                }
                case SOUTH -> {
                    matrixStack.translate(0.53D, 0.1D, 0.5D); // Center the lily pad
                    matrixStack.mulPose(Axis.XP.rotationDegrees(90));
                    matrixStack.mulPose(Axis.ZP.rotationDegrees(180));// Lay it flat
                }
                case WEST -> {
                    matrixStack.translate(0.5D, 0.1D, 0.53D); // Center the lily pad
                    matrixStack.mulPose(Axis.XP.rotationDegrees(90)); // Lay it flat
                    matrixStack.mulPose(Axis.ZP.rotationDegrees(-90)); // Rotate to face West
                }
                case EAST -> {
                    matrixStack.translate(0.5D, 0.1D, 0.47D); // Center the lily pad
                    matrixStack.mulPose(Axis.XP.rotationDegrees(90)); // Lay it flat
                    matrixStack.mulPose(Axis.ZP.rotationDegrees(90)); // Rotate to face East
                }
            }
            // Render the Pad Sapling
            itemRenderer.render(goldenCarrotStack, ItemDisplayContext.GUI, false, matrixStack, buffer, combinedLight, combinedOverlay, model);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

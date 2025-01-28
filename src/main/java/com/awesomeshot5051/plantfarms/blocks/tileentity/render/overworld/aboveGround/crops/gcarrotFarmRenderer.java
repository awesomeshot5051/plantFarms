package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.resources.model.*;
import net.minecraft.world.item.*;

public class gcarrotFarmRenderer extends RendererBase<gcarrotFarmTileentity> {
    public gcarrotFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(gcarrotFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack goldenCarrotStack = new ItemStack(Items.GOLDEN_CARROT);
        BakedModel model = Minecraft.getInstance().getItemRenderer().getModel(goldenCarrotStack, null, null, 1);
        matrixStack.pushPose();
        float speed = 0.1f;
        float amplitude = 0.1f;
        float baseHeight = 0.5f;
        float time = (float) (System.currentTimeMillis() % 100000L) / 1000.0f + partialTicks;
        float floatHeight = baseHeight + amplitude * (float) Math.sin(time * speed);
        matrixStack.translate(0.5, floatHeight, 0.5);
        matrixStack.scale(0.5f, 0.5f, 0.5f);
        itemRenderer.render(goldenCarrotStack, ItemDisplayContext.GUI, false, matrixStack, buffer, combinedLight, combinedOverlay, model);
        matrixStack.popPose();
    }
}
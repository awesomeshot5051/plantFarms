package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class orangeFarmRenderer extends RendererBase<orangeFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public orangeFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(orangeFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= orangeFarmTileentity.getOrangeSpawnTime() && farm.getTimer() < orangeFarmTileentity.getOrangeDeathTime()) {
            renderSapling(matrixStack);
            blockRenderDispatcher.renderSingleBlock(Blocks.ORANGE_TULIP.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}
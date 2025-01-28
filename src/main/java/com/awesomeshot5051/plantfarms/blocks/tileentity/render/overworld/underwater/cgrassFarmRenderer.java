package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class cgrassFarmRenderer extends RendererBase<cgrassFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public cgrassFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(cgrassFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= cgrassFarmTileentity.getCgrassSpawnTime() && farm.getTimer() < cgrassFarmTileentity.getCgrassDeathTime()) {
            renderSapling(matrixStack);
            blockRenderDispatcher.renderSingleBlock(Blocks.SEAGRASS.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}
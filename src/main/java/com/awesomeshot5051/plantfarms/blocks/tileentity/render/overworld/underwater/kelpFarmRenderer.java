package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class kelpFarmRenderer extends RendererBase<kelpFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public kelpFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(kelpFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= kelpFarmTileentity.getKelpSpawnTime() && farm.getTimer() < kelpFarmTileentity.getKelpDeathTime()) {
            renderSapling(matrixStack);
            blockRenderDispatcher.renderSingleBlock(Blocks.KELP.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}
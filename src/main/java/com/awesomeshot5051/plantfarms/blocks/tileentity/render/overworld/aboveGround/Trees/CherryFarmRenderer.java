package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class CherryFarmRenderer extends RendererBase<CherryFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public CherryFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(CherryFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= CherryFarmTileentity.getCherrySpawnTime(farm) && farm.getTimer() < CherryFarmTileentity.getCherryDeathTime(farm)) {
            renderSapling(matrixStack);
            blockRenderDispatcher.renderSingleBlock(Blocks.CHERRY_SAPLING.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}
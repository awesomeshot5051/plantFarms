package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.systems.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class beetrootFarmRenderer extends RendererBase<beetrootFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public beetrootFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(beetrootFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= beetrootFarmTileentity.getBeetrootSpawnTime(farm) && farm.getTimer() < beetrootFarmTileentity.getBeetrootSpawnTime(farm)) {
            renderSapling(matrixStack);
            blockRenderDispatcher.renderSingleBlock(Blocks.BEETROOTS.defaultBlockState().setValue(BeetrootBlock.AGE, 3), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, RenderType.TRANSLUCENT);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}
package com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.crimsonForest;

import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.crimsonForest.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class crimsonFarmRenderer extends RendererBase<crimsonFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public crimsonFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(crimsonFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= crimsonFarmTileentity.getCrimsonSpawnTime(farm) && farm.getTimer() < crimsonFarmTileentity.getCrimsonDeathTime(farm)) {
            renderSapling(matrixStack);
            // Render the Acacia Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.CRIMSON_FUNGUS.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

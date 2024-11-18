package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.AzaleaFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class AzaleaFarmRenderer extends RendererBase<AzaleaFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public AzaleaFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(AzaleaFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();


        if (farm.getTimer() >= AzaleaFarmTileentity.getAzaleaSpawnTime() && farm.getTimer() < AzaleaFarmTileentity.getAzaleaDeathTime()) {
            renderSapling(matrixStack);
            // Render the Azalea Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.AZALEA.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}

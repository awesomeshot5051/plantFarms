package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.SpruceFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class SpruceFarmRenderer extends RendererBase<SpruceFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public SpruceFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(SpruceFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();


        if (farm.getTimer() >= SpruceFarmTileentity.getSpruceSpawnTime() && farm.getTimer() < SpruceFarmTileentity.getSpruceDeathTime()) {
            renderSapling(matrixStack);
            // Render the Spruce Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.SPRUCE_SAPLING.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}

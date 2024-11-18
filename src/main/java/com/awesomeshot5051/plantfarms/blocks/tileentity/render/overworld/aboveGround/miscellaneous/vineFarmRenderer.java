package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.miscellaneous;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.miscellaneous.vineFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class vineFarmRenderer extends RendererBase<vineFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public vineFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(vineFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= vineFarmTileentity.getVineSpawnTime() && farm.getTimer() < vineFarmTileentity.getVineDeathTime()) {
            renderSapling(matrixStack);
            // Render the Vine Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.VINE.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

package com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend;

import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.ChorusFarmTileentity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class ChorusFarmRenderer extends RendererBase<ChorusFarmTileentity> {
    private final net.minecraft.client.renderer.block.BlockRenderDispatcher blockRenderDispatcher;

    public ChorusFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(ChorusFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Direction direction = Direction.SOUTH;
        if (farm.getTimer() >= ChorusFarmTileentity.getChorusSpawnTime() && farm.getTimer() < ChorusFarmTileentity.getChorusDeathTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0D, 0D, 0.2D); // Center the sapling in the dirt block
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.scale(0.7F, 0.7F, 0.7F);
            // Render the Oak Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.CHORUS_PLANT.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}

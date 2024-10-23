package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworldPlants.Trees;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.overworldPlants.Trees.OakFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class OakFarmRenderer extends RendererBase<OakFarmTileentity> {
    private final net.minecraft.client.renderer.block.BlockRenderDispatcher blockRenderDispatcher;

    public OakFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(OakFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Direction direction = Direction.SOUTH;
        if (farm.getTimer() >= OakFarmTileentity.getSaplingSpawnTime() && farm.getTimer() < OakFarmTileentity.getSaplingDeathTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0D, 0D, 0.2D); // Center the sapling in the dirt block
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.scale(0.7F, 0.7F, 0.7F);
            // Render the Oak Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.OAK_SAPLING.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}

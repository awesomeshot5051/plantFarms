package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.melonFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class melonFarmRenderer extends RendererBase<melonFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public melonFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(melonFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= melonFarmTileentity.getMelonSpawnTime(farm) && farm.getTimer() < melonFarmTileentity.getMelonDeathTime(farm)) {
            // Push the pose stack to ensure transformations are applied correctly
            Direction direction = getDirection();
            matrixStack.pushPose();

            // Adjust the translation based on direction
            switch (direction) {
                case NORTH -> matrixStack.translate(.9D, 0D, .9D);
                case WEST -> matrixStack.translate(.9D, 0D, 0.1D);
                case EAST -> matrixStack.translate(.1D, 0D, .9D);
                case SOUTH -> matrixStack.translate(0.2D, 0D, 0.1D);
            }

            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.scale(0.7F, 0.7F, 0.7F);
            // Render the melon Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.MELON.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

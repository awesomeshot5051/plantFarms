package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.*;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.core.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.data.*;

public class pumpkinFarmRenderer extends RendererBase<pumpkinFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public pumpkinFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(pumpkinFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= pumpkinFarmTileentity.getPumpkinSpawnTime(farm) && farm.getTimer() < pumpkinFarmTileentity.getPumpkinDeathTime(farm)) {
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
            // Render the pumpkin Sapling
            if (farm.shears != ItemStack.EMPTY) {
                blockRenderDispatcher.renderSingleBlock(Blocks.CARVED_PUMPKIN.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            } else
                blockRenderDispatcher.renderSingleBlock(Blocks.PUMPKIN.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

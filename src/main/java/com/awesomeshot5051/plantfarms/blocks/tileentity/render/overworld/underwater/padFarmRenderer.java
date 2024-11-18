package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.padFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class padFarmRenderer extends RendererBase<padFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public padFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(padFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack goldenCarrotStack = new ItemStack(Items.LILY_PAD);
        Direction direction = getDirection();
        BakedModel model = Minecraft.getInstance().getItemRenderer().getModel(goldenCarrotStack, null, null, 1);
        if (farm.getTimer() >= padFarmTileentity.getPadSpawnTime() && farm.getTimer() < padFarmTileentity.getPadDeathTime()) {
            matrixStack.pushPose();
            switch (direction) {
                case NORTH -> {
                    matrixStack.translate(0.47, 0.1D, 0.5D); // Center the lily pad
                    matrixStack.mulPose(Axis.XP.rotationDegrees(90)); // Lay it flat
//                    matrixStack.mulPose(Axis.YP.rotationDegrees(90)); // Rotate to face North
                }
                case SOUTH -> {
                    matrixStack.translate(0.53D, 0.1D, 0.5D); // Center the lily pad
                    matrixStack.mulPose(Axis.XP.rotationDegrees(90));
                    matrixStack.mulPose(Axis.ZP.rotationDegrees(180));// Lay it flat
                }
                case WEST -> {
                    matrixStack.translate(0.5D, 0.1D, 0.53D); // Center the lily pad
                    matrixStack.mulPose(Axis.XP.rotationDegrees(90)); // Lay it flat
                    matrixStack.mulPose(Axis.ZP.rotationDegrees(-90)); // Rotate to face West
                }
                case EAST -> {
                    matrixStack.translate(0.5D, 0.1D, 0.47D); // Center the lily pad
                    matrixStack.mulPose(Axis.XP.rotationDegrees(90)); // Lay it flat
                    matrixStack.mulPose(Axis.ZP.rotationDegrees(90)); // Rotate to face East
                }
            }
            // Render the Pad Sapling
            itemRenderer.render(goldenCarrotStack, ItemDisplayContext.GUI, false, matrixStack, buffer, combinedLight, combinedOverlay, model);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

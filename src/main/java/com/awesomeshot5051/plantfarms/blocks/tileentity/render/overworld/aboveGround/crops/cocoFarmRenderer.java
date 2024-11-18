package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.cocoFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class cocoFarmRenderer extends RendererBase<cocoFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public cocoFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(cocoFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= cocoFarmTileentity.getCocoSpawnTime() && farm.getTimer() < cocoFarmTileentity.getCocoDeathTime()) {
            renderSapling(matrixStack);
            // Render the coco Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.COCOA.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

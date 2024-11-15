package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.wheatFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.neoforged.neoforge.client.model.data.ModelData;

public class wheatFarmRenderer extends RendererBase<wheatFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public wheatFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(wheatFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= wheatFarmTileentity.getWheatSpawnTime() && farm.getTimer() < wheatFarmTileentity.getWheatDeathTime()) {
            renderSapling(matrixStack);
            // Render the wheat Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.WHEAT.defaultBlockState().setValue(CropBlock.AGE, 7), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

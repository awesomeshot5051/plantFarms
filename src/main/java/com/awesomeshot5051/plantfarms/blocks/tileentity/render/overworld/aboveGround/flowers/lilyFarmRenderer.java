package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.lilyFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class lilyFarmRenderer extends RendererBase<lilyFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public lilyFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(lilyFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= lilyFarmTileentity.getLilySpawnTime() && farm.getTimer() < lilyFarmTileentity.getLilyDeathTime()) {
            renderSapling(matrixStack);
            // Render the Lily Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

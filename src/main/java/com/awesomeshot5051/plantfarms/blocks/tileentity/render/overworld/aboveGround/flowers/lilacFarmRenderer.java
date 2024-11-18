package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.lilacFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class lilacFarmRenderer extends RendererBase<lilacFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public lilacFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(lilacFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= lilacFarmTileentity.getLilacSpawnTime() && farm.getTimer() < lilacFarmTileentity.getLilacDeathTime()) {
            renderSapling(matrixStack);
            // Render the Lilac Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.LILAC.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

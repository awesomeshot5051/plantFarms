package com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.other;

import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.other.netherWartFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class netherWartFarmRenderer extends RendererBase<netherWartFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public netherWartFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(netherWartFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= netherWartFarmTileentity.getWartSpawnTime() && farm.getTimer() < netherWartFarmTileentity.getWartDeathTime()) {
            renderSapling(matrixStack);
            // Render the warped Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.NETHER_WART.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.cgrassFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class cgrassFarmRenderer extends RendererBase<cgrassFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public cgrassFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(cgrassFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= cgrassFarmTileentity.getCgrassSpawnTime() && farm.getTimer() < cgrassFarmTileentity.getCgrassDeathTime()) {
            renderSapling(matrixStack);
            // Render the Cgrass Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.SEAGRASS.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers;



import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.dandelionFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class dandelionFarmRenderer extends RendererBase<dandelionFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public dandelionFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(dandelionFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= dandelionFarmTileentity.getDandelionSpawnTime() && farm.getTimer() < dandelionFarmTileentity.getDandelionDeathTime()) {
            renderSapling(matrixStack);
            // Render the Dandelion Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.DANDELION.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

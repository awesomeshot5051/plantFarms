package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees;



import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.AcaciaFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class AcaciaFarmRenderer extends RendererBase<AcaciaFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public AcaciaFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(AcaciaFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= AcaciaFarmTileentity.getAcaciaSpawnTime() && farm.getTimer() < AcaciaFarmTileentity.getAcaciaDeathTime()) {
            renderSapling(matrixStack);
            // Render the Acacia Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.ACACIA_SAPLING.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

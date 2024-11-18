package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.sunflowerFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class sunflowerFarmRenderer extends RendererBase<sunflowerFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public sunflowerFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(sunflowerFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= sunflowerFarmTileentity.getSunflowerSpawnTime() && farm.getTimer() < sunflowerFarmTileentity.getSunflowerDeathTime()) {
            renderSapling(matrixStack);
            // Render the Sunflower Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.SUNFLOWER.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

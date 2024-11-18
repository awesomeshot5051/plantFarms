package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.leafFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class leafFarmRenderer extends RendererBase<leafFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public leafFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(leafFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= leafFarmTileentity.getLeafSpawnTime() && farm.getTimer() < leafFarmTileentity.getLeafDeathTime()) {
            renderSapling(matrixStack);
            // Render the Leaf Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.BIG_DRIPLEAF.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.beetrootFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class beetrootFarmRenderer extends RendererBase<beetrootFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public beetrootFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(beetrootFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= beetrootFarmTileentity.getBeetrootSpawnTime(farm) && farm.getTimer() < beetrootFarmTileentity.getBeetrootSpawnTime(farm)) {
            renderSapling(matrixStack);
            // Render the beetroot Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.BEETROOTS.defaultBlockState().setValue(BeetrootBlock.AGE, 3), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, RenderType.TRANSLUCENT);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

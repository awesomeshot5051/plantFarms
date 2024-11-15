package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.carrotFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.neoforged.neoforge.client.model.data.ModelData;

public class carrotFarmRenderer extends RendererBase<carrotFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public carrotFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(carrotFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= carrotFarmTileentity.getCarrotSpawnTime() && farm.getTimer() < carrotFarmTileentity.getCarrotDeathTime()) {
            renderSapling(matrixStack);
            // Render the carrot Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.CARROTS.defaultBlockState().setValue(CarrotBlock.AGE, 7), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

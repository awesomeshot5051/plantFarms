package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.berryFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.neoforged.neoforge.client.model.data.ModelData;

public class berryFarmRenderer extends RendererBase<berryFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public berryFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(berryFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();
        if (farm.getTimer() >= berryFarmTileentity.getBerrySpawnTime() && farm.getTimer() < berryFarmTileentity.getBerryDeathTime()) {
            renderSapling(matrixStack);
            // Render the berry Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.SWEET_BERRY_BUSH.defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }


}

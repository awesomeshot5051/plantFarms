package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.OakFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.data.ModelData;

public class OakFarmRenderer extends RendererBase<OakFarmTileentity> {
    private final BlockRenderDispatcher blockRenderDispatcher;

    public OakFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
    }

    @Override
    public void render(OakFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        if (farm.getTimer() >= OakFarmTileentity.getSaplingSpawnTime() && farm.getTimer() < OakFarmTileentity.getSaplingDeathTime()) {
//            matrixStack.pushPose();
//            // Adjust the translation to center the sapling depending on the direction
//            switch (direction) {
//                case NORTH:
//                    matrixStack.translate(1D, 0D, 1D); // Slightly in front of the block on the north side
//                    break;
//                case WEST:
//                    matrixStack.translate(1D, 0D, 0D); // Slightly in front of the block on the west side
//                    break;
//                case EAST:
//                    matrixStack.translate(0D, 0D, 1.1D); // Slightly in front of the block on the east side
//                    break;
//                case SOUTH:
//                    matrixStack.translate(0D, 0D, 0D); // Slightly in front of the block on the south side
//                    break;
//                default:
//                    break;
//            }
//            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
//            matrixStack.scale(0.7F, 0.7F, 0.7F);
            renderSapling(matrixStack);
            // Render the Acacia Sapling
            blockRenderDispatcher.renderSingleBlock(Blocks.OAK_SAPLING.defaultBlockState(), matrixStack, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
            matrixStack.popPose();
        }
        matrixStack.popPose();
    }
}

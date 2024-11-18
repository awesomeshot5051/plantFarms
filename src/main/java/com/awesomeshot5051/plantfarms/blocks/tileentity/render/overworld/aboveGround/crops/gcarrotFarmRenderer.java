package com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops;


import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.gcarrotFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class gcarrotFarmRenderer extends RendererBase<gcarrotFarmTileentity> {

    public gcarrotFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
//        this.blockRenderDispatcher = renderer.getBlockRenderDispatcher();
//        this.itemRenderer = renderer.getItemRenderer();
    }

    @Override
    public void render(gcarrotFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);

        // Get the item renderer and the baked model for the golden carrot
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack goldenCarrotStack = new ItemStack(Items.GOLDEN_CARROT);

        // Get the BakedModel for the golden carrot
        BakedModel model = Minecraft.getInstance().getItemRenderer().getModel(goldenCarrotStack, null, null, 1);

        // Position the golden carrot floating in the container
        matrixStack.pushPose();

        // Much slower oscillation parameters
        float speed = 0.1f;        // Further reduced for very slow movement
        float amplitude = 0.1f;      // Adjusted for subtle movement
        float baseHeight = 0.5f;     // Base height of the carrot

        // Calculate floating motion
        float time = (float) (System.currentTimeMillis() % 100000L) / 1000.0f + partialTicks;
        float floatHeight = baseHeight + amplitude * (float) Math.sin(time * speed);

        matrixStack.translate(0.5, floatHeight, 0.5);
        matrixStack.scale(0.5f, 0.5f, 0.5f);

        // Render the golden carrot with the obtained model
        itemRenderer.render(goldenCarrotStack, ItemDisplayContext.GUI, false, matrixStack, buffer, combinedLight, combinedOverlay, model);

        matrixStack.popPose();
    }

}

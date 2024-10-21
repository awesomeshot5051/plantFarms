package com.awesomeshot5051.plantfarms.blocks.tileentity.render.aggressiveMobs;

import com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs.PhantomFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.RendererBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.PhantomRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Phantom;

import java.lang.ref.WeakReference;

public class PhantomFarmRenderer extends RendererBase<PhantomFarmTileentity> {

    private WeakReference<Phantom> phantomCache = new WeakReference<>(null);
    private WeakReference<PhantomRenderer> phantomRendererCache = new WeakReference<>(null);

    public PhantomFarmRenderer(BlockEntityRendererProvider.Context renderer) {
        super(renderer);
    }

    @Override
    public void render(PhantomFarmTileentity farm, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.render(farm, partialTicks, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.pushPose();

        Phantom phantom = phantomCache.get();
        if (phantom == null) {
            phantom = new Phantom(EntityType.PHANTOM, minecraft.level);
            phantomCache = new WeakReference<>(phantom);
        }

        PhantomRenderer phantomRenderer = phantomRendererCache.get();
        if (phantomRenderer == null) {
            phantomRenderer = new PhantomRenderer(createEntityRenderer());
            phantomRendererCache = new WeakReference<>(phantomRenderer);
        }

        Direction direction = Direction.SOUTH;

        if (farm.getTimer() >= PhantomFarmTileentity.getPhantomSpawnTime() && farm.getTimer() < PhantomFarmTileentity.getPhantomExplodeTime()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5D, 1D / 16D, 0.5D);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
            matrixStack.translate(0D, 0D, 3D / 16D);
            matrixStack.scale(0.3F, 0.3F, 0.3F);
            phantomRenderer.render(phantom, 0F, 1F, matrixStack, buffer, combinedLight);
            matrixStack.popPose();
        }

        matrixStack.popPose();
    }

}

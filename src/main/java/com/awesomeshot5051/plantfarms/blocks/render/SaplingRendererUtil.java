package com.awesomeshot5051.plantfarms.blocks.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.core.Direction;

public class SaplingRendererUtil {

    public static void renderSapling(PoseStack matrixStack, Direction direction) {
        // Push the pose stack to ensure transformations are applied correctly
        matrixStack.pushPose();

        // Adjust the translation based on direction
        switch (direction) {
            case NORTH -> matrixStack.translate(1D, 0D, 1D);
            case WEST -> matrixStack.translate(1D, 0D, 0D);
            case EAST -> matrixStack.translate(0D, 0D, 1.1D);
            case SOUTH -> matrixStack.translate(0D, 0D, 0D);
        }

        matrixStack.mulPose(Axis.YP.rotationDegrees(-direction.toYRot()));
        matrixStack.scale(0.7F, 0.7F, 0.7F);
    }
}


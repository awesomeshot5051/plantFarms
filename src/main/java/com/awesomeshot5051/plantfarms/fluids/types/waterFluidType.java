package com.awesomeshot5051.plantfarms.fluids.types;

import com.awesomeshot5051.plantfarms.fluids.modFluidTypes;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class waterFluidType extends FluidType {
    public waterFluidType() {
        super(FluidType.Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).motionScale(0.007D).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
    }

    @SubscribeEvent
    public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("minecraft:block/water_still"), FLOWING_TEXTURE = ResourceLocation.parse("minecraft:block/water_flow");

            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return STILL_TEXTURE;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return FLOWING_TEXTURE;
            }
            @Override
            public int getTintColor() {
                return -13083194;
            }

            @Override
            public int getTintColor(@NotNull FluidState state, @NotNull BlockAndTintGetter world, @NotNull BlockPos pos) {
                return BiomeColors.getAverageWaterColor(world, pos) | 0xFF000000;
            }
        }, modFluidTypes.WATER_TYPE.get());

    }
}

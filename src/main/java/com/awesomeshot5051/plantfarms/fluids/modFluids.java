package com.awesomeshot5051.plantfarms.fluids;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.fluids.types.waterFluidType;
import net.minecraft.world.level.material.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class modFluids {
    public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, Main.MODID);
    public static final DeferredHolder<Fluid, FlowingFluid> WATER = REGISTRY.register("water", () -> new WaterFluid.Source() {
        @Override
        public Fluid getSource() {
            return Fluids.WATER;
        }

        @Override
        public FluidType getFluidType() {
            return new waterFluidType();
        }
    });
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_WATER = REGISTRY.register("flowing_water", () -> new WaterFluid.Flowing() {
        @Override
        public Fluid getSource() {
            return Fluids.WATER;
        }

        @Override
        public FluidType getFluidType() {
            return new waterFluidType();
        }
    });

    @EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class FluidsClientSideHandler {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(FLOWING_WATER.get(), RenderType.translucent());
        }
    }
    public static void init(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}

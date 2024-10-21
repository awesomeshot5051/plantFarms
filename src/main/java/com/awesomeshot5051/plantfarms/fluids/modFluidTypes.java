package com.awesomeshot5051.plantfarms.fluids;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.fluids.types.waterFluidType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

public class modFluidTypes {
    public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Main.MODID);
    public static final DeferredHolder<FluidType, FluidType> WATER_TYPE = REGISTRY.register("water", () -> new waterFluidType());
    public static void init(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}

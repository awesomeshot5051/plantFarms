package com.awesomeshot5051.plantfarms.datacomponents;

import com.awesomeshot5051.plantfarms.*;
import net.minecraft.core.component.*;
import net.minecraft.core.registries.*;
import net.minecraft.world.item.component.*;
import net.neoforged.bus.api.*;
import net.neoforged.neoforge.registries.*;

import java.util.function.*;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final Supplier<DataComponentType<ItemContainerContents>> HOE_TYPE = REGISTRAR.registerComponentType("hoe_type", builder -> builder.persistent(ItemContainerContents.CODEC).networkSynchronized(ItemContainerContents.STREAM_CODEC));
    public static final Supplier<DataComponentType<ItemContainerContents>> AXE_TYPE = REGISTRAR.registerComponentType("axe_type", builder -> builder.persistent(ItemContainerContents.CODEC).networkSynchronized(ItemContainerContents.STREAM_CODEC));
    public static final Supplier<DataComponentType<ItemContainerContents>> SHEARS = REGISTRAR.registerComponentType("shears", builder -> builder.persistent(ItemContainerContents.CODEC).networkSynchronized(ItemContainerContents.STREAM_CODEC));

    public static void register(IEventBus eventBus) {
        REGISTRAR.register(eventBus);
    }
}
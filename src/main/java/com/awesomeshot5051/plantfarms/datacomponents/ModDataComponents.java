package com.awesomeshot5051.plantfarms.datacomponents;

import com.awesomeshot5051.plantfarms.*;
import net.minecraft.core.component.*;
import net.minecraft.core.registries.*;
import net.minecraft.world.item.component.*;
import net.neoforged.bus.api.*;
import net.neoforged.neoforge.registries.*;

import java.util.function.*;

public class ModDataComponents {
    // Define the ResourceKey for the DataComponentType registry
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final Supplier<DataComponentType<ItemContainerContents>> HOE_TYPE = REGISTRAR.registerComponentType(
            "hoe_type",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent(ItemContainerContents.CODEC)
                    // The codec to read/write the data across the network
                    .networkSynchronized(ItemContainerContents.STREAM_CODEC)
    );
    public static final Supplier<DataComponentType<ItemContainerContents>> AXE_TYPE = REGISTRAR.registerComponentType(
            "axe_type",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent(ItemContainerContents.CODEC)
                    // The codec to read/write the data across the network
                    .networkSynchronized(ItemContainerContents.STREAM_CODEC)
    );
    public static final Supplier<DataComponentType<ItemContainerContents>> SHEARS = REGISTRAR.registerComponentType(
            "shears",
            builder -> builder
                    // The codec to read/write the data to disk
                    .persistent(ItemContainerContents.CODEC)
                    // The codec to read/write the data across the network
                    .networkSynchronized(ItemContainerContents.STREAM_CODEC)
    );
//    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ItemContainerContents>> HOE_TYPE = register("pick_type",
//            builder -> builder.persistent(ItemContainerContents.CODEC));
//    public static

//    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
//                                                                                           UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
//        return REGISTRAR.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
//    }

    public static void register(IEventBus eventBus) {
        REGISTRAR.register(eventBus);
    }
}
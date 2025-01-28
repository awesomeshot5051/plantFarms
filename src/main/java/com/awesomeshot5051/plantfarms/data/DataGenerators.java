package com.awesomeshot5051.plantfarms.data;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.data.providers.recipe.*;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.neoforged.bus.api.*;
import net.neoforged.fml.common.*;
import net.neoforged.neoforge.common.data.*;
import net.neoforged.neoforge.data.event.*;
import org.jetbrains.annotations.*;

import java.util.concurrent.*;

@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
    }
}
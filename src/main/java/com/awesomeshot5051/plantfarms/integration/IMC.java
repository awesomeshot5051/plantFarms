package com.awesomeshot5051.plantfarms.integration;

import com.awesomeshot5051.plantfarms.integration.theoneprobe.*;
import net.neoforged.bus.api.*;
import net.neoforged.fml.*;
import net.neoforged.fml.event.lifecycle.*;

public class IMC {
    @SubscribeEvent
    public static void enqueueIMC(InterModEnqueueEvent event) {
        if (ModList.get().isLoaded("theoneprobe")) {
            InterModComms.sendTo("theoneprobe", "getTheOneProbe", TheOneProbeModule::new);
        }
    }
}
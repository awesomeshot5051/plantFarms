package com.awesomeshot5051.plantfarms.integration.jei;

import com.awesomeshot5051.plantfarms.*;
import mezz.jei.api.*;
import net.minecraft.resources.*;
import org.jetbrains.annotations.*;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, "plant_farms");
    }
}
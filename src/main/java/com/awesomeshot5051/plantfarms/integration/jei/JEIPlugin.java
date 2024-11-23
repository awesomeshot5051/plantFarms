package com.awesomeshot5051.plantfarms.integration.jei;

import com.awesomeshot5051.plantfarms.Main;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, "plant_farms");
    }

}

package com.awesomeshot5051.plantfarms;

import com.awesomeshot5051.corelib.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.data.providers.recipe.recipe.*;
import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.awesomeshot5051.plantfarms.events.*;
import com.awesomeshot5051.plantfarms.gui.*;
import com.awesomeshot5051.plantfarms.integration.*;
import com.awesomeshot5051.plantfarms.items.*;
import com.awesomeshot5051.plantfarms.loottable.*;
import net.neoforged.api.distmarker.*;
import net.neoforged.bus.api.*;
import net.neoforged.fml.common.*;
import net.neoforged.fml.config.*;
import net.neoforged.fml.event.lifecycle.*;
import net.neoforged.fml.loading.*;
import net.neoforged.neoforge.common.*;
import org.apache.logging.log4j.*;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "plant_farms";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ServerConfig SERVER_CONFIG;
    public static ClientConfig CLIENT_CONFIG;

    public Main(IEventBus eventBus) {
        eventBus.addListener(IMC::enqueueIMC);
        eventBus.addListener(ModTileEntities::onRegisterCapabilities);
        ModBlocks.init(eventBus);
        ModItems.init(eventBus);
        ModTileEntities.init(eventBus);
        Containers.init(eventBus);
        ModCreativeTabs.init(eventBus);
        ModLootTables.init(eventBus);
        ModRecipes.registerRecipes(eventBus);
        ModRecipes.registerTypes(eventBus);
        ModDataComponents.register(eventBus);
        SERVER_CONFIG = CommonRegistry.registerConfig(MODID, ModConfig.Type.SERVER, ServerConfig.class);
        CLIENT_CONFIG = CommonRegistry.registerConfig(MODID, ModConfig.Type.CLIENT, ClientConfig.class);
        if (FMLEnvironment.dist.isClient()) {
            eventBus.addListener(Main.this::clientSetup);
            Containers.initClient(eventBus);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void clientSetup(FMLClientSetupEvent event) {
        ModTileEntities.clientSetup();
        NeoForge.EVENT_BUS.register(new ModSoundEvents());
        NeoForge.EVENT_BUS.register(new GuiEvents());
    }
}
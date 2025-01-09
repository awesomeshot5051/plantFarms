package com.awesomeshot5051.plantfarms;


import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.plantfarms.data.providers.recipe.recipe.ModRecipes;
import com.awesomeshot5051.plantfarms.datacomponents.ModDataComponents;
import com.awesomeshot5051.plantfarms.events.GuiEvents;
import com.awesomeshot5051.plantfarms.events.ModSoundEvents;
import com.awesomeshot5051.plantfarms.gui.Containers;
import com.awesomeshot5051.plantfarms.integration.IMC;
import com.awesomeshot5051.plantfarms.items.ModItems;
import com.awesomeshot5051.plantfarms.loottable.ModLootTables;
import de.maxhenkel.corelib.CommonRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main {


    public static final String MODID = "plant_farms";

    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static ServerConfig SERVER_CONFIG;
    public static ClientConfig CLIENT_CONFIG;

    public Main(IEventBus eventBus) {
        eventBus.addListener(this::commonSetup);
//        eventBus.addListener(this::onRegisterPayloadHandler);
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
//            eventBus.addListener(Main.this::onRegisterClientExtensions);
            Containers.initClient(eventBus);
        }
    }

    public void commonSetup(FMLCommonSetupEvent event) {
//        NeoForge.EVENT_BUS.register(new ModEvents());
//        NeoForge.EVENT_BUS.register(new BlockEvents());
        // Register your custom dispenser behavior for dye items
    }

    @OnlyIn(Dist.CLIENT)
    public void clientSetup(FMLClientSetupEvent event) {
        ModTileEntities.clientSetup();

        NeoForge.EVENT_BUS.register(new ModSoundEvents());
        NeoForge.EVENT_BUS.register(new GuiEvents());

    }

//    public void onRegisterPayloadHandler(RegisterPayloadHandlersEvent event) {
//        PayloadRegistrar registrar = event.registrar(MODID).versioned("0");
//        CommonRegistry.registerMessage(registrar, MessageVillagerParticles.class);
//        CommonRegistry.registerMessage(registrar, MessagePickUpVillager.class);
//        CommonRegistry.registerMessage(registrar, MessageSelectTrade.class);
//        CommonRegistry.registerMessage(registrar, MessageCycleTrades.class);
//    }

    //    }
//    @OnlyIn(Dist.CLIENT)
//    public void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
//
//        ///The End
//        event.registerItem(new CustomRenderItemExtension(new ChorusFarmItemRenderer()), ModItems.CHORUS_FARM);
//
//        ///Overworld
//
//        //Overworld Trees
//        event.registerItem(new CustomRenderItemExtension(new OakFarmItemRenderer()), ModItems.OAK_FARM);
//        event.registerItem(new CustomRenderItemExtension(new SpruceFarmItemRenderer()), ModItems.SPRUCE_FARM);
//        event.registerItem(new CustomRenderItemExtension(new BirchFarmItemRenderer()), ModItems.BIRCH_FARM);
//        event.registerItem(new CustomRenderItemExtension(new JungleFarmItemRenderer()), ModItems.JUNGLE_FARM);
//        event.registerItem(new CustomRenderItemExtension(new DarkOakFarmItemRenderer()), ModItems.DARK_OAK_FARM);
//        event.registerItem(new CustomRenderItemExtension(new AcaciaFarmItemRenderer()), ModItems.ACACIA_FARM);
//        event.registerItem(new CustomRenderItemExtension(new AzaleaFarmItemRenderer()), ModItems.AZALEA_FARM);
//        event.registerItem(new CustomRenderItemExtension(new MangroveFarmItemRenderer()), ModItems.MANGROVE_FARM);
//        event.registerItem(new CustomRenderItemExtension(new CherryFarmItemRenderer()), ModItems.CHERRY_FARM);
//
//        //Overworld Crops
//        event.registerItem(new CustomRenderItemExtension(new wheatFarmItemRenderer()), ModItems.WHEAT_FARM);
//        event.registerItem(new CustomRenderItemExtension(new carrotFarmItemRenderer()), ModItems.CARROT_FARM);
//        event.registerItem(new CustomRenderItemExtension(new gcarrotFarmItemRenderer()), ModItems.GCARROT_FARM);
//        event.registerItem(new CustomRenderItemExtension(new potatoFarmItemRenderer()), ModItems.POTATO_FARM);
//        event.registerItem(new CustomRenderItemExtension(new beetrootFarmItemRenderer()), ModItems.BEETROOT_FARM);
//        event.registerItem(new CustomRenderItemExtension(new pumpkinFarmItemRenderer()), ModItems.PUMPKIN_FARM);
//        event.registerItem(new CustomRenderItemExtension(new melonFarmItemRenderer()), ModItems.MELON_FARM);
//        event.registerItem(new CustomRenderItemExtension(new sugarFarmItemRenderer()), ModItems.SUGAR_FARM);
//        event.registerItem(new CustomRenderItemExtension(new cocoaFarmItemRenderer()), ModItems.COCO_FARM);
//        event.registerItem(new CustomRenderItemExtension(new berryFarmItemRenderer()), ModItems.BERRY_FARM);
//        event.registerItem(new CustomRenderItemExtension(new bambooFarmItemRenderer()), ModItems.BAMBOO_FARM);
//
//
//        //Overworld Flowers
//        event.registerItem(new CustomRenderItemExtension(new dandelionFarmItemRenderer()), ModItems.DANDELION_FARM);
//        event.registerItem(new CustomRenderItemExtension(new poppyFarmItemRenderer()), ModItems.POPPY_FARM);
//        event.registerItem(new CustomRenderItemExtension(new orchidFarmItemRenderer()), ModItems.ORCHID_FARM);
//        event.registerItem(new CustomRenderItemExtension(new alliumFarmItemRenderer()), ModItems.ALLIUM_FARM);
//        event.registerItem(new CustomRenderItemExtension(new azureFarmItemRenderer()), ModItems.AZURE_FARM); // Shortened from azureBluetFarm
//        event.registerItem(new CustomRenderItemExtension(new redFarmItemRenderer()), ModItems.RED_FARM); // Shortened from redTulipFarm
//        event.registerItem(new CustomRenderItemExtension(new orangeFarmItemRenderer()), ModItems.ORANGE_FARM); // Shortened from orangeTulipFarm
//        event.registerItem(new CustomRenderItemExtension(new whiteFarmItemRenderer()), ModItems.WHITE_FARM); // Shortened from whiteTulipFarm
//        event.registerItem(new CustomRenderItemExtension(new pinkFarmItemRenderer()), ModItems.PINK_FARM); // Shortened from pinkTulipFarm
//        event.registerItem(new CustomRenderItemExtension(new daisyFarmItemRenderer()), ModItems.DAISY_FARM); // Shortened from oxeyeDaisyFarm
//        event.registerItem(new CustomRenderItemExtension(new cornflowerFarmItemRenderer()), ModItems.CORNFLOWER_FARM);
//        event.registerItem(new CustomRenderItemExtension(new lilyFarmItemRenderer()), ModItems.LILY_FARM); // Lily of the Valley
//        event.registerItem(new CustomRenderItemExtension(new sunflowerFarmItemRenderer()), ModItems.SUNFLOWER_FARM);
//        event.registerItem(new CustomRenderItemExtension(new lilacFarmItemRenderer()), ModItems.LILAC_FARM);
//        event.registerItem(new CustomRenderItemExtension(new roseFarmItemRenderer()), ModItems.ROSE_FARM); // Shortened from roseBushFarm
//        event.registerItem(new CustomRenderItemExtension(new peonyFarmItemRenderer()), ModItems.PEONY_FARM);
//
//
//        ///The Nether
//        event.registerItem(new CustomRenderItemExtension(new crimsonFarmItemRenderer()), ModItems.CRIMSON_FARM);
//        event.registerItem(new CustomRenderItemExtension(new warpedFarmItemRenderer()), ModItems.WARPED_FARM);
//        event.registerItem(new CustomRenderItemExtension(new netherWartFarmItemRenderer()), ModItems.WART_FARM);
//
//
//        event.registerItem(new CustomRenderItemExtension(new vineFarmItemRenderer()), ModItems.VINE_FARM);
//        event.registerItem(new CustomRenderItemExtension(new mushroomFarmItemRenderer()), ModItems.MUSHROOM_FARM);
//
//
//        event.registerItem(new CustomRenderItemExtension(new kelpFarmItemRenderer()), ModItems.KELP_FARM);
//        event.registerItem(new CustomRenderItemExtension(new cgrassFarmItemRenderer()), ModItems.CGRASS_FARM);
//        event.registerItem(new CustomRenderItemExtension(new leafFarmItemRenderer()), ModItems.LEAF_FARM);
//        event.registerItem(new CustomRenderItemExtension(new padFarmItemRenderer()), ModItems.PAD_FARM);
//
//
//        event.registerItem(new CustomRenderItemExtension(new farmBlockItemRenderer()), ModItems.FARM_BLOCK);
//        event.registerItem(new CustomRenderItemExtension(new tfarmBlockItemRenderer()), ModItems.TFARM_BLOCK);
//    }
}

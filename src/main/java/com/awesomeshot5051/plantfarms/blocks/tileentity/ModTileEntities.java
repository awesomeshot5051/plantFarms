package com.awesomeshot5051.plantfarms.blocks.tileentity;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.crimsonForest.crimsonFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.other.netherWartFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.warpedForest.warpedFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.crimsonForest.crimsonFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.other.netherWartFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.warpedForest.warpedFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.theend.ChorusFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.theend.ChorusFarmTileentity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTileEntities {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.MODID);

    @OnlyIn(Dist.CLIENT)
    public static void clientSetup() {
        if (!Main.CLIENT_CONFIG.renderBlockContents.get()) {
            return;
        }
        ///The End
        BlockEntityRenderers.register(ModTileEntities.CHORUS_FARM.get(), ChorusFarmRenderer::new);

        ///The Nether
        BlockEntityRenderers.register(ModTileEntities.CRIMSON_FARM.get(), crimsonFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.WARPED_FARM.get(), warpedFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.WART_FARM.get(), netherWartFarmRenderer::new);


        ///Overworld

        //Overworld Trees
        BlockEntityRenderers.register(ModTileEntities.OAK_FARM.get(), OakFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SPRUCE_FARM.get(), SpruceFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.BIRCH_FARM.get(), BirchFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.JUNGLE_FARM.get(), JungleFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.DARK_OAK_FARM.get(), DarkOakFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ACACIA_FARM.get(), AcaciaFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.AZALEA_FARM.get(), AzaleaFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.MANGROVE_FARM.get(), MangroveFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.CHERRY_FARM.get(), CherryFarmRenderer::new);

        //Overworld Crops
        BlockEntityRenderers.register(ModTileEntities.WHEAT_FARM.get(), wheatFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.CARROT_FARM.get(), carrotFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.POTATO_FARM.get(), potatoFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.BEETROOT_FARM.get(), beetrootFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.PUMPKIN_FARM.get(), pumpkinFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.MELON_FARM.get(), melonFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.SUGAR_FARM.get(), sugarFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.COCO_FARM.get(), cocoFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.BERRY_FARM.get(), berryFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.BAMBOO_FARM.get(), bambooFarmRenderer::new);

        //Overworld Flowers
        BlockEntityRenderers.register(ModTileEntities.DANDELION_FARM.get(), dandelionFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.POPPY_FARM.get(), poppyFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ORCHID_FARM.get(), orchidFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ALLIUM_FARM.get(), alliumFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.AZURE_FARM.get(), azureFarmRenderer::new); // Shortened from azureBluetFarmRenderer
        BlockEntityRenderers.register(ModTileEntities.RED_FARM.get(), redFarmRenderer::new); // Shortened from redTulipFarmRenderer
        BlockEntityRenderers.register(ModTileEntities.ORANGE_FARM.get(), orangeFarmRenderer::new); // Shortened from orangeTulipFarmRenderer
        BlockEntityRenderers.register(ModTileEntities.WHITE_FARM.get(), whiteFarmRenderer::new); // Shortened from whiteTulipFarmRenderer
        BlockEntityRenderers.register(ModTileEntities.PINK_FARM.get(), pinkFarmRenderer::new); // Shortened from pinkTulipFarmRenderer
        BlockEntityRenderers.register(ModTileEntities.DAISY_FARM.get(), daisyFarmRenderer::new); // Shortened from oxeyeDaisyFarmRenderer
        BlockEntityRenderers.register(ModTileEntities.CORNFLOWER_FARM.get(), cornflowerFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.LILY_FARM.get(), lilyFarmRenderer::new); // Changed from lillyFarmRenderer
        BlockEntityRenderers.register(ModTileEntities.SUNFLOWER_FARM.get(), sunflowerFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.LILAC_FARM.get(), lilacFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.ROSE_FARM.get(), roseFarmRenderer::new); // Shortened from roseBushFarmRenderer
        BlockEntityRenderers.register(ModTileEntities.PEONY_FARM.get(), peonyFarmRenderer::new);

    }

    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        ///The End

        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHORUS_FARM.get(), (object, context) -> object.getItemHandler());//


        ///The Nether
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CRIMSON_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WARPED_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WART_FARM.get(), (object, context) -> object.getItemHandler());


        ///Overworld


        //overworld Trees
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, OAK_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SPRUCE_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BIRCH_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JUNGLE_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DARK_OAK_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACACIA_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AZALEA_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MANGROVE_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CHERRY_FARM.get(), (object, context) -> object.getItemHandler());


        //Overworld Crops
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.WHEAT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.CARROT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.POTATO_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.BEETROOT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.PUMPKIN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.MELON_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.SUGAR_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.COCO_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.BERRY_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.BAMBOO_FARM.get(), (object, context) -> object.getItemHandler());


        //Overworld Flowers
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.DANDELION_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.POPPY_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.ORCHID_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.ALLIUM_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.AZURE_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from azureBluetFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.RED_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from redTulipFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.ORANGE_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from orangeTulipFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.WHITE_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from whiteTulipFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.PINK_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from pinkTulipFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.DAISY_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from oxeyeDaisyFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.CORNFLOWER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.LILY_FARM.get(), (object, context) -> object.getItemHandler()); // Changed from lillyFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.SUNFLOWER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.LILAC_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.ROSE_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from roseBushFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModTileEntities.PEONY_FARM.get(), (object, context) -> object.getItemHandler());

    }

    public static void init(IEventBus eventBus) {
        BLOCK_ENTITY_REGISTER.register(eventBus);
    }

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<bambooFarmTileentity>> BAMBOO_FARM = BLOCK_ENTITY_REGISTER.register("bamboo_farm", () ->
            new BlockEntityType<>(bambooFarmTileentity::new, ModBlocks.BAMBOO_FARM.get()));


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InventoryViewerTileentity>> INVENTORY_VIEWER = BLOCK_ENTITY_REGISTER.register("inventory_viewer", () ->
            new BlockEntityType<>(InventoryViewerTileentity::new, ModBlocks.INVENTORY_VIEWER.get())
    );


    /// The End
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChorusFarmTileentity>> CHORUS_FARM = BLOCK_ENTITY_REGISTER.register("chorus_farm", () ->
            new BlockEntityType<>(ChorusFarmTileentity::new, ModBlocks.CHORUS_FARM.get())
    );


    /// Overworld
    //Overworld Trees
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AcaciaFarmTileentity>> ACACIA_FARM = BLOCK_ENTITY_REGISTER.register("acacia_farm", () ->
            new BlockEntityType<>(AcaciaFarmTileentity::new, ModBlocks.ACACIA_FARM.get())
    );


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AzaleaFarmTileentity>> AZALEA_FARM = BLOCK_ENTITY_REGISTER.register("azalea_farm", () ->
            new BlockEntityType<>(AzaleaFarmTileentity::new, ModBlocks.AZALEA_FARM.get())
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BirchFarmTileentity>> BIRCH_FARM = BLOCK_ENTITY_REGISTER.register("birch_farm", () ->
            new BlockEntityType<>(BirchFarmTileentity::new, ModBlocks.BIRCH_FARM.get())
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CherryFarmTileentity>> CHERRY_FARM = BLOCK_ENTITY_REGISTER.register("cherry_farm", () ->
            new BlockEntityType<>(CherryFarmTileentity::new, ModBlocks.CHERRY_FARM.get())
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkOakFarmTileentity>> DARK_OAK_FARM = BLOCK_ENTITY_REGISTER.register("dark_oak_farm", () ->
            new BlockEntityType<>(DarkOakFarmTileentity::new, ModBlocks.DARK_OAK_FARM.get())
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<JungleFarmTileentity>> JUNGLE_FARM = BLOCK_ENTITY_REGISTER.register("jungle_farm", () ->
            new BlockEntityType<>(JungleFarmTileentity::new, ModBlocks.JUNGLE_FARM.get())
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MangroveFarmTileentity>> MANGROVE_FARM = BLOCK_ENTITY_REGISTER.register("mangrove_farm", () ->
            new BlockEntityType<>(MangroveFarmTileentity::new, ModBlocks.MANGROVE_FARM.get())
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OakFarmTileentity>> OAK_FARM = BLOCK_ENTITY_REGISTER.register("oak_farm", () ->
            new BlockEntityType<>(OakFarmTileentity::new, ModBlocks.OAK_FARM.get())
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SpruceFarmTileentity>> SPRUCE_FARM = BLOCK_ENTITY_REGISTER.register("spruce_farm", () ->
            new BlockEntityType<>(SpruceFarmTileentity::new, ModBlocks.SPRUCE_FARM.get())
    );


    //Overworld Crops
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<wheatFarmTileentity>> WHEAT_FARM = BLOCK_ENTITY_REGISTER.register("wheat_farm", () ->
            new BlockEntityType<>(wheatFarmTileentity::new, ModBlocks.WHEAT_FARM.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<carrotFarmTileentity>> CARROT_FARM = BLOCK_ENTITY_REGISTER.register("carrot_farm", () ->
            new BlockEntityType<>(carrotFarmTileentity::new, ModBlocks.CARROT_FARM.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<potatoFarmTileentity>> POTATO_FARM = BLOCK_ENTITY_REGISTER.register("potato_farm", () ->
            new BlockEntityType<>(potatoFarmTileentity::new, ModBlocks.POTATO_FARM.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<beetrootFarmTileentity>> BEETROOT_FARM = BLOCK_ENTITY_REGISTER.register("beetroot_farm", () ->
            new BlockEntityType<>(beetrootFarmTileentity::new, ModBlocks.BEETROOT_FARM.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<pumpkinFarmTileentity>> PUMPKIN_FARM = BLOCK_ENTITY_REGISTER.register("pumpkin_farm", () ->
            new BlockEntityType<>(pumpkinFarmTileentity::new, ModBlocks.PUMPKIN_FARM.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<melonFarmTileentity>> MELON_FARM = BLOCK_ENTITY_REGISTER.register("melon_farm", () ->
            new BlockEntityType<>(melonFarmTileentity::new, ModBlocks.MELON_FARM.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<sugarFarmTileentity>> SUGAR_FARM = BLOCK_ENTITY_REGISTER.register("sugar_farm", () ->
            new BlockEntityType<>(sugarFarmTileentity::new, ModBlocks.SUGAR_FARM.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<cocoFarmTileentity>> COCO_FARM = BLOCK_ENTITY_REGISTER.register("coco_farm", () ->
            new BlockEntityType<>(cocoFarmTileentity::new, ModBlocks.COCO_FARM.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<berryFarmTileentity>> BERRY_FARM = BLOCK_ENTITY_REGISTER.register("berry_farm", () ->
            new BlockEntityType<>(berryFarmTileentity::new, ModBlocks.BERRY_FARM.get()));

    //Overworld Flowers
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<dandelionFarmTileentity>> DANDELION_FARM = BLOCK_ENTITY_REGISTER.register("dandelion_farm", () ->
            new BlockEntityType<>(dandelionFarmTileentity::new, ModBlocks.DANDELION_FARM.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<poppyFarmTileentity>> POPPY_FARM = BLOCK_ENTITY_REGISTER.register("poppy_farm", () ->
            new BlockEntityType<>(poppyFarmTileentity::new, ModBlocks.POPPY_FARM.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<orchidFarmTileentity>> ORCHID_FARM = BLOCK_ENTITY_REGISTER.register("orchid_farm", () ->
            new BlockEntityType<>(orchidFarmTileentity::new, ModBlocks.ORCHID_FARM.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<alliumFarmTileentity>> ALLIUM_FARM = BLOCK_ENTITY_REGISTER.register("allium_farm", () ->
            new BlockEntityType<>(alliumFarmTileentity::new, ModBlocks.ALLIUM_FARM.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<azureFarmTileentity>> AZURE_FARM = BLOCK_ENTITY_REGISTER.register("azure_farm", () ->
            new BlockEntityType<>(azureFarmTileentity::new, ModBlocks.AZURE_FARM.get())); // Shortened from azure_bluet_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<redFarmTileentity>> RED_FARM = BLOCK_ENTITY_REGISTER.register("red_farm", () ->
            new BlockEntityType<>(redFarmTileentity::new, ModBlocks.RED_FARM.get())); // Shortened from red_tulip_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<orangeFarmTileentity>> ORANGE_FARM = BLOCK_ENTITY_REGISTER.register("orange_farm", () ->
            new BlockEntityType<>(orangeFarmTileentity::new, ModBlocks.ORANGE_FARM.get())); // Shortened from orange_tulip_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<whiteFarmTileentity>> WHITE_FARM = BLOCK_ENTITY_REGISTER.register("white_farm", () ->
            new BlockEntityType<>(whiteFarmTileentity::new, ModBlocks.WHITE_FARM.get())); // Shortened from white_tulip_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<pinkFarmTileentity>> PINK_FARM = BLOCK_ENTITY_REGISTER.register("pink_farm", () ->
            new BlockEntityType<>(pinkFarmTileentity::new, ModBlocks.PINK_FARM.get())); // Shortened from pink_tulip_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<daisyFarmTileentity>> DAISY_FARM = BLOCK_ENTITY_REGISTER.register("daisy_farm", () ->
            new BlockEntityType<>(daisyFarmTileentity::new, ModBlocks.DAISY_FARM.get())); // Shortened from oxeye_daisy_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<cornflowerFarmTileentity>> CORNFLOWER_FARM = BLOCK_ENTITY_REGISTER.register("cornflower_farm", () ->
            new BlockEntityType<>(cornflowerFarmTileentity::new, ModBlocks.CORNFLOWER_FARM.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<lilyFarmTileentity>> LILY_FARM = BLOCK_ENTITY_REGISTER.register("lily_farm", () ->
            new BlockEntityType<>(lilyFarmTileentity::new, ModBlocks.LILY_FARM.get())); // Changed from lilly_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<sunflowerFarmTileentity>> SUNFLOWER_FARM = BLOCK_ENTITY_REGISTER.register("sunflower_farm", () ->
            new BlockEntityType<>(sunflowerFarmTileentity::new, ModBlocks.SUNFLOWER_FARM.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<lilacFarmTileentity>> LILAC_FARM = BLOCK_ENTITY_REGISTER.register("lilac_farm", () ->
            new BlockEntityType<>(lilacFarmTileentity::new, ModBlocks.LILAC_FARM.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<roseFarmTileentity>> ROSE_FARM = BLOCK_ENTITY_REGISTER.register("rose_farm", () ->
            new BlockEntityType<>(roseFarmTileentity::new, ModBlocks.ROSE_FARM.get())); // Shortened from rose_bush_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<peonyFarmTileentity>> PEONY_FARM = BLOCK_ENTITY_REGISTER.register("peony_farm", () ->
            new BlockEntityType<>(peonyFarmTileentity::new, ModBlocks.PEONY_FARM.get()));


    /// The Nether
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<crimsonFarmTileentity>> CRIMSON_FARM = BLOCK_ENTITY_REGISTER.register("crimson_farm", () ->
            new BlockEntityType<>(crimsonFarmTileentity::new, ModBlocks.CRIMSON_FARM.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<warpedFarmTileentity>> WARPED_FARM = BLOCK_ENTITY_REGISTER.register("warped_farm", () ->
            new BlockEntityType<>(warpedFarmTileentity::new, ModBlocks.WARPED_FARM.get())
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<netherWartFarmTileentity>> WART_FARM = BLOCK_ENTITY_REGISTER.register("wart_farm", () ->
            new BlockEntityType<>(netherWartFarmTileentity::new, ModBlocks.WART_FARM.get())
    );


//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MagmaCubeFarmTileentity>> MAGMA_CUBE_FARM = BLOCK_ENTITY_REGISTER.register("magma_cube_farm", () ->
//            new BlockEntityType<>(MagmaCubeFarmTileentity::new, ModBlocks.MAGMA_CUBE_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PhantomFarmTileentity>> PHANTOM_FARM = BLOCK_ENTITY_REGISTER.register("phantom_farm", () ->
//            new BlockEntityType<>(PhantomFarmTileentity::new, ModBlocks.PHANTOM_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PillagerFarmTileentity>> PILLAGER_FARM = BLOCK_ENTITY_REGISTER.register("pillager_farm", () ->
//            new BlockEntityType<>(PillagerFarmTileentity::new, ModBlocks.PILLAGER_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RavagerFarmTileentity>> RAVAGER_FARM = BLOCK_ENTITY_REGISTER.register("ravager_farm", () ->
//            new BlockEntityType<>(RavagerFarmTileentity::new, ModBlocks.RAVAGER_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ShulkerFarmTileentity>> SHULKER_FARM = BLOCK_ENTITY_REGISTER.register("shulker_farm", () ->
//            new BlockEntityType<>(ShulkerFarmTileentity::new, ModBlocks.SHULKER_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SkeletonFarmTileentity>> SKELETON_FARM = BLOCK_ENTITY_REGISTER.register("skeleton_farm", () ->
//            new BlockEntityType<>(SkeletonFarmTileentity::new, ModBlocks.SKELETON_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SlimeFarmTileentity>> SLIME_FARM = BLOCK_ENTITY_REGISTER.register("slime_farm", () ->
//            new BlockEntityType<>(SlimeFarmTileentity::new, ModBlocks.SLIME_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VindicatorFarmTileentity>> VINDICATOR_FARM = BLOCK_ENTITY_REGISTER.register("vindicator_farm", () ->
//            new BlockEntityType<>(VindicatorFarmTileentity::new, ModBlocks.VINDICATOR_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WardenFarmTileentity>> WARDEN_FARM = BLOCK_ENTITY_REGISTER.register("warden_farm", () ->
//            new BlockEntityType<>(WardenFarmTileentity::new, ModBlocks.WARDEN_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitchFarmTileentity>> WITCH_FARM = BLOCK_ENTITY_REGISTER.register("witch_farm", () ->
//            new BlockEntityType<>(WitchFarmTileentity::new, ModBlocks.WITCH_FARM.get())
//    );
//
//
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitherFarmTileentity>> WITHER_FARM = BLOCK_ENTITY_REGISTER.register("wither_farm", () ->
//            new BlockEntityType<>(WitherFarmTileentity::new, ModBlocks.WITHER_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WitherSkeletonFarmTileentity>> WITHER_SKELETON_FARM = BLOCK_ENTITY_REGISTER.register("wither_skeleton_farm", () ->
//            new BlockEntityType<>(WitherSkeletonFarmTileentity::new, ModBlocks.WITHER_SKELETON_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ZoglinFarmTileentity>> ZOGLIN_FARM = BLOCK_ENTITY_REGISTER.register("zoglin_farm", () ->
//            new BlockEntityType<>(ZoglinFarmTileentity::new, ModBlocks.ZOGLIN_FARM.get())
//    );
//    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ZombieFarmTileentity>> ZOMBIE_FARM = BLOCK_ENTITY_REGISTER.register("zombie_farm", () ->
//            new BlockEntityType<>(ZombieFarmTileentity::new, ModBlocks.ZOMBIE_FARM.get())
//    );


}

package com.awesomeshot5051.plantfarms.blocks.tileentity;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.crimsonForest.crimsonFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.other.netherWartFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.warpedForest.warpedFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.miscellaneous.mushroomFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.miscellaneous.vineFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.cgrassFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.kelpFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.leafFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.underwaterPlants.padFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.farmBlockRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.crimsonForest.crimsonFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.other.netherWartFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.nether.warpedForest.warpedFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.miscellaneous.mushroomFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.miscellaneous.vineFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.cgrassFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.kelpFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.leafFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.underwater.padFarmRenderer;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.tfarmBlockRenderer;
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
    public static final DeferredRegister<BlockEntityType<?>> EXTERNAL_BLOCK_ENTITY_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.MODID);

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
        BlockEntityRenderers.register(ModTileEntities.GCARROT_FARM.get(), gcarrotFarmRenderer::new);
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

        BlockEntityRenderers.register(ModTileEntities.FARM_BLOCK.get(), farmBlockRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.TFARM_BLOCK.get(), tfarmBlockRenderer::new);


        BlockEntityRenderers.register(ModTileEntities.VINE_FARM.get(), vineFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.MUSHROOM_FARM.get(), mushroomFarmRenderer::new);


        BlockEntityRenderers.register(ModTileEntities.CGRASS_FARM.get(), cgrassFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.KELP_FARM.get(), kelpFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.LEAF_FARM.get(), leafFarmRenderer::new);
        BlockEntityRenderers.register(ModTileEntities.PAD_FARM.get(), padFarmRenderer::new);

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
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHEAT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CARROT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GCARROT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, POTATO_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BEETROOT_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PUMPKIN_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MELON_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUGAR_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COCO_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BERRY_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BAMBOO_FARM.get(), (object, context) -> object.getItemHandler());


        //Overworld Flowers
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DANDELION_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, POPPY_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ORCHID_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ALLIUM_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AZURE_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from azureBluetFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, RED_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from redTulipFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ORANGE_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from orangeTulipFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from whiteTulipFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PINK_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from pinkTulipFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DAISY_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from oxeyeDaisyFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CORNFLOWER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LILY_FARM.get(), (object, context) -> object.getItemHandler()); // Changed from lillyFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUNFLOWER_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LILAC_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ROSE_FARM.get(), (object, context) -> object.getItemHandler()); // Shortened from roseBushFarm
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PEONY_FARM.get(), (object, context) -> object.getItemHandler());

        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, VINE_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MUSHROOM_FARM.get(), (object, context) -> object.getItemHandler());


        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CGRASS_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PAD_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LEAF_FARM.get(), (object, context) -> object.getItemHandler());
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, KELP_FARM.get(), (object, context) -> object.getItemHandler());


        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FARM_BLOCK.get(), (object, context) -> object.getItemHandler());//
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TFARM_BLOCK.get(), (object, context) -> object.getItemHandler());//


    }

    public static void init(IEventBus eventBus) {
        BLOCK_ENTITY_REGISTER.register(eventBus);
        EXTERNAL_BLOCK_ENTITY_REGISTER.register(eventBus);
    }

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<farmBlockTileentity>> FARM_BLOCK = BLOCK_ENTITY_REGISTER.register("farm_block", () ->
            BlockEntityType.Builder.of(farmBlockTileentity::new, ModBlocks.FARM_BLOCK.get()).build(null)
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<tfarmBlockTileentity>> TFARM_BLOCK = BLOCK_ENTITY_REGISTER.register("tfarm_block", () ->
            BlockEntityType.Builder.of(tfarmBlockTileentity::new, ModBlocks.TFARM_BLOCK.get()).build(null)
    );


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<bambooFarmTileentity>> BAMBOO_FARM = BLOCK_ENTITY_REGISTER.register("bamboo_farm", () ->
            BlockEntityType.Builder.of(bambooFarmTileentity::new, ModBlocks.BAMBOO_FARM.get()).build(null));


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InventoryViewerTileentity>> INVENTORY_VIEWER = BLOCK_ENTITY_REGISTER.register("inventory_viewer", () ->
            BlockEntityType.Builder.of(InventoryViewerTileentity::new, ModBlocks.INVENTORY_VIEWER.get()).build(null)
    );


    /// The End
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChorusFarmTileentity>> CHORUS_FARM = BLOCK_ENTITY_REGISTER.register("chorus_farm", () ->
            BlockEntityType.Builder.of(ChorusFarmTileentity::new, ModBlocks.CHORUS_FARM.get()).build(null)
    );


    /// Overworld
    //Overworld Trees
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AcaciaFarmTileentity>> ACACIA_FARM = BLOCK_ENTITY_REGISTER.register("acacia_farm", () ->
            BlockEntityType.Builder.of(AcaciaFarmTileentity::new, ModBlocks.ACACIA_FARM.get()).build(null)
    );


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AzaleaFarmTileentity>> AZALEA_FARM = BLOCK_ENTITY_REGISTER.register("azalea_farm", () ->
            BlockEntityType.Builder.of(AzaleaFarmTileentity::new, ModBlocks.AZALEA_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BirchFarmTileentity>> BIRCH_FARM = BLOCK_ENTITY_REGISTER.register("birch_farm", () ->
            BlockEntityType.Builder.of(BirchFarmTileentity::new, ModBlocks.BIRCH_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CherryFarmTileentity>> CHERRY_FARM = BLOCK_ENTITY_REGISTER.register("cherry_farm", () ->
            BlockEntityType.Builder.of(CherryFarmTileentity::new, ModBlocks.CHERRY_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DarkOakFarmTileentity>> DARK_OAK_FARM = BLOCK_ENTITY_REGISTER.register("dark_oak_farm", () ->
            BlockEntityType.Builder.of(DarkOakFarmTileentity::new, ModBlocks.DARK_OAK_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<JungleFarmTileentity>> JUNGLE_FARM = BLOCK_ENTITY_REGISTER.register("jungle_farm", () ->
            BlockEntityType.Builder.of(JungleFarmTileentity::new, ModBlocks.JUNGLE_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MangroveFarmTileentity>> MANGROVE_FARM = BLOCK_ENTITY_REGISTER.register("mangrove_farm", () ->
            BlockEntityType.Builder.of(MangroveFarmTileentity::new, ModBlocks.MANGROVE_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OakFarmTileentity>> OAK_FARM = BLOCK_ENTITY_REGISTER.register("oak_farm", () ->
            BlockEntityType.Builder.of(OakFarmTileentity::new, ModBlocks.OAK_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SpruceFarmTileentity>> SPRUCE_FARM = BLOCK_ENTITY_REGISTER.register("spruce_farm", () ->
            BlockEntityType.Builder.of(SpruceFarmTileentity::new, ModBlocks.SPRUCE_FARM.get()).build(null)
    );


    //Overworld Crops
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<wheatFarmTileentity>> WHEAT_FARM = BLOCK_ENTITY_REGISTER.register("wheat_farm", () ->
            BlockEntityType.Builder.of(wheatFarmTileentity::new, ModBlocks.WHEAT_FARM.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<carrotFarmTileentity>> CARROT_FARM = BLOCK_ENTITY_REGISTER.register("carrot_farm", () ->
            BlockEntityType.Builder.of(carrotFarmTileentity::new, ModBlocks.CARROT_FARM.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<gcarrotFarmTileentity>> GCARROT_FARM = BLOCK_ENTITY_REGISTER.register("gcarrot_farm", () ->
            BlockEntityType.Builder.of(gcarrotFarmTileentity::new, ModBlocks.GCARROT_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<potatoFarmTileentity>> POTATO_FARM = BLOCK_ENTITY_REGISTER.register("potato_farm", () ->
            BlockEntityType.Builder.of(potatoFarmTileentity::new, ModBlocks.POTATO_FARM.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<beetrootFarmTileentity>> BEETROOT_FARM = BLOCK_ENTITY_REGISTER.register("beetroot_farm", () ->
            BlockEntityType.Builder.of(beetrootFarmTileentity::new, ModBlocks.BEETROOT_FARM.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<pumpkinFarmTileentity>> PUMPKIN_FARM = BLOCK_ENTITY_REGISTER.register("pumpkin_farm", () ->
            BlockEntityType.Builder.of(pumpkinFarmTileentity::new, ModBlocks.PUMPKIN_FARM.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<melonFarmTileentity>> MELON_FARM = BLOCK_ENTITY_REGISTER.register("melon_farm", () ->
            BlockEntityType.Builder.of(melonFarmTileentity::new, ModBlocks.MELON_FARM.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<sugarFarmTileentity>> SUGAR_FARM = BLOCK_ENTITY_REGISTER.register("sugar_farm", () ->
            BlockEntityType.Builder.of(sugarFarmTileentity::new, ModBlocks.SUGAR_FARM.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<cocoFarmTileentity>> COCO_FARM = BLOCK_ENTITY_REGISTER.register("coco_farm", () ->
            BlockEntityType.Builder.of(cocoFarmTileentity::new, ModBlocks.COCO_FARM.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<berryFarmTileentity>> BERRY_FARM = BLOCK_ENTITY_REGISTER.register("berry_farm", () ->
            BlockEntityType.Builder.of(berryFarmTileentity::new, ModBlocks.BERRY_FARM.get()).build(null));

    //Overworld Flowers
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<dandelionFarmTileentity>> DANDELION_FARM = BLOCK_ENTITY_REGISTER.register("dandelion_farm", () ->
            BlockEntityType.Builder.of(dandelionFarmTileentity::new, ModBlocks.DANDELION_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<poppyFarmTileentity>> POPPY_FARM = BLOCK_ENTITY_REGISTER.register("poppy_farm", () ->
            BlockEntityType.Builder.of(poppyFarmTileentity::new, ModBlocks.POPPY_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<orchidFarmTileentity>> ORCHID_FARM = BLOCK_ENTITY_REGISTER.register("orchid_farm", () ->
            BlockEntityType.Builder.of(orchidFarmTileentity::new, ModBlocks.ORCHID_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<alliumFarmTileentity>> ALLIUM_FARM = BLOCK_ENTITY_REGISTER.register("allium_farm", () ->
            BlockEntityType.Builder.of(alliumFarmTileentity::new, ModBlocks.ALLIUM_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<azureFarmTileentity>> AZURE_FARM = BLOCK_ENTITY_REGISTER.register("azure_farm", () ->
            BlockEntityType.Builder.of(azureFarmTileentity::new, ModBlocks.AZURE_FARM.get()).build(null)); // Shortened from azure_bluet_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<redFarmTileentity>> RED_FARM = BLOCK_ENTITY_REGISTER.register("red_farm", () ->
            BlockEntityType.Builder.of(redFarmTileentity::new, ModBlocks.RED_FARM.get()).build(null)); // Shortened from red_tulip_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<orangeFarmTileentity>> ORANGE_FARM = BLOCK_ENTITY_REGISTER.register("orange_farm", () ->
            BlockEntityType.Builder.of(orangeFarmTileentity::new, ModBlocks.ORANGE_FARM.get()).build(null)); // Shortened from orange_tulip_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<whiteFarmTileentity>> WHITE_FARM = BLOCK_ENTITY_REGISTER.register("white_farm", () ->
            BlockEntityType.Builder.of(whiteFarmTileentity::new, ModBlocks.WHITE_FARM.get()).build(null)); // Shortened from white_tulip_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<pinkFarmTileentity>> PINK_FARM = BLOCK_ENTITY_REGISTER.register("pink_farm", () ->
            BlockEntityType.Builder.of(pinkFarmTileentity::new, ModBlocks.PINK_FARM.get()).build(null)); // Shortened from pink_tulip_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<daisyFarmTileentity>> DAISY_FARM = BLOCK_ENTITY_REGISTER.register("daisy_farm", () ->
            BlockEntityType.Builder.of(daisyFarmTileentity::new, ModBlocks.DAISY_FARM.get()).build(null)); // Shortened from oxeye_daisy_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<cornflowerFarmTileentity>> CORNFLOWER_FARM = BLOCK_ENTITY_REGISTER.register("cornflower_farm", () ->
            BlockEntityType.Builder.of(cornflowerFarmTileentity::new, ModBlocks.CORNFLOWER_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<lilyFarmTileentity>> LILY_FARM = BLOCK_ENTITY_REGISTER.register("lily_farm", () ->
            BlockEntityType.Builder.of(lilyFarmTileentity::new, ModBlocks.LILY_FARM.get()).build(null)); // Changed from lilly_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<sunflowerFarmTileentity>> SUNFLOWER_FARM = BLOCK_ENTITY_REGISTER.register("sunflower_farm", () ->
            BlockEntityType.Builder.of(sunflowerFarmTileentity::new, ModBlocks.SUNFLOWER_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<lilacFarmTileentity>> LILAC_FARM = BLOCK_ENTITY_REGISTER.register("lilac_farm", () ->
            BlockEntityType.Builder.of(lilacFarmTileentity::new, ModBlocks.LILAC_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<roseFarmTileentity>> ROSE_FARM = BLOCK_ENTITY_REGISTER.register("rose_farm", () ->
            BlockEntityType.Builder.of(roseFarmTileentity::new, ModBlocks.ROSE_FARM.get()).build(null)); // Shortened from rose_bush_farm
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<peonyFarmTileentity>> PEONY_FARM = BLOCK_ENTITY_REGISTER.register("peony_farm", () ->
            BlockEntityType.Builder.of(peonyFarmTileentity::new, ModBlocks.PEONY_FARM.get()).build(null));


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<vineFarmTileentity>> VINE_FARM = BLOCK_ENTITY_REGISTER.register("vine_farm", () ->
            BlockEntityType.Builder.of(vineFarmTileentity::new, ModBlocks.VINE_FARM.get()).build(null));


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<mushroomFarmTileentity>> MUSHROOM_FARM = BLOCK_ENTITY_REGISTER.register("mushroom_farm", () ->
            BlockEntityType.Builder.of(mushroomFarmTileentity::new, ModBlocks.MUSHROOM_FARM.get()).build(null));


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<kelpFarmTileentity>> KELP_FARM = BLOCK_ENTITY_REGISTER.register("kelp_farm", () ->
            BlockEntityType.Builder.of(kelpFarmTileentity::new, ModBlocks.KELP_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<cgrassFarmTileentity>> CGRASS_FARM = BLOCK_ENTITY_REGISTER.register("cgrass_farm", () ->
            BlockEntityType.Builder.of(cgrassFarmTileentity::new, ModBlocks.CGRASS_FARM.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<leafFarmTileentity>> LEAF_FARM = BLOCK_ENTITY_REGISTER.register("leaf_farm", () ->
            BlockEntityType.Builder.of(leafFarmTileentity::new, ModBlocks.LEAF_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<padFarmTileentity>> PAD_FARM = BLOCK_ENTITY_REGISTER.register("pad_farm", () ->
            BlockEntityType.Builder.of(padFarmTileentity::new, ModBlocks.PAD_FARM.get()).build(null)
    );


    /// The Nether
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<crimsonFarmTileentity>> CRIMSON_FARM = BLOCK_ENTITY_REGISTER.register("crimson_farm", () ->
            BlockEntityType.Builder.of(crimsonFarmTileentity::new, ModBlocks.CRIMSON_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<warpedFarmTileentity>> WARPED_FARM = BLOCK_ENTITY_REGISTER.register("warped_farm", () ->
            BlockEntityType.Builder.of(warpedFarmTileentity::new, ModBlocks.WARPED_FARM.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<netherWartFarmTileentity>> WART_FARM = BLOCK_ENTITY_REGISTER.register("wart_farm", () ->
            BlockEntityType.Builder.of(netherWartFarmTileentity::new, ModBlocks.WART_FARM.get()).build(null)
    );

}

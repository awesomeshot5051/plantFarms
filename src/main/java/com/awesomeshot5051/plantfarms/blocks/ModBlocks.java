package com.awesomeshot5051.plantfarms.blocks;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.blocks.nether.crimsonForest.crimsonFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.nether.other.netherWartFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.nether.warpedForest.warpedFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.miscellaneous.mushroomFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.miscellaneous.vineFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.overworld.underwaterPlants.cgrassFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.overworld.underwaterPlants.kelpFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.overworld.underwaterPlants.leafFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.overworld.underwaterPlants.padFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.theend.ChorusFarmBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    /*
     * Custom Water Block For Plant Farm display ONLY
     *
     * */
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(Main.MODID);
    private static final DeferredRegister.Blocks BLOCK_REGISTER = DeferredRegister.createBlocks(Main.MODID);
    // End Plants
    public static final DeferredHolder<Block, ChorusFarmBlock> CHORUS_FARM = BLOCK_REGISTER.registerBlock("chorus_farm", ChorusFarmBlock::new, BlockBehaviour.Properties.of());
    /// Overworld

    // Overworld Trees
    public static final DeferredHolder<Block, OakFarmBlock> OAK_FARM = BLOCK_REGISTER.registerBlock("oak_farm", OakFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, SpruceFarmBlock> SPRUCE_FARM = BLOCK_REGISTER.registerBlock("spruce_farm", SpruceFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, BirchFarmBlock> BIRCH_FARM = BLOCK_REGISTER.registerBlock("birch_farm", BirchFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, JungleFarmBlock> JUNGLE_FARM = BLOCK_REGISTER.registerBlock("jungle_farm", JungleFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, DarkOakFarmBlock> DARK_OAK_FARM = BLOCK_REGISTER.registerBlock("dark_oak_farm", DarkOakFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, AcaciaFarmBlock> ACACIA_FARM = BLOCK_REGISTER.registerBlock("acacia_farm", AcaciaFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, AzaleaFarmBlock> AZALEA_FARM = BLOCK_REGISTER.registerBlock("azalea_farm", AzaleaFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, MangroveFarmBlock> MANGROVE_FARM = BLOCK_REGISTER.registerBlock("mangrove_farm", MangroveFarmBlock::new, BlockBehaviour.Properties.of());

    //Overworld Crops
    public static final DeferredHolder<Block, CherryFarmBlock> CHERRY_FARM = BLOCK_REGISTER.registerBlock("cherry_farm", CherryFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, wheatFarmBlock> WHEAT_FARM = BLOCK_REGISTER.registerBlock("wheat_farm", wheatFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, carrotFarmBlock> CARROT_FARM = BLOCK_REGISTER.registerBlock("carrot_farm", carrotFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, gcarrotFarmBlock> GCARROT_FARM = BLOCK_REGISTER.registerBlock("gcarrot_farm", gcarrotFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, potatoFarmBlock> POTATO_FARM = BLOCK_REGISTER.registerBlock("potato_farm", potatoFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, beetrootFarmBlock> BEETROOT_FARM = BLOCK_REGISTER.registerBlock("beetroot_farm", beetrootFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, pumpkinFarmBlock> PUMPKIN_FARM = BLOCK_REGISTER.registerBlock("pumpkin_farm", pumpkinFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, melonFarmBlock> MELON_FARM = BLOCK_REGISTER.registerBlock("melon_farm", melonFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, sugarFarmBlock> SUGAR_FARM = BLOCK_REGISTER.registerBlock("sugar_farm", sugarFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, cocoFarmBlock> COCO_FARM = BLOCK_REGISTER.registerBlock("coco_farm", cocoFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, berryFarmBlock> BERRY_FARM = BLOCK_REGISTER.registerBlock("berry_farm", berryFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, bambooFarmBlock> BAMBOO_FARM = BLOCK_REGISTER.registerBlock("bamboo_farm", bambooFarmBlock::new, BlockBehaviour.Properties.of());

    //Overworld Flowers
    public static final DeferredHolder<Block, dandelionFarmBlock> DANDELION_FARM = BLOCK_REGISTER.registerBlock("dandelion_farm", dandelionFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, poppyFarmBlock> POPPY_FARM = BLOCK_REGISTER.registerBlock("poppy_farm", poppyFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, orchidFarmBlock> ORCHID_FARM = BLOCK_REGISTER.registerBlock("orchid_farm", orchidFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, alliumFarmBlock> ALLIUM_FARM = BLOCK_REGISTER.registerBlock("allium_farm", alliumFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, azureFarmBlock> AZURE_FARM = BLOCK_REGISTER.registerBlock("azure_farm", azureFarmBlock::new, BlockBehaviour.Properties.of()); // Shortened from azureBluetFarmBlock
    public static final DeferredHolder<Block, redFarmBlock> RED_FARM = BLOCK_REGISTER.registerBlock("red_farm", redFarmBlock::new, BlockBehaviour.Properties.of()); // Shortened from redTulipFarmBlock
    public static final DeferredHolder<Block, orangeFarmBlock> ORANGE_FARM = BLOCK_REGISTER.registerBlock("orange_farm", orangeFarmBlock::new, BlockBehaviour.Properties.of()); // Shortened from orangeTulipFarmBlock
    public static final DeferredHolder<Block, whiteFarmBlock> WHITE_FARM = BLOCK_REGISTER.registerBlock("white_farm", whiteFarmBlock::new, BlockBehaviour.Properties.of()); // Shortened from whiteTulipFarmBlock
    public static final DeferredHolder<Block, pinkFarmBlock> PINK_FARM = BLOCK_REGISTER.registerBlock("pink_farm", pinkFarmBlock::new, BlockBehaviour.Properties.of()); // Shortened from pinkTulipFarmBlock
    public static final DeferredHolder<Block, daisyFarmBlock> DAISY_FARM = BLOCK_REGISTER.registerBlock("daisy_farm", daisyFarmBlock::new, BlockBehaviour.Properties.of()); // Shortened from oxeyeDaisyFarmBlock
    public static final DeferredHolder<Block, cornflowerFarmBlock> CORNFLOWER_FARM = BLOCK_REGISTER.registerBlock("cornflower_farm", cornflowerFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, lilyFarmBlock> LILY_FARM = BLOCK_REGISTER.registerBlock("lily_farm", lilyFarmBlock::new, BlockBehaviour.Properties.of()); // Lily of the Valley
    public static final DeferredHolder<Block, sunflowerFarmBlock> SUNFLOWER_FARM = BLOCK_REGISTER.registerBlock("sunflower_farm", sunflowerFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, lilacFarmBlock> LILAC_FARM = BLOCK_REGISTER.registerBlock("lilac_farm", lilacFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, roseFarmBlock> ROSE_FARM = BLOCK_REGISTER.registerBlock("rose_farm", roseFarmBlock::new, BlockBehaviour.Properties.of()); // Shortened from roseBushFarmBlock
    public static final DeferredHolder<Block, peonyFarmBlock> PEONY_FARM = BLOCK_REGISTER.registerBlock("peony_farm", peonyFarmBlock::new, BlockBehaviour.Properties.of());


    public static final DeferredHolder<Block, vineFarmBlock> VINE_FARM = BLOCK_REGISTER.registerBlock("vine_farm", vineFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, mushroomFarmBlock> MUSHROOM_FARM = BLOCK_REGISTER.registerBlock("mushroom_farm", mushroomFarmBlock::new, BlockBehaviour.Properties.of());


    public static final DeferredHolder<Block, cgrassFarmBlock> CGRASS_FARM = BLOCK_REGISTER.registerBlock("cgrass_farm", cgrassFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, padFarmBlock> PAD_FARM = BLOCK_REGISTER.registerBlock("pad_farm", padFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, leafFarmBlock> LEAF_FARM = BLOCK_REGISTER.registerBlock("leaf_farm", leafFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, kelpFarmBlock> KELP_FARM = BLOCK_REGISTER.registerBlock("kelp_farm", kelpFarmBlock::new, BlockBehaviour.Properties.of());

    //    public static final DeferredHolder<Block, ConverterBlock> CONVERTER = BLOCK_REGISTER.registerBlock("converter", ConverterBlock::new, BlockBehaviour.Properties.of());
    //Nether Trees
    public static final DeferredHolder<Block, crimsonFarmBlock> CRIMSON_FARM = BLOCK_REGISTER.registerBlock("crimson_farm", crimsonFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, warpedFarmBlock> WARPED_FARM = BLOCK_REGISTER.registerBlock("warped_farm", warpedFarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, netherWartFarmBlock> WART_FARM = BLOCK_REGISTER.registerBlock("wart_farm", netherWartFarmBlock::new, BlockBehaviour.Properties.of());
    //    public static final DeferredBlock<Block> WATER = REGISTRY.registerBlock("water", waterBlock::new,BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, InventoryViewerBlock> INVENTORY_VIEWER = BLOCK_REGISTER.registerBlock("inventory_viewer", InventoryViewerBlock::new, BlockBehaviour.Properties.of());


    public static final DeferredHolder<Block, FarmBlock> FARM_BLOCK = BLOCK_REGISTER.registerBlock("farm_block", FarmBlock::new, BlockBehaviour.Properties.of());
    public static final DeferredHolder<Block, TFarmBlock> TFARM_BLOCK = BLOCK_REGISTER.registerBlock("tfarm_block", TFarmBlock::new, BlockBehaviour.Properties.of());


    public static void init(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }

}

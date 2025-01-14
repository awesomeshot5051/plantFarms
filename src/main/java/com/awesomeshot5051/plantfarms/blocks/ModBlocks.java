package com.awesomeshot5051.plantfarms.blocks;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.nether.crimsonForest.*;
import com.awesomeshot5051.plantfarms.blocks.nether.other.*;
import com.awesomeshot5051.plantfarms.blocks.nether.warpedForest.*;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.Trees.*;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.crops.*;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.flowers.*;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.miscellaneous.*;
import com.awesomeshot5051.plantfarms.blocks.overworld.underwater.*;
import com.awesomeshot5051.plantfarms.blocks.theend.*;
import net.minecraft.core.registries.*;
import net.minecraft.world.level.block.*;
import net.neoforged.bus.api.*;
import net.neoforged.neoforge.registries.*;

public class ModBlocks {

    /*
     * Custom Water Block For Plant Farm display ONLY
     *
     * */
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(Main.MODID);
    //    private static final DeferredRegister.Blocks BLOCK_REGISTER = DeferredRegister.createBlocks(Main.MODID);
//     End Plants
    public static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK, Main.MODID);
    public static final DeferredHolder<Block, chorusFarmBlock> CHORUS_FARM = BLOCK_REGISTER.register("chorus_farm", chorusFarmBlock::new);
    /// Overworld

    // Overworld Trees
    public static final DeferredHolder<Block, OakFarmBlock> OAK_FARM = BLOCK_REGISTER.register("oak_farm", OakFarmBlock::new);
    public static final DeferredHolder<Block, SpruceFarmBlock> SPRUCE_FARM = BLOCK_REGISTER.register("spruce_farm", SpruceFarmBlock::new);
    public static final DeferredHolder<Block, BirchFarmBlock> BIRCH_FARM = BLOCK_REGISTER.register("birch_farm", BirchFarmBlock::new);
    public static final DeferredHolder<Block, JungleFarmBlock> JUNGLE_FARM = BLOCK_REGISTER.register("jungle_farm", JungleFarmBlock::new);
    public static final DeferredHolder<Block, DarkOakFarmBlock> DARK_OAK_FARM = BLOCK_REGISTER.register("dark_oak_farm", DarkOakFarmBlock::new);
    public static final DeferredHolder<Block, AcaciaFarmBlock> ACACIA_FARM = BLOCK_REGISTER.register("acacia_farm", AcaciaFarmBlock::new);
    public static final DeferredHolder<Block, AzaleaFarmBlock> AZALEA_FARM = BLOCK_REGISTER.register("azalea_farm", AzaleaFarmBlock::new);
    public static final DeferredHolder<Block, MangroveFarmBlock> MANGROVE_FARM = BLOCK_REGISTER.register("mangrove_farm", MangroveFarmBlock::new);

    //Overworld Crops
    public static final DeferredHolder<Block, CherryFarmBlock> CHERRY_FARM = BLOCK_REGISTER.register("cherry_farm", CherryFarmBlock::new);
    public static final DeferredHolder<Block, wheatFarmBlock> WHEAT_FARM = BLOCK_REGISTER.register("wheat_farm", wheatFarmBlock::new);
    public static final DeferredHolder<Block, carrotFarmBlock> CARROT_FARM = BLOCK_REGISTER.register("carrot_farm", carrotFarmBlock::new);
    public static final DeferredHolder<Block, gcarrotFarmBlock> GCARROT_FARM = BLOCK_REGISTER.register("gcarrot_farm", gcarrotFarmBlock::new);
    public static final DeferredHolder<Block, potatoFarmBlock> POTATO_FARM = BLOCK_REGISTER.register("potato_farm", potatoFarmBlock::new);
    public static final DeferredHolder<Block, beetrootFarmBlock> BEETROOT_FARM = BLOCK_REGISTER.register("beetroot_farm", beetrootFarmBlock::new);
    public static final DeferredHolder<Block, pumpkinFarmBlock> PUMPKIN_FARM = BLOCK_REGISTER.register("pumpkin_farm", pumpkinFarmBlock::new);
    public static final DeferredHolder<Block, melonFarmBlock> MELON_FARM = BLOCK_REGISTER.register("melon_farm", melonFarmBlock::new);
    public static final DeferredHolder<Block, sugarFarmBlock> SUGAR_FARM = BLOCK_REGISTER.register("sugar_farm", sugarFarmBlock::new);
    public static final DeferredHolder<Block, cocoFarmBlock> COCO_FARM = BLOCK_REGISTER.register("coco_farm", cocoFarmBlock::new);
    public static final DeferredHolder<Block, berryFarmBlock> BERRY_FARM = BLOCK_REGISTER.register("berry_farm", berryFarmBlock::new);
    public static final DeferredHolder<Block, bambooFarmBlock> BAMBOO_FARM = BLOCK_REGISTER.register("bamboo_farm", bambooFarmBlock::new);

    //Overworld Flowers
    public static final DeferredHolder<Block, dandelionFarmBlock> DANDELION_FARM = BLOCK_REGISTER.register("dandelion_farm", dandelionFarmBlock::new);
    public static final DeferredHolder<Block, poppyFarmBlock> POPPY_FARM = BLOCK_REGISTER.register("poppy_farm", poppyFarmBlock::new);
    public static final DeferredHolder<Block, orchidFarmBlock> ORCHID_FARM = BLOCK_REGISTER.register("orchid_farm", orchidFarmBlock::new);
    public static final DeferredHolder<Block, alliumFarmBlock> ALLIUM_FARM = BLOCK_REGISTER.register("allium_farm", alliumFarmBlock::new);
    public static final DeferredHolder<Block, azureFarmBlock> AZURE_FARM = BLOCK_REGISTER.register("azure_farm", azureFarmBlock::new); // Shortened from azureBluetFarmBlock
    public static final DeferredHolder<Block, redFarmBlock> RED_FARM = BLOCK_REGISTER.register("red_farm", redFarmBlock::new); // Shortened from redTulipFarmBlock
    public static final DeferredHolder<Block, orangeFarmBlock> ORANGE_FARM = BLOCK_REGISTER.register("orange_farm", orangeFarmBlock::new); // Shortened from orangeTulipFarmBlock
    public static final DeferredHolder<Block, whiteFarmBlock> WHITE_FARM = BLOCK_REGISTER.register("white_farm", whiteFarmBlock::new); // Shortened from whiteTulipFarmBlock
    public static final DeferredHolder<Block, pinkFarmBlock> PINK_FARM = BLOCK_REGISTER.register("pink_farm", pinkFarmBlock::new); // Shortened from pinkTulipFarmBlock
    public static final DeferredHolder<Block, daisyFarmBlock> DAISY_FARM = BLOCK_REGISTER.register("daisy_farm", daisyFarmBlock::new); // Shortened from oxeyeDaisyFarmBlock
    public static final DeferredHolder<Block, cornflowerFarmBlock> CORNFLOWER_FARM = BLOCK_REGISTER.register("cornflower_farm", cornflowerFarmBlock::new);
    public static final DeferredHolder<Block, lilyFarmBlock> LILY_FARM = BLOCK_REGISTER.register("lily_farm", lilyFarmBlock::new); // Lily of the Valley
    public static final DeferredHolder<Block, sunflowerFarmBlock> SUNFLOWER_FARM = BLOCK_REGISTER.register("sunflower_farm", sunflowerFarmBlock::new);
    public static final DeferredHolder<Block, lilacFarmBlock> LILAC_FARM = BLOCK_REGISTER.register("lilac_farm", lilacFarmBlock::new);
    public static final DeferredHolder<Block, roseFarmBlock> ROSE_FARM = BLOCK_REGISTER.register("rose_farm", roseFarmBlock::new); // Shortened from roseBushFarmBlock
    public static final DeferredHolder<Block, peonyFarmBlock> PEONY_FARM = BLOCK_REGISTER.register("peony_farm", peonyFarmBlock::new);


    public static final DeferredHolder<Block, vineFarmBlock> VINE_FARM = BLOCK_REGISTER.register("vine_farm", vineFarmBlock::new);
    public static final DeferredHolder<Block, mushroomFarmBlock> MUSHROOM_FARM = BLOCK_REGISTER.register("mushroom_farm", mushroomFarmBlock::new);


    public static final DeferredHolder<Block, cgrassFarmBlock> CGRASS_FARM = BLOCK_REGISTER.register("cgrass_farm", cgrassFarmBlock::new);
    public static final DeferredHolder<Block, padFarmBlock> PAD_FARM = BLOCK_REGISTER.register("pad_farm", padFarmBlock::new);
    public static final DeferredHolder<Block, leafFarmBlock> LEAF_FARM = BLOCK_REGISTER.register("leaf_farm", leafFarmBlock::new);
    public static final DeferredHolder<Block, kelpFarmBlock> KELP_FARM = BLOCK_REGISTER.register("kelp_farm", kelpFarmBlock::new);

    //Nether Trees
    public static final DeferredHolder<Block, crimsonFarmBlock> CRIMSON_FARM = BLOCK_REGISTER.register("crimson_farm", crimsonFarmBlock::new);
    public static final DeferredHolder<Block, warpedFarmBlock> WARPED_FARM = BLOCK_REGISTER.register("warped_farm", warpedFarmBlock::new);
    public static final DeferredHolder<Block, netherWartFarmBlock> WART_FARM = BLOCK_REGISTER.register("wart_farm", netherWartFarmBlock::new);
    public static final DeferredHolder<Block, InventoryViewerBlock> INVENTORY_VIEWER = BLOCK_REGISTER.register("inventory_viewer", InventoryViewerBlock::new);


    public static final DeferredHolder<Block, FarmBlock> FARM_BLOCK = BLOCK_REGISTER.register("farm_block", FarmBlock::new);
    public static final DeferredHolder<Block, TFarmBlock> TFARM_BLOCK = BLOCK_REGISTER.register("tfarm_block", TFarmBlock::new);


    public static void init(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }

}

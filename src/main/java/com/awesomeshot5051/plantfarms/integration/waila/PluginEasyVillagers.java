package com.awesomeshot5051.plantfarms.integration.waila;

import com.awesomeshot5051.plantfarms.blocks.*;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.*;
import snownee.jade.api.*;

import java.util.*;

import static com.awesomeshot5051.plantfarms.blocks.ModBlocks.*;

@WailaPlugin
public class PluginEasyVillagers implements IWailaPlugin {
    public static final List<DeferredHolder<Block, ?>> ALL_FARMS = List.of(
            CHORUS_FARM,

            // Overworld Trees
            OAK_FARM,
            SPRUCE_FARM,
            BIRCH_FARM,
            JUNGLE_FARM,
            DARK_OAK_FARM,
            ACACIA_FARM,
            AZALEA_FARM,
            MANGROVE_FARM,

            // Overworld Crops
            CHERRY_FARM,
            WHEAT_FARM,
            CARROT_FARM,
            GCARROT_FARM,
            POTATO_FARM,
            BEETROOT_FARM,
            PUMPKIN_FARM,
            MELON_FARM,
            SUGAR_FARM,
            COCO_FARM,
            BERRY_FARM,
            BAMBOO_FARM,

            // Overworld Flowers
            DANDELION_FARM,
            POPPY_FARM,
            ORCHID_FARM,
            ALLIUM_FARM,
            AZURE_FARM,
            RED_FARM,
            ORANGE_FARM,
            WHITE_FARM,
            PINK_FARM,
            DAISY_FARM,
            CORNFLOWER_FARM,
            LILY_FARM,
            SUNFLOWER_FARM,
            LILAC_FARM,
            ROSE_FARM,
            PEONY_FARM,

            // Other Overworld Farms
            VINE_FARM,
            MUSHROOM_FARM,
            CGRASS_FARM,
            PAD_FARM,
            LEAF_FARM,
            KELP_FARM,

            // Nether Trees
            CRIMSON_FARM,
            WARPED_FARM,
            WART_FARM,

            // Miscellaneous Farms
            FARM_BLOCK,
            TFARM_BLOCK
    );

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        for (var sidedBlock : ModBlocks.BLOCK_REGISTER.getEntries()) {
            registration.registerBlockComponent(HUDHandlerVillager.INSTANCE, sidedBlock.get().getClass());
        }
        for (var sidedBlock : ModBlocks.BLOCK_REGISTER.getEntries()) {
            registration.registerBlockIcon(HUDHandlerVillager.INSTANCE, sidedBlock.get().getClass());
        }
    }

}

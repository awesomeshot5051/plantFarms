package com.awesomeshot5051.plantfarms;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.items.*;
import net.minecraft.core.registries.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.*;
import net.neoforged.neoforge.registries.*;

public class ModCreativeTabs {
    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_PLANT_FARMS = TAB_REGISTER.register("plant_farms", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OAK_FARM.get())).displayItems((features, output) -> {
        output.accept(new ItemStack(ModBlocks.INVENTORY_VIEWER.get()));
        output.accept(new ItemStack(ModBlocks.CHORUS_FARM.get()));
        output.accept(new ItemStack(ModBlocks.OAK_FARM.get()));
        output.accept(new ItemStack(ModBlocks.SPRUCE_FARM.get()));
        output.accept(new ItemStack(ModBlocks.BIRCH_FARM.get()));
        output.accept(new ItemStack(ModBlocks.JUNGLE_FARM.get()));
        output.accept(new ItemStack(ModBlocks.DARK_OAK_FARM.get()));
        output.accept(new ItemStack(ModBlocks.ACACIA_FARM.get()));
        output.accept(new ItemStack(ModBlocks.AZALEA_FARM.get()));
        output.accept(new ItemStack(ModBlocks.MANGROVE_FARM.get()));
        output.accept(new ItemStack(ModBlocks.CHERRY_FARM.get()));
        output.accept(new ItemStack(ModBlocks.WHEAT_FARM.get()));
        output.accept(new ItemStack(ModBlocks.CARROT_FARM.get()));
        output.accept(new ItemStack(ModBlocks.GCARROT_FARM.get()));
        output.accept(new ItemStack(ModBlocks.POTATO_FARM.get()));
        output.accept(new ItemStack(ModBlocks.BEETROOT_FARM.get()));
        output.accept(new ItemStack(ModBlocks.PUMPKIN_FARM.get()));
        output.accept(new ItemStack(ModBlocks.MELON_FARM.get()));
        output.accept(new ItemStack(ModBlocks.SUGAR_FARM.get()));
        output.accept(new ItemStack(ModBlocks.COCO_FARM.get()));
        output.accept(new ItemStack(ModBlocks.BERRY_FARM.get()));
        output.accept(new ItemStack(ModBlocks.BAMBOO_FARM.get()));
        output.accept(new ItemStack(ModBlocks.DANDELION_FARM.get()));
        output.accept(new ItemStack(ModBlocks.POPPY_FARM.get()));
        output.accept(new ItemStack(ModBlocks.ORCHID_FARM.get()));
        output.accept(new ItemStack(ModBlocks.ALLIUM_FARM.get()));
        output.accept(new ItemStack(ModBlocks.AZURE_FARM.get()));
        output.accept(new ItemStack(ModBlocks.RED_FARM.get()));
        output.accept(new ItemStack(ModBlocks.ORANGE_FARM.get()));
        output.accept(new ItemStack(ModBlocks.WHITE_FARM.get()));
        output.accept(new ItemStack(ModBlocks.PINK_FARM.get()));
        output.accept(new ItemStack(ModBlocks.DAISY_FARM.get()));
        output.accept(new ItemStack(ModBlocks.CORNFLOWER_FARM.get()));
        output.accept(new ItemStack(ModBlocks.LILY_FARM.get()));
        output.accept(new ItemStack(ModBlocks.SUNFLOWER_FARM.get()));
        output.accept(new ItemStack(ModBlocks.LILAC_FARM.get()));
        output.accept(new ItemStack(ModBlocks.ROSE_FARM.get()));
        output.accept(new ItemStack(ModBlocks.PEONY_FARM.get()));
        output.accept(new ItemStack(ModBlocks.VINE_FARM.get()));
        output.accept(new ItemStack(ModBlocks.MUSHROOM_FARM.get()));
        output.accept(new ItemStack(ModBlocks.PAD_FARM.get()));
        output.accept(new ItemStack(ModBlocks.LEAF_FARM.get()));
        output.accept(new ItemStack(ModBlocks.KELP_FARM.get()));
        output.accept(new ItemStack(ModBlocks.CGRASS_FARM.get()));
        output.accept(new ItemStack(ModBlocks.CRIMSON_FARM.get()));
        output.accept(new ItemStack(ModBlocks.WARPED_FARM.get()));
        output.accept(new ItemStack(ModBlocks.WART_FARM.get()));
        output.accept(new ItemStack(ModBlocks.FARM_BLOCK.get()));
        output.accept(new ItemStack(ModBlocks.TFARM_BLOCK.get()));
    }).title(Component.translatable("itemGroup.plant_farms")).build());

    public static void init(IEventBus eventBus) {
        TAB_REGISTER.register(eventBus);
    }
}
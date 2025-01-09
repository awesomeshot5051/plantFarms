package com.awesomeshot5051.plantfarms.data.providers.recipe;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.data.providers.recipe.recipe.*;
import com.awesomeshot5051.plantfarms.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.awesomeshot5051.plantfarms.blocks.ModBlocks.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // List of blocks that require a pickaxe to mine
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


    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, OAK_FARM.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("#O#")
                .define('O', Items.OAK_SAPLING)
                .define('#', Tags.Items.GLASS_PANES)
                .define('A', ItemTags.AXES)
                .unlockedBy("has_oak_sapling", has(Items.OAK_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(OAK_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, BIRCH_FARM.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("#O#")
                .define('O', Items.BIRCH_SAPLING)
                .define('#', Tags.Items.GLASS_PANES)
                .define('A', ItemTags.AXES)
                .unlockedBy("has_birch_sapling", has(Items.BIRCH_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(BIRCH_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, SPRUCE_FARM.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("#O#")
                .define('O', Items.SPRUCE_SAPLING)
                .define('#', Tags.Items.GLASS_PANES)
                .define('A', ItemTags.AXES)
                .unlockedBy("has_spruce_sapling", has(Items.SPRUCE_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(SPRUCE_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, JUNGLE_FARM.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("#O#")
                .define('O', Items.JUNGLE_SAPLING)
                .define('#', Tags.Items.GLASS_PANES)
                .define('A', ItemTags.AXES)
                .unlockedBy("has_jungle_sapling", has(Items.JUNGLE_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(JUNGLE_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ACACIA_FARM.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("#O#")
                .define('O', Items.ACACIA_SAPLING)
                .define('#', Tags.Items.GLASS_PANES)
                .define('A', ItemTags.AXES)
                .unlockedBy("has_acacia_sapling", has(Items.ACACIA_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ACACIA_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, DARK_OAK_FARM.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("#O#")
                .define('O', Items.DARK_OAK_SAPLING)
                .define('#', Tags.Items.GLASS_PANES)
                .define('A', ItemTags.AXES)
                .unlockedBy("has_dark_oak_sapling", has(Items.DARK_OAK_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(DARK_OAK_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, MANGROVE_FARM.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("#O#")
                .define('O', Items.MANGROVE_LEAVES)
                .define('#', Tags.Items.GLASS_PANES)
                .define('A', ItemTags.AXES)
                .unlockedBy("has_mangrove_leaves", has(Items.MANGROVE_LEAVES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(MANGROVE_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, CHERRY_FARM.get())
                .pattern("###")
                .pattern("#A#")
                .pattern("#O#")
                .define('O', Items.CHERRY_SAPLING)
                .define('#', Tags.Items.GLASS_PANES)
                .define('A', ItemTags.AXES)
                .unlockedBy("has_cherry_sapling", has(Items.CHERRY_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CHERRY_FARM.get().getDescriptionId() + "_recipe")));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, CGRASS_FARM.get())
                .pattern("###")
                .pattern("#W#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('W', Items.WATER_BUCKET)
                .define('C', Items.SEAGRASS)
                .unlockedBy("has_seagrass", has(Items.SEAGRASS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CGRASS_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, KELP_FARM.get())
                .pattern("###")
                .pattern("#W#")
                .pattern("#K#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('W', Items.WATER_BUCKET)
                .define('K', Items.KELP)
                .unlockedBy("has_kelp", has(Items.KELP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(KELP_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, LEAF_FARM.get())
                .pattern("###")
                .pattern("#W#")
                .pattern("#L#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('W', Items.WATER_BUCKET)
                .define('L', Ingredient.of(Items.SMALL_DRIPLEAF, Items.BIG_DRIPLEAF))
                .unlockedBy("has_dripleaf", has(Items.SMALL_DRIPLEAF))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(LEAF_FARM.get().getDescriptionId() + "_recipe")));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, PAD_FARM.get())
                .pattern("###")
                .pattern("#W#")
                .pattern("#P#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('W', Items.WATER_BUCKET)
                .define('P', Items.LILY_PAD)
                .unlockedBy("has_lily_pad", has(Items.LILY_PAD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(PAD_FARM.get().getDescriptionId() + "_recipe")));
// Overworld Flower Farms
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, DANDELION_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.DANDELION)
                .unlockedBy("has_dandelion", has(Items.DANDELION))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(DANDELION_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, POPPY_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.POPPY)
                .unlockedBy("has_poppy", has(Items.POPPY))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(POPPY_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ORCHID_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.BLUE_ORCHID)
                .unlockedBy("has_blue_orchid", has(Items.BLUE_ORCHID))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ORCHID_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ALLIUM_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.ALLIUM)
                .unlockedBy("has_allium", has(Items.ALLIUM))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ALLIUM_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, AZURE_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.AZURE_BLUET)
                .unlockedBy("has_azure_bluet", has(Items.AZURE_BLUET))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(AZURE_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, RED_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.RED_TULIP)
                .unlockedBy("has_red_tulip", has(Items.RED_TULIP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(RED_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ORANGE_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.ORANGE_TULIP)
                .unlockedBy("has_orange_tulip", has(Items.ORANGE_TULIP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ORANGE_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, WHITE_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.WHITE_TULIP)
                .unlockedBy("has_white_tulip", has(Items.WHITE_TULIP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(WHITE_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, PINK_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.PINK_TULIP)
                .unlockedBy("has_pink_tulip", has(Items.PINK_TULIP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(PINK_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, DAISY_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.OXEYE_DAISY)
                .unlockedBy("has_oxeye_daisy", has(Items.OXEYE_DAISY))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(DAISY_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, CORNFLOWER_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.CORNFLOWER)
                .unlockedBy("has_cornflower", has(Items.CORNFLOWER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CORNFLOWER_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, LILY_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.LILY_OF_THE_VALLEY)
                .unlockedBy("has_lily_of_the_valley", has(Items.LILY_OF_THE_VALLEY))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(LILY_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, SUNFLOWER_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.SUNFLOWER)
                .unlockedBy("has_sunflower", has(Items.SUNFLOWER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(SUNFLOWER_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, LILAC_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.LILAC)
                .unlockedBy("has_lilac", has(Items.LILAC))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(LILAC_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, ROSE_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.ROSE_BUSH)
                .unlockedBy("has_rose", has(Items.ROSE_BUSH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ROSE_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, PEONY_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.PEONY)
                .unlockedBy("has_peony", has(Items.PEONY))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(PEONY_FARM.get().getDescriptionId() + "_recipe")));
// Overworld Crop Farms

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, WHEAT_FARM.get())
                .pattern("###")
                .pattern("#H#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('H', ItemTags.HOES)
                .define('C', Items.WHEAT)
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(WHEAT_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, CARROT_FARM.get())
                .pattern("###")
                .pattern("#H#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('H', ItemTags.HOES)
                .define('C', Items.CARROT)
                .unlockedBy("has_carrot", has(Items.CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CARROT_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, GCARROT_FARM.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("###")
                .define('#', Items.GOLD_NUGGET)
                .define('F', CARROT_FARM.get())
                .unlockedBy("has_golden_carrot", has(Items.GOLDEN_CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(GCARROT_FARM.get().getDescriptionId() + "_recipe")));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FARM_BLOCK.get())
                .pattern("###")
                .pattern("#W#")
                .pattern("#D#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('D', Items.DIRT)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy("has_dirt", has(Items.DIRT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, FARM_BLOCK.get().getDescriptionId() + "_recipe"));
        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, POTATO_FARM.get())
                .pattern("###")
                .pattern("#H#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('H', ItemTags.HOES)
                .define('C', Items.POTATO)
                .unlockedBy("has_potato", has(Items.POTATO))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(POTATO_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, BEETROOT_FARM.get())
                .pattern("###")
                .pattern("#H#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('H', ItemTags.HOES)
                .define('C', Items.BEETROOT)
                .unlockedBy("has_beetroot", has(Items.BEETROOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(BEETROOT_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, PUMPKIN_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.PUMPKIN)
                .unlockedBy("has_pumpkin", has(Items.PUMPKIN))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(PUMPKIN_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, MELON_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.MELON)
                .unlockedBy("has_melon", has(Items.MELON))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(MELON_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, SUGAR_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.SUGAR_CANE)
                .unlockedBy("has_sugar_cane", has(Items.SUGAR_CANE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(SUGAR_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, COCO_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.COCOA_BEANS)
                .unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(COCO_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, BERRY_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.SWEET_BERRIES)
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(BERRY_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapedRecipeBuilder.shaped(RecipeCategory.MISC, BAMBOO_FARM.get())
                .pattern("###")
                .pattern("#B#")
                .pattern("#C#")
                .define('#', Tags.Items.GLASS_PANES)
                .define('B', Items.BONE_MEAL)
                .define('C', Items.BAMBOO)
                .unlockedBy("has_bamboo", has(Items.BAMBOO))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(BAMBOO_FARM.get().getDescriptionId() + "_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GCARROT_FARM.get())
                .requires(TFARM_BLOCK.get())
                .requires(Items.GOLDEN_CARROT)
                .unlockedBy("has_golden_carrot", has(Items.GOLDEN_CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(GCARROT_FARM.get().getDescriptionId() + "_alternate_recipe")));
        TFarmBlockRecipeBuilder.shapeless(RecipeCategory.MISC, TFARM_BLOCK.get())
                .requires(FARM_BLOCK.get())
                .requires(ItemTags.HOES)
                .unlockedBy("has_farm_block", has(FARM_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(TFARM_BLOCK.get().getDescriptionId() + "_recipe")));


        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ACACIA_FARM.get())
                .requires(Items.ACACIA_SAPLING)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_acacia_sapling", has(Items.ACACIA_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ACACIA_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BIRCH_FARM.get())
                .requires(Items.BIRCH_SAPLING)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_birch_sapling", has(Items.BIRCH_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(BIRCH_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DARK_OAK_FARM.get())
                .requires(Items.DARK_OAK_SAPLING)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_dark_oak_sapling", has(Items.DARK_OAK_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(DARK_OAK_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, JUNGLE_FARM.get())
                .requires(Items.JUNGLE_SAPLING)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_jungle_sapling", has(Items.JUNGLE_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(JUNGLE_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MANGROVE_FARM.get())
                .requires(Items.MANGROVE_PROPAGULE)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_mangrove_propagule", has(Items.MANGROVE_PROPAGULE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(MANGROVE_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, OAK_FARM.get())
                .requires(Items.OAK_SAPLING)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_oak_sapling", has(Items.OAK_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(OAK_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SPRUCE_FARM.get())
                .requires(Items.SPRUCE_SAPLING)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_spruce_sapling", has(Items.SPRUCE_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(SPRUCE_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CRIMSON_FARM.get())
                .requires(Items.CRIMSON_FUNGUS)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_crimson_fungus", has(Items.CRIMSON_FUNGUS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CRIMSON_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WARPED_FARM.get())
                .requires(Items.WARPED_FUNGUS)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_warped_fungus", has(Items.WARPED_FUNGUS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(WARPED_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CHERRY_FARM.get())
                .requires(Items.CHERRY_SAPLING)
                .requires(ModItems.FARM_BLOCK.get())
                .requires(Ingredient.of(ItemTags.AXES))
                .unlockedBy("has_cherry_sapling", has(Items.CHERRY_SAPLING))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CHERRY_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BEETROOT_FARM.get())
                .requires(Items.BEETROOT)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.TFARM_BLOCK.get())
                .unlockedBy("has_beetroot", has(Items.BEETROOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(BEETROOT_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CARROT_FARM.get())
                .requires(Items.CARROT)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.TFARM_BLOCK.get())
                .unlockedBy("has_carrot", has(Items.CARROT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CARROT_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MELON_FARM.get())
                .requires(Items.MELON_SLICE)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.TFARM_BLOCK.get())
                .unlockedBy("has_melon_slice", has(Items.MELON_SLICE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(MELON_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WHEAT_FARM.get())
                .requires(Items.WHEAT)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.TFARM_BLOCK.get())
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(WHEAT_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, POTATO_FARM.get())
                .requires(Items.POTATO)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.TFARM_BLOCK.get())
                .unlockedBy("has_potato", has(Items.POTATO))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(POTATO_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PUMPKIN_FARM.get())
                .requires(Items.PUMPKIN)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.TFARM_BLOCK.get())
                .unlockedBy("has_pumpkin", has(Items.PUMPKIN))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(PUMPKIN_FARM.get().getDescriptionId() + "_alternate_recipe")));
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AZALEA_FARM.get())
                .requires(Items.AZALEA)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FARM_BLOCK.get())
                .unlockedBy("has_azalea", has(Items.AZALEA))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(AZALEA_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BERRY_FARM.get())
                .requires(Items.SWEET_BERRIES)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FARM_BLOCK.get())
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(BERRY_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CGRASS_FARM.get())
                .requires(Items.SEAGRASS)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FARM_BLOCK.get())
                .unlockedBy("has_seagrass", has(Items.SEAGRASS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CGRASS_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CHORUS_FARM.get())
                .requires(Items.CHORUS_FLOWER)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FARM_BLOCK.get())
                .unlockedBy("has_chorus_flower", has(Items.CHORUS_FLOWER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CHORUS_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, KELP_FARM.get())
                .requires(Items.KELP)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FARM_BLOCK.get())
                .unlockedBy("has_kelp", has(Items.KELP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(KELP_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MUSHROOM_FARM.get())
                .requires(Items.BROWN_MUSHROOM)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FARM_BLOCK.get())
                .unlockedBy("has_brown_mushroom", has(Items.BROWN_MUSHROOM))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(MUSHROOM_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PAD_FARM.get())
                .requires(Items.LILY_PAD)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FARM_BLOCK.get())
                .unlockedBy("has_lily_pad", has(Items.LILY_PAD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(PAD_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, VINE_FARM.get())
                .requires(Items.VINE)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.FARM_BLOCK.get())
                .unlockedBy("has_vine", has(Items.VINE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(VINE_FARM.get().getDescriptionId() + "_alternate_recipe")));

        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SUNFLOWER_FARM.get())
                .requires(Items.SUNFLOWER)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_sunflower", has(Items.SUNFLOWER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(SUNFLOWER_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Lilac Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LILAC_FARM.get())
                .requires(Items.LILAC)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_lilac", has(Items.LILAC))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(LILAC_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Rose Bush Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ROSE_FARM.get())
                .requires(Items.ROSE_BUSH)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_rose_bush", has(Items.ROSE_BUSH))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ROSE_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Peony Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PEONY_FARM.get())
                .requires(Items.PEONY)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_peony", has(Items.PEONY))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(PEONY_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Dandelion Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DANDELION_FARM.get())
                .requires(Items.DANDELION)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_dandelion", has(Items.DANDELION))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(DANDELION_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Poppy Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, POPPY_FARM.get())
                .requires(Items.POPPY)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_poppy", has(Items.POPPY))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(POPPY_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Blue Orchid Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ORCHID_FARM.get())
                .requires(Items.BLUE_ORCHID)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_blue_orchid", has(Items.BLUE_ORCHID))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ORCHID_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Allium Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ALLIUM_FARM.get())
                .requires(Items.ALLIUM)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_allium", has(Items.ALLIUM))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ALLIUM_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Azure Bluet Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AZURE_FARM.get())
                .requires(Items.AZURE_BLUET)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_azure_bluet", has(Items.AZURE_BLUET))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(AZURE_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Red Tulip Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RED_FARM.get())
                .requires(Items.RED_TULIP)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_red_tulip", has(Items.RED_TULIP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(RED_FARM.get().getDescriptionId() + "_alternate_recipe")));

// Orange Tulip Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ORANGE_FARM.get())
                .requires(Items.ORANGE_TULIP)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_orange_tulip", has(Items.ORANGE_TULIP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(ORANGE_FARM.get().getDescriptionId() + "_alternate_recipe")));

// White Tulip Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WHITE_FARM.get())
                .requires(Items.WHITE_TULIP)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_white_tulip", has(Items.WHITE_TULIP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(WHITE_FARM.get().getDescriptionId() + "_alternate_recipe")));

        // Pink Tulip Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, PINK_FARM.get())
                .requires(Items.PINK_TULIP)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_pink_tulip", has(Items.PINK_TULIP))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(PINK_FARM.get().getDescriptionId() + "_alternate_recipe")));

        // Oxeye Daisy Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DAISY_FARM.get())
                .requires(Items.OXEYE_DAISY)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_oxeye_daisy", has(Items.OXEYE_DAISY))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(DAISY_FARM.get().getDescriptionId() + "_alternate_recipe")));

        // Cornflower Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CORNFLOWER_FARM.get())
                .requires(Items.CORNFLOWER)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_cornflower", has(Items.CORNFLOWER))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(CORNFLOWER_FARM.get().getDescriptionId() + "_alternate_recipe")));

        // Lily of the Valley Farm Recipe
        CustomShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LILY_FARM.get())
                .requires(Items.LILY_OF_THE_VALLEY)
                .requires(Items.WATER_BUCKET)
                .requires(FARM_BLOCK.get())
                .unlockedBy("has_lily_of_the_valley", has(Items.LILY_OF_THE_VALLEY))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(LILY_FARM.get().getDescriptionId() + "_alternate_recipe")));


        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" S ")
                    .pattern("SFS")
                    .pattern(" S ")
                    .define('S', Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE))
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_stone", has(Items.COBBLESTONE))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_stone_upgrade_recipe"));
        });

        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" I ")
                    .pattern("IFI")
                    .pattern(" I ")
                    .define('I', Items.IRON_INGOT)
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_iron", has(Items.IRON_INGOT))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_iron_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" G ")
                    .pattern("GFG")
                    .pattern(" G ")
                    .define('G', Items.GOLD_INGOT)
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_gold_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" D ")
                    .pattern("DFD")
                    .pattern(" D ")
                    .define('D', Items.DIAMOND)
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_diamond", has(Items.DIAMOND))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_diamond_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            UpgradeRecipeBuilder.shaped(RecipeCategory.MISC, farmBlock)
                    .pattern(" N ")
                    .pattern("NFN")
                    .pattern(" N ")
                    .define('N', Items.NETHERITE_INGOT)
                    .define('F', farmBlock.asItem())
                    .unlockedBy("has_netherite", has(Items.NETHERITE_INGOT))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_netherite_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            EnchantmentAdditionRecipeBuilder.shapeless(RecipeCategory.MISC, farmBlock)
                    .requires(Items.ENCHANTED_BOOK)
                    .requires(farmBlock.asItem())
                    .unlockedBy("has_enchanted_book", has(ItemTags.SWORD_ENCHANTABLE))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId()) + "_enchant_upgrade_recipe"));
        });
        ALL_FARMS.forEach(farmBlockSupplier -> {
            Block farmBlock = farmBlockSupplier.get();
            EnchantmentRemovalRecipeBuilder.shapeless(RecipeCategory.MISC, farmBlock)
                    .requires(farmBlock.asItem())
                    .unlockedBy("has_farm", has(farmBlock.asItem()))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Main.MODID, convertToRegistryName(farmBlock.getDescriptionId() + "_enchantment_removal_recipe")));
        });

    }

    private String convertToRegistryName(String block) {
        return block.toLowerCase().replace(' ', '_').replace("block.plant_farms.", "");
    }

}

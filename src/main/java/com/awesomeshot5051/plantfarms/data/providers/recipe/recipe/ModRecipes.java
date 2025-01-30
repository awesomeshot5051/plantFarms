package com.awesomeshot5051.plantfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.plantfarms.*;
import net.minecraft.core.registries.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.*;
import net.neoforged.neoforge.registries.*;

import java.util.function.*;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Main.MODID);
    public static final Supplier<RecipeSerializer<CustomShapedRecipe>> SHAPED_SERIALIZER = RECIPE_SERIALIZERS.register("shaped_serializer", CustomShapedRecipe.Serializer::new);
    public static final Supplier<RecipeSerializer<CustomShapelessBlockRecipe>> SHAPELESS_SERIALIZER = RECIPE_SERIALIZERS.register("shapeless_serializer", CustomShapelessBlockRecipe.Serializer::new);
    public static final Supplier<RecipeSerializer<UpgradeRecipe>> UPGRADE_SERIALIZER = RECIPE_SERIALIZERS.register("upgrade_serializer", UpgradeRecipe.Serializer::new);
    public static final Supplier<RecipeSerializer<EnchantmentAdditionRecipe>> ENCHANTING_SERIALIZER = RECIPE_SERIALIZERS.register("enchanting_serializer", EnchantmentAdditionRecipe.Serializer::new);
    public static final Supplier<RecipeSerializer<EnchantmentRemovalRecipe>> ENCHANTMENT_REMOVER_SERIALIZER = RECIPE_SERIALIZERS.register("enchantment_remover_serializer", EnchantmentRemovalRecipe.Serializer::new);
    public static final Supplier<RecipeSerializer<TFarmBlockRecipe>> TFARM_SERIALIZER = RECIPE_SERIALIZERS.register("tfarm_serializer", TFarmBlockRecipe.Serializer::new);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, Main.MODID);
    public static final Supplier<RecipeType<CustomShapedRecipe>> FARM_RECIPE = RECIPE_TYPES.register("farm_recipe", () -> RecipeType.simple(ResourceLocation.fromNamespaceAndPath(Main.MODID, "farm_recipe")));
    public static final Supplier<RecipeType<CustomShapelessBlockRecipe>> SHAPELESS_FARM_RECIPE = RECIPE_TYPES.register("shapeless_farm_recipe", () -> RecipeType.simple(ResourceLocation.fromNamespaceAndPath(Main.MODID, "shapeless_farm_recipe")));
    public static final Supplier<RecipeType<UpgradeRecipe>> UPGRADE_RECIPE = RECIPE_TYPES.register("upgrade_recipe", () -> RecipeType.simple(ResourceLocation.fromNamespaceAndPath(Main.MODID, "upgrade_recipe")));
    public static final Supplier<RecipeType<EnchantmentAdditionRecipe>> ENCHANTING_RECIPE = RECIPE_TYPES.register("enchanting_recipe", () -> RecipeType.simple(ResourceLocation.fromNamespaceAndPath(Main.MODID, "enchanting_recipe")));
    public static final Supplier<RecipeSerializer<CardUpgradeRecipe>> CARD_UPGRADE_SERIALIZER =
            RECIPE_SERIALIZERS.register("card_upgrade_serializer", CardUpgradeRecipe.Serializer::new);
    public static void registerRecipes(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }

    public static void registerTypes(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}
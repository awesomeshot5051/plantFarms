package com.awesomeshot5051.plantfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.core.*;
import net.minecraft.core.component.*;
import net.minecraft.core.registries.*;
import net.minecraft.network.*;
import net.minecraft.network.codec.*;
import net.minecraft.resources.*;
import net.minecraft.tags.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.*;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.stream.*;

public class UpgradeRecipe extends ShapedRecipe {


    public final ShapedRecipePattern pattern;
    final String group;
    final CraftingBookCategory category;
    final boolean showNotification;
    final ItemStack result;
    List<Item> shovelFarms = new ArrayList<>(List.of(

    ));

    private ItemStack result2;

    public UpgradeRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, boolean showNotification) {
        super(group, category, pattern, result, showNotification);
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
        this.result2 = result;
        this.showNotification = showNotification;
    }

    public UpgradeRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result) {
        this(group, category, pattern, result, true);
    }

    public static List<Item> getPlanks() {

        // Retrieve all items in the "planks" tag
        return BuiltInRegistries.ITEM.getTag(ItemTags.PLANKS)
                .stream()
                .flatMap(holderSet -> holderSet.stream().map(Holder::value))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeSerializer<UpgradeRecipe> getSerializer() {
        return ModRecipes.UPGRADE_SERIALIZER.get();
    }

    public boolean matches(CraftingInput input, Level level) {
        return this.pattern.matches(input);
    }

    public ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, result.getDescriptionId());
    }

    private boolean areAllModifiersEqual(List<ItemStack> modifier) {
        return modifier.size() == 4
                && modifier.get(0).toString().equals(modifier.get(1).toString())
                && modifier.get(0).toString().equals(modifier.get(2).toString())
                && modifier.get(0).toString().equals(modifier.get(3).toString());
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider registries) {
        Map<Ingredient, Item> materialToAxeMap = Map.of(
                Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS), Items.WOODEN_AXE,
                Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE), Items.STONE_AXE,
                Ingredient.of(Items.IRON_INGOT), Items.IRON_AXE,
                Ingredient.of(Items.GOLD_INGOT), Items.GOLDEN_AXE,
                Ingredient.of(Items.DIAMOND), Items.DIAMOND_AXE,
                Ingredient.of(Items.NETHERITE_INGOT), Items.NETHERITE_AXE
        );
        Map<Ingredient, Item> materialToHoeMap = Map.of(
                Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS), Items.WOODEN_HOE,
                Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE), Items.STONE_HOE,
                Ingredient.of(Items.IRON_INGOT), Items.IRON_HOE,
                Ingredient.of(Items.GOLD_INGOT), Items.GOLDEN_HOE,
                Ingredient.of(Items.DIAMOND), Items.DIAMOND_HOE,
                Ingredient.of(Items.NETHERITE_INGOT), Items.NETHERITE_HOE
        );
        if (craftingInput.getItem(4).has(ModDataComponents.AXE_TYPE)) {
            ItemEnchantments itemenchantments = ItemEnchantments.EMPTY;
            List<ItemStack> modifer = new ArrayList<>(List.of(craftingInput.getItem(1), craftingInput.getItem(3), craftingInput.getItem(5), craftingInput.getItem(7)));
            if (areAllModifiersEqual(modifer)) {
                List<ItemStack> itemStacks = new ArrayList<>();
                ItemStack axeStack;

                if (craftingInput.getItem(4).get(ModDataComponents.AXE_TYPE) != null) {
                    axeStack = Objects.requireNonNull(craftingInput.getItem(4).get(ModDataComponents.AXE_TYPE)).copyOne();
                } else {
                    axeStack = new ItemStack(Items.STONE_AXE);
                }
                if (isHigherAxeType(axeStack, modifer.getFirst())) {
                    itemStacks.add(getResultItem(registries));
                    for (Map.Entry<Ingredient, Item> entry : materialToAxeMap.entrySet()) {
                        if (entry.getKey().test(modifer.getFirst())) {
                            // Convert the modifier into its corresponding SWORD
                            itemenchantments = axeStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
                            axeStack = new ItemStack(entry.getValue());
                            axeStack.set(DataComponents.ENCHANTMENTS, itemenchantments);
                            break; // Break since we found the corresponding SWORD
                        }
                    }
                    // Set the pick type in the result item's data
                    ItemContainerContents axeContents = ItemContainerContents.fromItems(Collections.singletonList(axeStack));
                    result2 = getResultItem(registries).copy();
                    result2.set(ModDataComponents.AXE_TYPE, axeContents);
                    result2.set(DataComponents.STORED_ENCHANTMENTS, itemenchantments);// Copy the result item to avoid modifying the original
                } else {
                    return new ItemStack(Items.AIR);
                }
            }
        } else if (craftingInput.getItem(4).has(ModDataComponents.HOE_TYPE)) {
            ItemEnchantments itemenchantments = ItemEnchantments.EMPTY;
            List<ItemStack> modifer = new ArrayList<>(List.of(craftingInput.getItem(1), craftingInput.getItem(3), craftingInput.getItem(5), craftingInput.getItem(7)));
            if (areAllModifiersEqual(modifer)) {
                List<ItemStack> itemStacks = new ArrayList<>();
                ItemStack hoeStack;

                if (craftingInput.getItem(4).get(ModDataComponents.HOE_TYPE) != null) {
                    hoeStack = Objects.requireNonNull(craftingInput.getItem(4).get(ModDataComponents.HOE_TYPE)).copyOne();
                } else {
                    hoeStack = new ItemStack(Items.STONE_HOE);
                }
                if (isHigherHoeType(hoeStack, modifer.getFirst())) {
                    itemStacks.add(getResultItem(registries));
                    for (Map.Entry<Ingredient, Item> entry : materialToHoeMap.entrySet()) {
                        if (entry.getKey().test(modifer.getFirst())) {
                            // Convert the modifier into its corresponding SWORD
                            itemenchantments = hoeStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
                            hoeStack = new ItemStack(entry.getValue());
                            hoeStack.set(DataComponents.ENCHANTMENTS, itemenchantments);
                            break; // Break since we found the corresponding SWORD
                        }
                    }
                    // Set the pick type in the result item's data
                    ItemContainerContents hoeContents = ItemContainerContents.fromItems(Collections.singletonList(hoeStack));
                    result2 = getResultItem(registries).copy();
                    result2.set(ModDataComponents.HOE_TYPE, hoeContents);
                    result2.set(DataComponents.STORED_ENCHANTMENTS, itemenchantments);// Copy the result item to avoid modifying the original
                } else {
                    return new ItemStack(Items.AIR);
                }
            }
        }

        super.assemble(craftingInput, registries);
        return result2;
    }

    private boolean isHigherAxeType(ItemStack baseAxeType, ItemStack modifierAxeType) {
        // Define PickType levels in ascending order of strength
        List<Item> axeTypeHierarchy = new ArrayList<>(List.of(
                Items.WOODEN_AXE, Items.GOLDEN_AXE, Items.STONE_AXE, Items.IRON_AXE,
                Items.DIAMOND_AXE, Items.NETHERITE_AXE
        ));

        // Map each SWORD type to its corresponding material
        Map<Item, Ingredient> AxeToMaterialMap = Map.of(
                Items.WOODEN_AXE, Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS,
                        Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS,
                        Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS),
                Items.GOLDEN_AXE, Ingredient.of(Items.GOLD_INGOT),
                Items.STONE_AXE, Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE),
                Items.IRON_AXE, Ingredient.of(Items.IRON_INGOT),
                Items.DIAMOND_AXE, Ingredient.of(Items.DIAMOND),
                Items.NETHERITE_AXE, Ingredient.of(Items.NETHERITE_INGOT)
        );

        // Convert baseAxeType and modifierAxeType to their corresponding materials
        Item baseAxeItem = baseAxeType.getItem();
        Item modifierAxeItem = modifierAxeType.getItem();

        Item baseMaterialType = null;
        Item modifierMaterialType = null;

        // Find the materials corresponding to the SWORD items
        for (Map.Entry<Item, Ingredient> entry : AxeToMaterialMap.entrySet()) {
            if (entry.getKey().equals(baseAxeType.getItem())) {
                baseMaterialType = entry.getKey();
            }
            if (entry.getValue().test(modifierAxeType)) {
                modifierMaterialType = entry.getKey();
            }
        }

        // Ensure both types were mapped to a valid SWORD
        if (baseMaterialType == null || modifierMaterialType == null) {
            return false; // Invalid types, cannot compare
        }

        // Compare indices in the hierarchy
        int baseIndex = axeTypeHierarchy.indexOf(baseMaterialType);
        int modifierIndex = axeTypeHierarchy.indexOf(modifierMaterialType);

        // Return true if the modifier type is higher in the hierarchy
        return modifierIndex > baseIndex;
    }

    private boolean isHigherHoeType(ItemStack baseHoeType, ItemStack modifierHoeType) {
        // Define PickType levels in ascending order of strength
        List<Item> hoeTypeHierarchy = new ArrayList<>(List.of(
                Items.WOODEN_HOE, Items.GOLDEN_HOE, Items.STONE_HOE, Items.IRON_HOE,
                Items.DIAMOND_HOE, Items.NETHERITE_HOE
        ));

        // Map each SWORD type to its corresponding material
        Map<Item, Ingredient> HoeToMaterialMap = Map.of(
                Items.WOODEN_HOE, Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS,
                        Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS,
                        Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS),
                Items.GOLDEN_HOE, Ingredient.of(Items.GOLD_INGOT),
                Items.STONE_HOE, Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE),
                Items.IRON_HOE, Ingredient.of(Items.IRON_INGOT),
                Items.DIAMOND_HOE, Ingredient.of(Items.DIAMOND),
                Items.NETHERITE_HOE, Ingredient.of(Items.NETHERITE_INGOT)
        );

        // Convert baseHoeType and modifierHoeType to their corresponding materials
        Item baseHoeItem = baseHoeType.getItem();
        Item modifierHoeItem = modifierHoeType.getItem();

        Item baseMaterialType = null;
        Item modifierMaterialType = null;

        // Find the materials corresponding to the SWORD items
        for (Map.Entry<Item, Ingredient> entry : HoeToMaterialMap.entrySet()) {
            if (entry.getKey().equals(baseHoeType.getItem())) {
                baseMaterialType = entry.getKey();
            }
            if (entry.getValue().test(modifierHoeType)) {
                modifierMaterialType = entry.getKey();
            }
        }

        // Ensure both types were mapped to a valid SWORD
        if (baseMaterialType == null || modifierMaterialType == null) {
            return false; // Invalid types, cannot compare
        }

        // Compare indices in the hierarchy
        int baseIndex = hoeTypeHierarchy.indexOf(baseMaterialType);
        int modifierIndex = hoeTypeHierarchy.indexOf(modifierMaterialType);

        // Return true if the modifier type is higher in the hierarchy
        return modifierIndex > baseIndex;
    }


    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= this.pattern.width() && height >= this.pattern.height();
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider provider) {
        return this.result;
    }


    public ItemStack getResult() {
        return result;
    }


    @Override
    public CraftingBookCategory category() {
        return category;
    }

//    @Override
//    public boolean isSpecial() {
//        return true;
//    }


    public static class Serializer implements RecipeSerializer<UpgradeRecipe> {
        public static final MapCodec<UpgradeRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340778_) -> p_340778_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_311729_) -> p_311729_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_311732_) -> p_311732_.category), ShapedRecipePattern.MAP_CODEC.forGetter((p_311733_) -> p_311733_.pattern), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_311730_) -> p_311730_.result), Codec.BOOL.optionalFieldOf("show_notification", true).forGetter((p_311731_) -> p_311731_.showNotification)).apply(p_340778_, UpgradeRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, UpgradeRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        public Serializer() {
        }

        private static UpgradeRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            ShapedRecipePattern UpgradeRecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            boolean flag = buffer.readBoolean();
            return new UpgradeRecipe(s, craftingbookcategory, UpgradeRecipepattern, itemstack, flag);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, UpgradeRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
            buffer.writeBoolean(recipe.showNotification);
        }

        public MapCodec<UpgradeRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, UpgradeRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }


}
package com.awesomeshot5051.plantfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.plantfarms.datacomponents.ModDataComponents;
import com.awesomeshot5051.plantfarms.items.ModItems;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CustomShapelessBlockRecipe extends ShapelessRecipe {
    final String group;
    final CraftingBookCategory category;
    final ItemStack result;
    final NonNullList<Ingredient> ingredients;
    private final boolean isSimple;
    private ItemContainerContents swordContents;
    private final ItemStack result2;

    public CustomShapelessBlockRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
        this.isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
        result2 = result.copy();
    }

    @Override
    public RecipeSerializer<CustomShapelessBlockRecipe> getSerializer() {
        return ModRecipes.SHAPELESS_SERIALIZER.get();
    }


    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public boolean matches(CraftingInput input, Level level) {
        if (input.ingredientCount() != this.ingredients.size()) {
            return false;
        } else if (!this.isSimple) {
            ArrayList<ItemStack> nonEmptyItems = new ArrayList<>(input.ingredientCount());

            for (ItemStack item : input.items()) {
                if (!item.isEmpty()) {
                    nonEmptyItems.add(item);
                }
            }

            return RecipeMatcher.findMatches(nonEmptyItems, this.ingredients) != null;
        } else {
            return input.size() == 1 && this.ingredients.size() == 1 ? this.ingredients.getFirst().test(input.getItem(0)) : input.stackedContents().canCraft(this, null);
        }
    }

    ItemStack tfarm = ModItems.TFARM_BLOCK.get().getDefaultInstance();
    ItemStack farm = ModItems.FARM_BLOCK.get().getDefaultInstance();

    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        List<ItemStack> ingredients = input.items(); // Ingredients from the crafting input
        ItemStack resultItem = new ItemStack(Items.AIR);      // Default result

        ItemContainerContents hoeContents = null;    // Placeholder for hoe contents

        List<ItemStack> logDroppers = List.of(
                new ItemStack(Items.ACACIA_SAPLING),
                new ItemStack(Items.BIRCH_SAPLING),
                new ItemStack(Items.DARK_OAK_SAPLING),
                new ItemStack(Items.JUNGLE_SAPLING),
                new ItemStack(Items.MANGROVE_PROPAGULE),
                new ItemStack(Items.OAK_SAPLING),
                new ItemStack(Items.SPRUCE_SAPLING),
                new ItemStack(Items.CRIMSON_FUNGUS),
                new ItemStack(Items.WARPED_FUNGUS),
                new ItemStack(Items.CHERRY_SAPLING) // Missing log-producing sapling
        );
        List<ItemStack> crops = List.of(
                new ItemStack(Items.BEETROOT),
                new ItemStack(Items.CARROT),
                new ItemStack(Items.MELON_SLICE),
                new ItemStack(Items.WHEAT),
                new ItemStack(Items.POTATO),
                new ItemStack(ModItems.TFARM_BLOCK),
                new ItemStack(Items.PUMPKIN)
        );
        List<ItemStack> others = List.of(
                new ItemStack(Items.AZALEA),
                new ItemStack(Items.SWEET_BERRIES),
                new ItemStack(Items.SEAGRASS),
                new ItemStack(Items.CHORUS_FLOWER),
                new ItemStack(Items.CHORUS_FRUIT),
                new ItemStack(ModItems.FARM_BLOCK),
                new ItemStack(Items.KELP),
                new ItemStack(Items.BROWN_MUSHROOM),
                new ItemStack(Items.LILY_PAD),
                new ItemStack(Items.VINE),
                new ItemStack(Items.SUNFLOWER), // Adding flowers here
                new ItemStack(Items.LILAC),
                new ItemStack(Items.ROSE_BUSH),
                new ItemStack(Items.PEONY),
                new ItemStack(Items.DANDELION),
                new ItemStack(Items.POPPY),
                new ItemStack(Items.BLUE_ORCHID),
                new ItemStack(Items.ALLIUM),
                new ItemStack(Items.AZURE_BLUET),
                new ItemStack(Items.RED_TULIP),
                new ItemStack(Items.ORANGE_TULIP),
                new ItemStack(Items.WHITE_TULIP),
                new ItemStack(Items.PINK_TULIP),
                new ItemStack(Items.OXEYE_DAISY),
                new ItemStack(Items.CORNFLOWER),
                new ItemStack(Items.LILY_OF_THE_VALLEY),
                new ItemStack(Items.COCOA_BEANS),
                new ItemStack(Items.SUGAR_CANE)
        );
        for (ItemStack ingredient : ingredients) {
            if (logDroppers.stream().anyMatch(stack -> stack.getItem() == ingredient.getItem())) {
                resultItem = axeRecipe(ingredients);
                break;
            } else if (crops.stream().anyMatch(stack -> stack.getItem() == ingredient.getItem())) {
                resultItem = hoeRecipe(ingredients);
                break;
            } else if (others.stream().anyMatch(stack -> stack.getItem() == ingredient.getItem())) {
                resultItem = otherRecipe();
                break;
            }

        }
        return resultItem;
    }

    private ItemStack hoeRecipe(List<ItemStack> ingredients) {
        tfarm = ingredients.stream()
                .filter(ingredient -> ingredient.equals(tfarm))
                .findFirst()
                .orElse(tfarm); // In case the item is not found, retain the original
        ItemContainerContents hoe = tfarm.getOrDefault(ModDataComponents.HOE_TYPE, ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_HOE))));
        result2.set(ModDataComponents.HOE_TYPE, hoe);
        return result2;
    }

    private ItemStack otherRecipe() {
        return result2;
    }

    private ItemStack axeRecipe(List<ItemStack> ingredients) {
        ItemContainerContents axe = ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_AXE)));
        for (ItemStack ingredient : ingredients) {
            if (ingredient.is(ItemTags.AXES)) {
                axe = ItemContainerContents.fromItems(Collections.singletonList(ingredient));
            }
        }
        if (axe.copyOne().has(DataComponents.ENCHANTMENTS)) {
            result2.set(DataComponents.STORED_ENCHANTMENTS, axe.copyOne().get(DataComponents.ENCHANTMENTS));
        }
        result2.set(ModDataComponents.AXE_TYPE, axe);
        return result2;
    }


    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
    }

    @Override
    public RecipeType<?> getType() {
        return super.getType();
    }

    @Override
    public CraftingBookCategory category() {
        return category;
    }

    public static class Serializer implements RecipeSerializer<CustomShapelessBlockRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, CustomShapelessBlockRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        private static final MapCodec<CustomShapelessBlockRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340779_) -> p_340779_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_301127_) -> p_301127_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_301133_) -> p_301133_.category), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_301142_) -> p_301142_.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap((p_301021_) -> {
            Ingredient[] aingredient = p_301021_.toArray(Ingredient[]::new);
            if (aingredient.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth() ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth())) : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
            }
        }, DataResult::success).forGetter((p_300975_) -> p_300975_.ingredients)).apply(p_340779_, CustomShapelessBlockRecipe::new));

        public Serializer() {
        }

        private static CustomShapelessBlockRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
            nonnulllist.replaceAll((p_319735_) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            return new CustomShapelessBlockRecipe(s, craftingbookcategory, itemstack, nonnulllist);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, CustomShapelessBlockRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            buffer.writeVarInt(recipe.ingredients.size());

            for (Ingredient ingredient : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }

        public MapCodec<CustomShapelessBlockRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, CustomShapelessBlockRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}

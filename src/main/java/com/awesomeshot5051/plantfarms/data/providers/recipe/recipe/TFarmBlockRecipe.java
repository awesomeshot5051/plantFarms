package com.awesomeshot5051.plantfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.awesomeshot5051.plantfarms.items.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.core.*;
import net.minecraft.core.component.*;
import net.minecraft.network.*;
import net.minecraft.network.codec.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.*;

import java.util.*;

public class TFarmBlockRecipe extends ShapelessRecipe {
    final String group;
    final CraftingBookCategory category;
    final ItemStack result;
    final NonNullList<Ingredient> ingredients;

    public TFarmBlockRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
        boolean isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
    }

    @Override
    public RecipeSerializer<TFarmBlockRecipe> getSerializer() {
        return ModRecipes.TFARM_SERIALIZER.get();
    }

    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        List<ItemStack> ingredients = input.items();
        ItemStack resultItem = ItemStack.EMPTY;
        ItemContainerContents hoeContents = ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_HOE)));
        ItemStack farm = ModItems.FARM_BLOCK.get().getDefaultInstance();
        boolean containsFarmBlock = false;
        for (ItemStack ingredient : ingredients) {
            if (ingredient.is(farm.getItem())) {
                containsFarmBlock = true;
                farm = ingredient;
                break;
            }
        }
        if (containsFarmBlock) {
            if (ingredients.getFirst().is(farm.getItem())) {
                hoeContents = ItemContainerContents.fromItems(Collections.singletonList(ingredients.getLast()));
            } else if (ingredients.getLast().is(farm.getItem())) {
                hoeContents = ItemContainerContents.fromItems(Collections.singletonList(ingredients.getFirst()));
            }
            assert hoeContents != null;
            ItemStack hoeStack = hoeContents.getStackInSlot(0);
            ItemEnchantments enchantments = hoeStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
            resultItem = getResultItem(registries).copy();
            resultItem.set(DataComponents.STORED_ENCHANTMENTS, enchantments);
            resultItem.set(ModDataComponents.HOE_TYPE, hoeContents);
        }
        return resultItem;
    }

    public static class Serializer implements RecipeSerializer<TFarmBlockRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, TFarmBlockRecipe> STREAM_CODEC = StreamCodec.of(TFarmBlockRecipe.Serializer::toNetwork, TFarmBlockRecipe.Serializer::fromNetwork);
        private static final MapCodec<TFarmBlockRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340779_) -> p_340779_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_301127_) -> p_301127_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_301133_) -> p_301133_.category), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_301142_) -> p_301142_.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap((p_301021_) -> {
            Ingredient[] aingredient = p_301021_.toArray(Ingredient[]::new);
            if (aingredient.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth() ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth())) : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
            }
        }, DataResult::success).forGetter((p_300975_) -> p_300975_.ingredients)).apply(p_340779_, TFarmBlockRecipe::new));

        public Serializer() {
        }

        private static TFarmBlockRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
            nonnulllist.replaceAll((p_319735_) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            return new TFarmBlockRecipe(s, craftingbookcategory, itemstack, nonnulllist);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, TFarmBlockRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            buffer.writeVarInt(recipe.ingredients.size());
            for (Ingredient ingredient : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }

        public MapCodec<TFarmBlockRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, TFarmBlockRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
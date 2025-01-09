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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class EnchantmentRemovalRecipe extends ShapelessRecipe {

    final String group;
    final CraftingBookCategory category;
    final ItemStack result;
    final NonNullList<Ingredient> ingredients;
    private final boolean isSimple;
    private ItemContainerContents swordContents;
    private ItemStack result2;

    public EnchantmentRemovalRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
        this.isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
    }

    ItemStack farm;

    @Override
    public @NotNull RecipeSerializer<EnchantmentRemovalRecipe> getSerializer() {
        return ModRecipes.ENCHANTMENT_REMOVER_SERIALIZER.get();
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput input, HolderLookup.@NotNull Provider registries) {

        List<Item> farmBlocks = new ArrayList<>();
        ItemEnchantments enchantments = ItemEnchantments.EMPTY;
        ItemEnchantments.Mutable storedEnchantments = new ItemEnchantments.Mutable(enchantments);
        for (var sidedBlock : ModItems.ITEM_REGISTER.getEntries()) {
            farmBlocks.add(sidedBlock.get());
        }
        List<ItemStack> ingredient = input.items();

        ItemContainerContents hoeContents = ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_HOE)));   // Placeholder for pick contents
        ItemContainerContents axeContents = ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_AXE)));   // Placeholder for pick contents
        // Check the first and last ingredients for the HOE_TYPE component
        farm = new ItemStack(Items.AIR);
        for (ItemStack ingrnt : ingredient) {
            if (farmBlocks.contains(ingrnt.getItem())) {
                if (ingrnt.has(ModDataComponents.HOE_TYPE)) {
                    hoeContents = ItemContainerContents.fromItems(Collections.singletonList(Objects.requireNonNull(ingrnt.getOrDefault(ModDataComponents.HOE_TYPE, hoeContents)).copyOne()));
                    farm = ingrnt.getItem().getDefaultInstance();
                    farm.remove(DataComponents.STORED_ENCHANTMENTS);
                    ItemStack sword = hoeContents.getStackInSlot(0);
                    sword.remove(DataComponents.ENCHANTMENTS);
                    hoeContents = ItemContainerContents.fromItems(Collections.singletonList(sword));
                    farm.set(ModDataComponents.HOE_TYPE, hoeContents);
                }
            } else if (ingrnt.has(ModDataComponents.AXE_TYPE)) {
                axeContents = ItemContainerContents.fromItems(Collections.singletonList(Objects.requireNonNull(ingrnt.getOrDefault(ModDataComponents.AXE_TYPE, axeContents)).copyOne()));
                farm = ingrnt.getItem().getDefaultInstance();
                farm.remove(DataComponents.STORED_ENCHANTMENTS);
                ItemStack sword = axeContents.getStackInSlot(0);
                sword.remove(DataComponents.ENCHANTMENTS);
                axeContents = ItemContainerContents.fromItems(Collections.singletonList(sword));
                farm.set(ModDataComponents.AXE_TYPE, axeContents);
            }

        }
        return farm;
    }

    public static class Serializer implements RecipeSerializer<EnchantmentRemovalRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, EnchantmentRemovalRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        private static final MapCodec<EnchantmentRemovalRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340779_) -> p_340779_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_301127_) -> p_301127_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_301133_) -> p_301133_.category), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_301142_) -> p_301142_.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap((p_301021_) -> {
            Ingredient[] aingredient = p_301021_.toArray(Ingredient[]::new);
            if (aingredient.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth() ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth())) : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
            }
        }, DataResult::success).forGetter((p_300975_) -> p_300975_.ingredients)).apply(p_340779_, EnchantmentRemovalRecipe::new));

        public Serializer() {
        }

        private static EnchantmentRemovalRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
            nonnulllist.replaceAll((p_319735_) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            return new EnchantmentRemovalRecipe(s, craftingbookcategory, itemstack, nonnulllist);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, EnchantmentRemovalRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            buffer.writeVarInt(recipe.ingredients.size());

            for (Ingredient ingredient : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }

        public MapCodec<EnchantmentRemovalRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, EnchantmentRemovalRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }


}

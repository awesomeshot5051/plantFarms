package com.awesomeshot5051.plantfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.awesomeshot5051.plantfarms.items.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.core.*;
import net.minecraft.core.component.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.codec.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.*;
import net.neoforged.neoforge.common.util.*;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.stream.*;

@SuppressWarnings("ALL")
public class CardUpgradeRecipe extends ShapelessRecipe {
    final String group;
    final CraftingBookCategory category;
    final ItemStack result;
    final NonNullList<Ingredient> ingredients;
    private final boolean isSimple;

    List<Item> shovels = List.of(Items.WOODEN_SHOVEL, Items.STONE_SHOVEL, Items.IRON_SHOVEL, Items.GOLDEN_SHOVEL, Items.DIAMOND_SHOVEL, Items.NETHERITE_SHOVEL);
    List<Item> pickaxes = List.of(Items.WOODEN_PICKAXE, Items.STONE_PICKAXE, Items.IRON_PICKAXE, Items.GOLDEN_PICKAXE, Items.DIAMOND_PICKAXE, Items.NETHERITE_PICKAXE);
    List<Item> ALL_FARMS = new ArrayList<>();
    private ItemContainerContents pickContents;
    private ItemStack result2;

    public CardUpgradeRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
        this.isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
        result2 = result.copy();
    }

    @Override
    public RecipeSerializer<CardUpgradeRecipe> getSerializer() {
        return ModRecipes.CARD_UPGRADE_SERIALIZER.get();
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

    public ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, result.getDescriptionId());
    }

    List<ItemStack> UPGRADES = List.of(ModItems.NETHER_UPGRADE.get().getDefaultInstance()
            , ModItems.SPEED_UPGRADE.get().getDefaultInstance());

    @Override
    public @NotNull ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider registries) {

        for (var sidedBlock : ModItems.ITEM_REGISTER.getEntries()) {
            ALL_FARMS.add(sidedBlock.get());
        }

        List<ItemStack> ingredients = craftingInput.items();
        ItemStack upgrade = ingredients.stream()
                .filter(item -> UPGRADES.contains(item.getItem()))
                .findFirst()
                .orElse(ItemStack.EMPTY); // Default to EMPTY if no match is found

        ItemStack farm = ingredients.stream()
                .filter(item -> ALL_FARMS.contains(item.getItem()))
                .findFirst()
                .orElse(ItemStack.EMPTY); // Default to EMPTY if no match is found
        CustomData upgradeData = CustomData.of(createSmeltingUpgrade(upgrade));
        result2.set(farm.has(ModDataComponents.HOE_TYPE) ? ModDataComponents.HOE_TYPE : ModDataComponents.AXE_TYPE, farm.get(farm.has(ModDataComponents.HOE_TYPE) ? ModDataComponents.HOE_TYPE : ModDataComponents.AXE_TYPE));
        result2.set(DataComponents.STORED_ENCHANTMENTS, farm.get(DataComponents.STORED_ENCHANTMENTS));
        result2.set(DataComponents.CUSTOM_DATA, upgradeData);
        super.assemble(craftingInput, registries);
        return result2;
    }

    public CompoundTag createSmeltingUpgrade(ItemStack upgrade) {
        CompoundTag upgrade_card = new CompoundTag();
        upgrade_card.putString("Upgrade", convertToReadableName(upgrade.toString()));
        return upgrade_card;
    }

    private String convertToReadableName(String block) {
        String readableName = block.replace("item.plant_farms.", "").replace('_', ' ')
                .replace("{}", "");
        return Arrays.stream(readableName.split(" ")).map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
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


    public static class Serializer implements RecipeSerializer<CardUpgradeRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, CardUpgradeRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        private static final MapCodec<CardUpgradeRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340779_) -> p_340779_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_301127_) -> p_301127_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_301133_) -> p_301133_.category), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_301142_) -> p_301142_.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap((p_301021_) -> {
            Ingredient[] aingredient = p_301021_.toArray(Ingredient[]::new);
            if (aingredient.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth() ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth())) : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
            }
        }, DataResult::success).forGetter((p_300975_) -> p_300975_.ingredients)).apply(p_340779_, CardUpgradeRecipe::new));

        public Serializer() {
        }

        private static CardUpgradeRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
            nonnulllist.replaceAll((p_319735_) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            return new CardUpgradeRecipe(s, craftingbookcategory, itemstack, nonnulllist);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, CardUpgradeRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            buffer.writeVarInt(recipe.ingredients.size());

            for (Ingredient ingredient : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }

        public MapCodec<CardUpgradeRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, CardUpgradeRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }


}
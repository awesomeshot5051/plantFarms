package com.awesomeshot5051.plantfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.datacomponents.ModDataComponents;
import com.awesomeshot5051.plantfarms.items.ModItems;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomShapedRecipe extends ShapedRecipe {

    public final ShapedRecipePattern pattern;
    final String group;
    final CraftingBookCategory category;
    final boolean showNotification;
    final ItemStack result;
    private ItemStack result2;

    public CustomShapedRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, boolean showNotification) {
        super(group, category, pattern, result, showNotification);
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
        this.result2 = result;
        this.showNotification = showNotification;
    }

    public CustomShapedRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result) {
        this(group, category, pattern, result, true);
    }

    @Override
    public RecipeSerializer<CustomShapedRecipe> getSerializer() {
        return ModRecipes.SHAPED_SERIALIZER.get();
    }

    public boolean matches(CraftingInput input, Level level) {
        return this.pattern.matches(input);
    }

    public ResourceLocation getId() {
        return ResourceLocation.fromNamespaceAndPath(Main.MODID, result.getDescriptionId());
    }

    @Override
    public @NotNull ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider registries) {
        if (craftingInput.getItem(4).is(ItemTags.AXES)) {
            ItemStack axeStack = craftingInput.getItem(4);
            ItemEnchantments enchantments = axeStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
//        ItemStack oreStack = craftingInput.getItem(7);
            List<ItemStack> itemStacks = new ArrayList<>();
            itemStacks.add(getResultItem(registries));
            // Set the pick type in the result item's data
            ItemContainerContents axeContents = ItemContainerContents.fromItems(Collections.singletonList(axeStack));
//            BlockRendererBase.setPickaxeType(Block.byItem(result.getItem().getDefaultInstance().getItem()), axeStack);
            result2 = getResultItem(registries).copy(); // Copy the result item to avoid modifying the original
            //            NonNullList<ItemStack> p_00115 = NonNullList.withSize(1, axeStack);
//            ContainerHelper.saveAllItems(new CompoundTag(), p_00115, registries);
//            PickTypeData.getOrCreate(result);
            result2.set(ModDataComponents.AXE_TYPE, axeContents);
            result2.set(DataComponents.STORED_ENCHANTMENTS, enchantments);
//        result.set(ModDataComponents.HOE_TYPE, axeContents);

//        Main.LOGGER.debug("The pick type is...: {}", Objects.requireNonNull(result.get(ModDataComponents.HOE_TYPE)).getStackInSlot(0));

        } else if (craftingInput.getItem(4).is(ItemTags.HOES)) {
            ItemStack hoeStack = craftingInput.getItem(4);
            ItemEnchantments enchantments = hoeStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
//        ItemStack oreStack = craftingInput.getItem(7);
            List<ItemStack> itemStacks = new ArrayList<>();
            itemStacks.add(getResultItem(registries));
            // Set the pick type in the result item's data
            ItemContainerContents hoeContents = ItemContainerContents.fromItems(Collections.singletonList(hoeStack));
//            BlockRendererBase.setPickaxeType(Block.byItem(result.getItem().getDefaultInstance().getItem()), hoeStack);
            result2 = getResultItem(registries).copy(); // Copy the result item to avoid modifying the original
            //            NonNullList<ItemStack> p_00115 = NonNullList.withSize(1, hoeStack);
//            ContainerHelper.saveAllItems(new CompoundTag(), p_00115, registries);
//            PickTypeData.getOrCreate(result);
            result2.set(ModDataComponents.HOE_TYPE, hoeContents);
            result2.set(DataComponents.STORED_ENCHANTMENTS, enchantments);
        } else if (craftingInput.getItem(4).is(ModItems.CARROT_FARM)) {
            ItemContainerContents defaultContents = ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_HOE)));   // Placeholder for pick contents
            ItemStack hoeStack = craftingInput.getItem(4).getOrDefault(ModDataComponents.HOE_TYPE, defaultContents).copyOne();
            ItemEnchantments enchantments = hoeStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
//        ItemStack oreStack = craftingInput.getItem(7);
            List<ItemStack> itemStacks = new ArrayList<>();
            itemStacks.add(getResultItem(registries));
            // Set the pick type in the result item's data

            ItemContainerContents hoeContents = ItemContainerContents.fromItems(Collections.singletonList(hoeStack));
//            BlockRendererBase.setPickaxeType(Block.byItem(result.getItem().getDefaultInstance().getItem()), hoeStack);
            result2 = getResultItem(registries).copy(); // Copy the result item to avoid modifying the original
            //            NonNullList<ItemStack> p_00115 = NonNullList.withSize(1, hoeStack);
//            ContainerHelper.saveAllItems(new CompoundTag(), p_00115, registries);
//            PickTypeData.getOrCreate(result);
            result2.set(ModDataComponents.HOE_TYPE, hoeContents);
            result2.set(DataComponents.STORED_ENCHANTMENTS, enchantments);
        } else if (craftingInput.getItem(4).is(Items.BONE_MEAL) || craftingInput.getItem(4).is(Items.WATER_BUCKET)) {
            return result;
        }
        super.assemble(craftingInput, registries);
        return result2;
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
    public @NotNull RecipeType<?> getType() {
        return super.getType();
    }

    @Override
    public CraftingBookCategory category() {
        return category;
    }

//    @Override
//    public boolean isSpecial() {
//        return true;
//    }


    public static class Serializer implements RecipeSerializer<CustomShapedRecipe> {
        public static final MapCodec<CustomShapedRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340778_) -> p_340778_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_311729_) -> p_311729_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_311732_) -> p_311732_.category), ShapedRecipePattern.MAP_CODEC.forGetter((p_311733_) -> p_311733_.pattern), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_311730_) -> p_311730_.result), Codec.BOOL.optionalFieldOf("show_notification", true).forGetter((p_311731_) -> p_311731_.showNotification)).apply(p_340778_, CustomShapedRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, CustomShapedRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        public Serializer() {
        }

        private static CustomShapedRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            ShapedRecipePattern customBlockRecipepattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            boolean flag = buffer.readBoolean();
            return new CustomShapedRecipe(s, craftingbookcategory, customBlockRecipepattern, itemstack, flag);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, CustomShapedRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
            buffer.writeBoolean(recipe.showNotification);
        }

        public MapCodec<CustomShapedRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, CustomShapedRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }


}
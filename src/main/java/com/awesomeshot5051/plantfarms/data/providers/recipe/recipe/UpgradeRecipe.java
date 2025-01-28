package com.awesomeshot5051.plantfarms.data.providers.recipe.recipe;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.awesomeshot5051.plantfarms.enums.*;
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
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.*;
import org.jetbrains.annotations.*;

import java.util.*;
import java.util.stream.*;

import static com.awesomeshot5051.plantfarms.blocks.ModBlocks.*;

public class UpgradeRecipe extends ShapedRecipe {
    public final ShapedRecipePattern pattern;
    final String group;
    final CraftingBookCategory category;
    final boolean showNotification;
    final ItemStack result;
    List<Item> shovelFarms = new ArrayList<>(List.of());
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
        return BuiltInRegistries.ITEM.getTag(ItemTags.PLANKS).stream().flatMap(holderSet -> holderSet.stream().map(Holder::value)).collect(Collectors.toList());
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
        return modifier.size() == 4 && modifier.get(0).toString().equals(modifier.get(1).toString()) && modifier.get(0).toString().equals(modifier.get(2).toString()) && modifier.get(0).toString().equals(modifier.get(3).toString());
    }

    public static final List<DeferredHolder<Block, ?>> ALL_FARMS = List.of(CHORUS_FARM, OAK_FARM, SPRUCE_FARM, BIRCH_FARM, JUNGLE_FARM, DARK_OAK_FARM, ACACIA_FARM, AZALEA_FARM, MANGROVE_FARM, CHERRY_FARM, CRIMSON_FARM, WARPED_FARM, WHEAT_FARM, CARROT_FARM, GCARROT_FARM, POTATO_FARM, BEETROOT_FARM, PUMPKIN_FARM, MELON_FARM, SUGAR_FARM, COCO_FARM, BERRY_FARM, BAMBOO_FARM, DANDELION_FARM, POPPY_FARM, ORCHID_FARM, ALLIUM_FARM, AZURE_FARM, RED_FARM, ORANGE_FARM, WHITE_FARM, PINK_FARM, DAISY_FARM, CORNFLOWER_FARM, LILY_FARM, SUNFLOWER_FARM, LILAC_FARM, ROSE_FARM, PEONY_FARM, VINE_FARM, MUSHROOM_FARM, CGRASS_FARM, PAD_FARM, LEAF_FARM, KELP_FARM, WART_FARM, FARM_BLOCK, TFARM_BLOCK);
    public static List<DeferredHolder<Block, ?>> CROP_FARMS = List.of(WHEAT_FARM, CARROT_FARM, GCARROT_FARM, POTATO_FARM, BEETROOT_FARM, PUMPKIN_FARM);
    public static List<DeferredHolder<Block, ?>> LOG_FARMS = List.of(OAK_FARM, SPRUCE_FARM, BIRCH_FARM, JUNGLE_FARM, DARK_OAK_FARM, ACACIA_FARM, AZALEA_FARM, MANGROVE_FARM, CHERRY_FARM, CRIMSON_FARM, WARPED_FARM, BAMBOO_FARM);

    @Override
    public @NotNull ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider registries) {
        Map<Ingredient, Item> materialToAxeMap = Map.of(Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS), Items.WOODEN_AXE, Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE), Items.STONE_AXE, Ingredient.of(Items.IRON_INGOT), Items.IRON_AXE, Ingredient.of(Items.GOLD_INGOT), Items.GOLDEN_AXE, Ingredient.of(Items.DIAMOND), Items.DIAMOND_AXE, Ingredient.of(Items.NETHERITE_INGOT), Items.NETHERITE_AXE);
        Map<Ingredient, Item> materialToHoeMap = Map.of(Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS), Items.WOODEN_HOE, Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE), Items.STONE_HOE, Ingredient.of(Items.IRON_INGOT), Items.IRON_HOE, Ingredient.of(Items.GOLD_INGOT), Items.GOLDEN_HOE, Ingredient.of(Items.DIAMOND), Items.DIAMOND_HOE, Ingredient.of(Items.NETHERITE_INGOT), Items.NETHERITE_HOE);
        boolean isInList = ALL_FARMS.stream().anyMatch(holder -> holder.get().asItem() == craftingInput.getItem(4).getItem());
        ItemStack farm = ItemStack.EMPTY;
        for (ItemStack ingredient : craftingInput.items()) {
            if (ALL_FARMS.stream().anyMatch(holder -> holder.get().asItem() == ingredient.getItem())) {
                farm = ingredient.getItem().getDefaultInstance();
            }
        }
        ItemStack finalFarm = farm;
        if (LOG_FARMS.stream().anyMatch(blockDeferredHolder -> blockDeferredHolder.get().asItem() == finalFarm.getItem())) {
            ItemEnchantments itemenchantments = ItemEnchantments.EMPTY;
            List<ItemStack> modifer = new ArrayList<>(List.of(craftingInput.getItem(1), craftingInput.getItem(3), craftingInput.getItem(5), craftingInput.getItem(7)));
            if (areAllModifiersEqual(modifer)) {
                List<ItemStack> itemStacks = new ArrayList<>();
                ItemStack axeStack;
                axeStack = farm.getOrDefault(ModDataComponents.AXE_TYPE, ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_AXE)))).copyOne();
                if (isHigherAxeType(axeStack, modifer.getFirst())) {
                    itemStacks.add(getResultItem(registries));
                    for (Map.Entry<Ingredient, Item> entry : materialToAxeMap.entrySet()) {
                        if (entry.getKey().test(modifer.getFirst())) {
                            itemenchantments = axeStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
                            axeStack = new ItemStack(entry.getValue());
                            axeStack.set(DataComponents.ENCHANTMENTS, itemenchantments);
                            break;
                        }
                    }
                    ItemContainerContents axeContents = ItemContainerContents.fromItems(Collections.singletonList(axeStack));
                    result2 = getResultItem(registries).copy();
                    result2.set(ModDataComponents.AXE_TYPE, axeContents);
                    result2.set(DataComponents.STORED_ENCHANTMENTS, itemenchantments);
                } else {
                    return new ItemStack(Items.AIR);
                }
            }
        } else if (CROP_FARMS.stream().anyMatch(blockDeferredHolder -> blockDeferredHolder.get().asItem() == finalFarm.getItem())) {
            ItemEnchantments itemenchantments = ItemEnchantments.EMPTY;
            List<ItemStack> modifer = new ArrayList<>(List.of(craftingInput.getItem(1), craftingInput.getItem(3), craftingInput.getItem(5), craftingInput.getItem(7)));
            if (areAllModifiersEqual(modifer)) {
                List<ItemStack> itemStacks = new ArrayList<>();
                ItemStack hoeStack;
                if (craftingInput.getItem(4).get(ModDataComponents.HOE_TYPE) != null) {
                    hoeStack = Objects.requireNonNull(craftingInput.getItem(4).get(ModDataComponents.HOE_TYPE)).copyOne();
                } else {
                    hoeStack = new ItemStack(Items.WOODEN_HOE);
                }
                if (isHigherHoeType(hoeStack, modifer.getFirst())) {
                    itemStacks.add(getResultItem(registries));
                    for (Map.Entry<Ingredient, Item> entry : materialToHoeMap.entrySet()) {
                        if (entry.getKey().test(modifer.getFirst())) {
                            itemenchantments = hoeStack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
                            hoeStack = new ItemStack(entry.getValue());
                            hoeStack.set(DataComponents.ENCHANTMENTS, itemenchantments);
                            break;
                        }
                    }
                    ItemContainerContents hoeContents = ItemContainerContents.fromItems(Collections.singletonList(hoeStack));
                    result2 = getResultItem(registries).copy();
                    result2.set(ModDataComponents.HOE_TYPE, hoeContents);
                    result2.set(DataComponents.STORED_ENCHANTMENTS, itemenchantments);
                } else {
                    return new ItemStack(Items.AIR);
                }
            }
        }
        super.assemble(craftingInput, registries);
        return result2;
    }

    private boolean isHigherAxeType(ItemStack baseAxeType, ItemStack modifierAxeType) {
        Map<Item, Ingredient> AxeToMaterialMap = Map.of(Items.WOODEN_AXE, Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS), Items.GOLDEN_AXE, Ingredient.of(Items.GOLD_INGOT), Items.STONE_AXE, Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE), Items.IRON_AXE, Ingredient.of(Items.IRON_INGOT), Items.DIAMOND_AXE, Ingredient.of(Items.DIAMOND), Items.NETHERITE_AXE, Ingredient.of(Items.NETHERITE_INGOT));
        Item modifierMaterialType = null;
        for (Map.Entry<Item, Ingredient> entry : AxeToMaterialMap.entrySet()) {
            if (entry.getValue().test(modifierAxeType)) {
                modifierMaterialType = entry.getKey();
            }
        }
        if (modifierAxeType.is(Items.NETHERITE_AXE)) {
            if (isNextAxeInRank(baseAxeType, modifierAxeType)) {
                return AxeType.getRank(modifierMaterialType) > AxeType.getRank(baseAxeType.getItem());
            }
        } else {
            return AxeType.getRank(modifierMaterialType) > AxeType.getRank(baseAxeType.getItem());
        }
        return false;
    }

    private boolean isHigherHoeType(ItemStack baseHoeType, ItemStack modifierHoeType) {
        Map<Item, Ingredient> HoeToMaterialMap = Map.of(Items.WOODEN_HOE, Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS), Items.GOLDEN_HOE, Ingredient.of(Items.GOLD_INGOT), Items.STONE_HOE, Ingredient.of(Items.COBBLESTONE, Items.COBBLED_DEEPSLATE), Items.IRON_HOE, Ingredient.of(Items.IRON_INGOT), Items.DIAMOND_HOE, Ingredient.of(Items.DIAMOND), Items.NETHERITE_HOE, Ingredient.of(Items.NETHERITE_INGOT));
        Item modifierMaterialType = null;
        for (Map.Entry<Item, Ingredient> entry : HoeToMaterialMap.entrySet()) {
            if (entry.getValue().test(modifierHoeType)) {
                modifierMaterialType = entry.getKey();
            }
        }
        if (modifierHoeType.is(Items.NETHERITE_HOE)) {
            if (isNextHoeInRank(baseHoeType, modifierHoeType)) {
                return HoeType.getRank(modifierMaterialType) > HoeType.getRank(baseHoeType.getItem());
            }
        } else {
            return HoeType.getRank(modifierMaterialType) > HoeType.getRank(baseHoeType.getItem());
        }
        return false;

    }

    List<Item> axes = List.of(Items.WOODEN_AXE, Items.STONE_AXE, Items.IRON_AXE, Items.GOLDEN_AXE, Items.DIAMOND_AXE, Items.NETHERITE_AXE);
    List<Item> hoes = List.of(Items.WOODEN_HOE, Items.STONE_HOE, Items.IRON_HOE, Items.GOLDEN_HOE, Items.DIAMOND_HOE, Items.NETHERITE_HOE);

    private boolean isNextHoeInRank(ItemStack baseHoeType, ItemStack modifierHoeType) {
        Item baseItem = baseHoeType.getItem();
        Item modifierItem = modifierHoeType.getItem();
        int baseIndex = hoes.indexOf(baseItem);
        if (baseIndex != -1 && baseIndex < hoes.size() - 1) {
            return hoes.get(baseIndex + 1).equals(modifierItem);
        }
        return false;
    }

    private boolean isNextAxeInRank(ItemStack baseAxeType, ItemStack modifierAxeType) {
        Item baseItem = baseAxeType.getItem();
        Item modifierItem = modifierAxeType.getItem();
        int baseIndex = axes.indexOf(baseItem);
        if (baseIndex != -1 && baseIndex < axes.size() - 1) {
            return axes.get(baseIndex + 1).equals(modifierItem);
        }
        return false;
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
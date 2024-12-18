package com.awesomeshot5051.plantfarms.items;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.datacomponents.VillagerBlockEntityData;
import com.awesomeshot5051.plantfarms.datacomponents.VillagerData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    private static final DeferredRegister.Items ITEM_REGISTER = DeferredRegister.createItems(Main.MODID);
    public static final DeferredHolder<Item, Item> INVENTORY_VIEWER = ITEM_REGISTER.register("inventory_viewer", () -> ModBlocks.INVENTORY_VIEWER.get().toItem());

    // The End
    public static final DeferredHolder<Item, Item> CHORUS_FARM = ITEM_REGISTER.register("chorus_farm", () -> ModBlocks.CHORUS_FARM.get().toItem());

    // Overworld
// Overworld trees
    public static final DeferredHolder<Item, Item> OAK_FARM = ITEM_REGISTER.register("oak_farm", () -> ModBlocks.OAK_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SPRUCE_FARM = ITEM_REGISTER.register("spruce_farm", () -> ModBlocks.SPRUCE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> BIRCH_FARM = ITEM_REGISTER.register("birch_farm", () -> ModBlocks.BIRCH_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> JUNGLE_FARM = ITEM_REGISTER.register("jungle_farm", () -> ModBlocks.JUNGLE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> DARK_OAK_FARM = ITEM_REGISTER.register("dark_oak_farm", () -> ModBlocks.DARK_OAK_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ACACIA_FARM = ITEM_REGISTER.register("acacia_farm", () -> ModBlocks.ACACIA_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> AZALEA_FARM = ITEM_REGISTER.register("azalea_farm", () -> ModBlocks.AZALEA_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> MANGROVE_FARM = ITEM_REGISTER.register("mangrove_farm", () -> ModBlocks.MANGROVE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> CHERRY_FARM = ITEM_REGISTER.register("cherry_farm", () -> ModBlocks.CHERRY_FARM.get().toItem());

    // Overworld Crops
    public static final DeferredHolder<Item, Item> WHEAT_FARM = ITEM_REGISTER.register("wheat_farm", () -> ModBlocks.WHEAT_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> CARROT_FARM = ITEM_REGISTER.register("carrot_farm", () -> ModBlocks.CARROT_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> GCARROT_FARM = ITEM_REGISTER.register("gcarrot_farm", () -> ModBlocks.GCARROT_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> POTATO_FARM = ITEM_REGISTER.register("potato_farm", () -> ModBlocks.POTATO_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> BEETROOT_FARM = ITEM_REGISTER.register("beetroot_farm", () -> ModBlocks.BEETROOT_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PUMPKIN_FARM = ITEM_REGISTER.register("pumpkin_farm", () -> ModBlocks.PUMPKIN_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> MELON_FARM = ITEM_REGISTER.register("melon_farm", () -> ModBlocks.MELON_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SUGAR_FARM = ITEM_REGISTER.register("sugar_farm", () -> ModBlocks.SUGAR_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> COCO_FARM = ITEM_REGISTER.register("coco_farm", () -> ModBlocks.COCO_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> BERRY_FARM = ITEM_REGISTER.register("berry_farm", () -> ModBlocks.BERRY_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> BAMBOO_FARM = ITEM_REGISTER.register("bamboo_farm", () -> ModBlocks.BAMBOO_FARM.get().toItem());

    // Overworld Flowers
    public static final DeferredHolder<Item, Item> DANDELION_FARM = ITEM_REGISTER.register("dandelion_farm", () -> ModBlocks.DANDELION_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> POPPY_FARM = ITEM_REGISTER.register("poppy_farm", () -> ModBlocks.POPPY_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ORCHID_FARM = ITEM_REGISTER.register("orchid_farm", () -> ModBlocks.ORCHID_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ALLIUM_FARM = ITEM_REGISTER.register("allium_farm", () -> ModBlocks.ALLIUM_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> AZURE_FARM = ITEM_REGISTER.register("azure_farm", () -> ModBlocks.AZURE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> RED_FARM = ITEM_REGISTER.register("red_farm", () -> ModBlocks.RED_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ORANGE_FARM = ITEM_REGISTER.register("orange_farm", () -> ModBlocks.ORANGE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> WHITE_FARM = ITEM_REGISTER.register("white_farm", () -> ModBlocks.WHITE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PINK_FARM = ITEM_REGISTER.register("pink_farm", () -> ModBlocks.PINK_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> DAISY_FARM = ITEM_REGISTER.register("daisy_farm", () -> ModBlocks.DAISY_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> CORNFLOWER_FARM = ITEM_REGISTER.register("cornflower_farm", () -> ModBlocks.CORNFLOWER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> LILY_FARM = ITEM_REGISTER.register("lily_farm", () -> ModBlocks.LILY_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> SUNFLOWER_FARM = ITEM_REGISTER.register("sunflower_farm", () -> ModBlocks.SUNFLOWER_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> LILAC_FARM = ITEM_REGISTER.register("lilac_farm", () -> ModBlocks.LILAC_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> ROSE_FARM = ITEM_REGISTER.register("rose_farm", () -> ModBlocks.ROSE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> PEONY_FARM = ITEM_REGISTER.register("peony_farm", () -> ModBlocks.PEONY_FARM.get().toItem());

    // The Nether
    public static final DeferredHolder<Item, Item> CRIMSON_FARM = ITEM_REGISTER.register("crimson_farm", () -> ModBlocks.CRIMSON_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> WARPED_FARM = ITEM_REGISTER.register("warped_farm", () -> ModBlocks.WARPED_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> WART_FARM = ITEM_REGISTER.register("wart_farm", () -> ModBlocks.WART_FARM.get().toItem());

    public static final DeferredHolder<Item, Item> FARM_BLOCK = ITEM_REGISTER.register("farm_block", () -> ModBlocks.FARM_BLOCK.get().toItem());
    public static final DeferredHolder<Item, Item> TFARM_BLOCK = ITEM_REGISTER.register("tfarm_block", () -> ModBlocks.TFARM_BLOCK.get().toItem());

    public static final DeferredHolder<Item, Item> VINE_FARM = ITEM_REGISTER.register("vine_farm", () -> ModBlocks.VINE_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> MUSHROOM_FARM = ITEM_REGISTER.register("mushroom_farm", () -> ModBlocks.MUSHROOM_FARM.get().toItem());

    public static final DeferredHolder<Item, Item> PAD_FARM = ITEM_REGISTER.register("pad_farm", () -> ModBlocks.PAD_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> LEAF_FARM = ITEM_REGISTER.register("leaf_farm", () -> ModBlocks.LEAF_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> CGRASS_FARM = ITEM_REGISTER.register("cgrass_farm", () -> ModBlocks.CGRASS_FARM.get().toItem());
    public static final DeferredHolder<Item, Item> KELP_FARM = ITEM_REGISTER.register("kelp_farm", () -> ModBlocks.KELP_FARM.get().toItem());

    public static final DeferredHolder<Item, Item> ICON_ITEM = ITEM_REGISTER.register("icon_item",
            () -> new IconItem(new Item.Properties()));
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerData>> VILLAGER_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("villager", () -> DataComponentType.<VillagerData>builder().persistent(VillagerData.CODEC).networkSynchronized(VillagerData.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerBlockEntityData>> BLOCK_ENTITY_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("block_entity", () -> DataComponentType.<VillagerBlockEntityData>builder().networkSynchronized(VillagerBlockEntityData.STREAM_CODEC).build());

    public static void init(IEventBus eventBus) {
        ITEM_REGISTER.register(eventBus);
        DATA_COMPONENT_TYPE_REGISTER.register(eventBus);
    }

}

package com.awesomeshot5051.plantfarms.items;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.datacomponents.VillagerBlockEntityData;
import com.awesomeshot5051.plantfarms.datacomponents.VillagerData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    private static final DeferredRegister.Items ITEM_REGISTER = DeferredRegister.createItems(Main.MODID);
    public static final DeferredHolder<Item, BlockItem> INVENTORY_VIEWER = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.INVENTORY_VIEWER);


    /// The End
    public static final DeferredHolder<Item, BlockItem> CHORUS_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CHORUS_FARM);


    /// Overworld
    //Overworld trees
    public static final DeferredHolder<Item, BlockItem> OAK_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.OAK_FARM);
    public static final DeferredHolder<Item, BlockItem> SPRUCE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SPRUCE_FARM);
    public static final DeferredHolder<Item, BlockItem> BIRCH_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.BIRCH_FARM);
    public static final DeferredHolder<Item, BlockItem> JUNGLE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.JUNGLE_FARM);
    public static final DeferredHolder<Item, BlockItem> DARK_OAK_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.DARK_OAK_FARM);
    public static final DeferredHolder<Item, BlockItem> ACACIA_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ACACIA_FARM);
    public static final DeferredHolder<Item, BlockItem> AZALEA_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.AZALEA_FARM);
    public static final DeferredHolder<Item, BlockItem> MANGROVE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.MANGROVE_FARM);
    public static final DeferredHolder<Item, BlockItem> CHERRY_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CHERRY_FARM);

    //Overworld Crops

    public static final DeferredHolder<Item, BlockItem> WHEAT_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.WHEAT_FARM);
    public static final DeferredHolder<Item, BlockItem> CARROT_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CARROT_FARM);
    public static final DeferredHolder<Item, BlockItem> GCARROT_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.GCARROT_FARM);
    public static final DeferredHolder<Item, BlockItem> POTATO_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.POTATO_FARM);
    public static final DeferredHolder<Item, BlockItem> BEETROOT_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.BEETROOT_FARM);
    public static final DeferredHolder<Item, BlockItem> PUMPKIN_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PUMPKIN_FARM);
    public static final DeferredHolder<Item, BlockItem> MELON_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.MELON_FARM);
    public static final DeferredHolder<Item, BlockItem> SUGAR_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SUGAR_FARM);
    public static final DeferredHolder<Item, BlockItem> COCO_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.COCO_FARM);
    public static final DeferredHolder<Item, BlockItem> BERRY_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.BERRY_FARM);
    public static final DeferredHolder<Item, BlockItem> BAMBOO_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.BAMBOO_FARM);

    //Overworld Flowers

    public static final DeferredHolder<Item, BlockItem> DANDELION_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.DANDELION_FARM);
    public static final DeferredHolder<Item, BlockItem> POPPY_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.POPPY_FARM);
    public static final DeferredHolder<Item, BlockItem> ORCHID_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ORCHID_FARM);
    public static final DeferredHolder<Item, BlockItem> ALLIUM_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ALLIUM_FARM);
    public static final DeferredHolder<Item, BlockItem> AZURE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.AZURE_FARM);
    public static final DeferredHolder<Item, BlockItem> RED_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.RED_FARM);
    public static final DeferredHolder<Item, BlockItem> ORANGE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ORANGE_FARM);
    public static final DeferredHolder<Item, BlockItem> WHITE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.WHITE_FARM);
    public static final DeferredHolder<Item, BlockItem> PINK_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PINK_FARM);
    public static final DeferredHolder<Item, BlockItem> DAISY_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.DAISY_FARM);
    public static final DeferredHolder<Item, BlockItem> CORNFLOWER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CORNFLOWER_FARM);
    public static final DeferredHolder<Item, BlockItem> LILY_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.LILY_FARM);
    public static final DeferredHolder<Item, BlockItem> SUNFLOWER_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.SUNFLOWER_FARM);
    public static final DeferredHolder<Item, BlockItem> LILAC_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.LILAC_FARM);
    public static final DeferredHolder<Item, BlockItem> ROSE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.ROSE_FARM);
    public static final DeferredHolder<Item, BlockItem> PEONY_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PEONY_FARM);
    /// The Nether
    public static final DeferredHolder<Item, BlockItem> CRIMSON_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CRIMSON_FARM);
    public static final DeferredHolder<Item, BlockItem> WARPED_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.WARPED_FARM);
    public static final DeferredHolder<Item, BlockItem> WART_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.WART_FARM);

    public static final DeferredHolder<Item, BlockItem> FARM_BLOCK = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.FARM_BLOCK);
    public static final DeferredHolder<Item, BlockItem> TFARM_BLOCK = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.TFARM_BLOCK);

    public static final DeferredHolder<Item, BlockItem> VINE_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.VINE_FARM);
    public static final DeferredHolder<Item, BlockItem> MUSHROOM_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.MUSHROOM_FARM);


    public static final DeferredHolder<Item, BlockItem> PAD_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.PAD_FARM);
    public static final DeferredHolder<Item, BlockItem> LEAF_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.LEAF_FARM);
    public static final DeferredHolder<Item, BlockItem> CGRASS_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.CGRASS_FARM);
    public static final DeferredHolder<Item, BlockItem> KELP_FARM = ITEM_REGISTER.registerSimpleBlockItem(ModBlocks.KELP_FARM);
    

    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerData>> VILLAGER_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("villager", () -> DataComponentType.<VillagerData>builder().persistent(VillagerData.CODEC).networkSynchronized(VillagerData.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerBlockEntityData>> BLOCK_ENTITY_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("block_entity", () -> DataComponentType.<VillagerBlockEntityData>builder().networkSynchronized(VillagerBlockEntityData.STREAM_CODEC).build());

    public static void init(IEventBus eventBus) {
        ITEM_REGISTER.register(eventBus);
        DATA_COMPONENT_TYPE_REGISTER.register(eventBus);
    }

}

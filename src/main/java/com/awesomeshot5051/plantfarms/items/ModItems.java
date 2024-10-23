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
import com.awesomeshot5051.plantfarms.fluids.items.WaterItem;

/**
 * <h1>Overworld Plants</h1>
 *
 * <ul>
 *   <li><a href="#trees">Trees</a></li>
 *   <!-- Add more sections here as needed -->
 * </ul>
 *
 * <p>Click on the links above to navigate to each section.</p>
 */
public class ModItems {

    private static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(BuiltInRegistries.ITEM, Main.MODID);

    public static final DeferredHolder<Item, Item> INVENTORY_VIEWER = ITEM_REGISTER.register("inventory_viewer", () -> ModBlocks.INVENTORY_VIEWER.get().toItem());

    /**
     * <h2 id="trees">Trees</h2>
     *
     * <ul>
     *   <li><a href="#oak_farm">Oak</a></li>
     *   <li>Birch</li>
     *   <li>Spruce</li>
     *   <li>Jungle</li>
     *   <li>Acacia</li>
     *   <li>Dark Oak</li>
     * </ul>
     *
     * <p>These are the common types of trees found in the overworld.</p>
     */

    /**
     * <a id="oak_farm"></a>
     * Oak Farm item.
     */
    public static final DeferredHolder<Item, Item> OAK_FARM = ITEM_REGISTER.register("oak_farm", () -> ModBlocks.OAK_FARM.get().toItem());

    // Other items...
    public static final DeferredHolder<Item, Item> ICON_ITEM = ITEM_REGISTER.register("icon_item",
            () -> new IconItem(new Item.Properties()));
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE_REGISTER = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Main.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerData>> VILLAGER_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("villager", () -> DataComponentType.<VillagerData>builder().persistent(VillagerData.CODEC).networkSynchronized(VillagerData.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<VillagerBlockEntityData>> BLOCK_ENTITY_DATA_COMPONENT = DATA_COMPONENT_TYPE_REGISTER.register("block_entity", () -> DataComponentType.<VillagerBlockEntityData>builder().networkSynchronized(VillagerBlockEntityData.STREAM_CODEC).build());
    public static final DeferredHolder<Item,Item> WATER_BUCKET = ITEM_REGISTER.register("water_bucket", WaterItem::new);

    public static void init(IEventBus eventBus) {
        ITEM_REGISTER.register(eventBus);
        DATA_COMPONENT_TYPE_REGISTER.register(eventBus);
    }
}

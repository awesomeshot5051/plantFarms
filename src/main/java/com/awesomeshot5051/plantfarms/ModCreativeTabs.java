package com.awesomeshot5051.plantfarms;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB_plant_farms = TAB_REGISTER.register("plant_farms", () -> {
        return CreativeModeTab.builder()
                .icon(() -> new ItemStack(ModItems.OAK_FARM.get())) // Use your custom item here
                .displayItems((features, output) -> {

                    //end plants
                    output.accept(new ItemStack(ModBlocks.CHORUS_FARM.get()));

                    //overworld plants
                    output.accept(new ItemStack(ModBlocks.OAK_FARM.get()));

                    output.accept(new ItemStack(ModItems.WATER_BUCKET.get()));
                    output.accept(new ItemStack(ModBlocks.INVENTORY_VIEWER.get()));

                })
                .title(Component.translatable("itemGroup.plant_farms"))
                .build();
    });

    public static void init(IEventBus eventBus) {
        TAB_REGISTER.register(eventBus);
    }

}

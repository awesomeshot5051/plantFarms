package com.awesomeshot5051.plantfarms.enums;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public enum AxeType implements StringRepresentable {
    WOODEN,
    STONE,
    IRON,
    GOLDEN,
    DIAMOND,
    NETHERITE;
    final List<Item> swordTypes = List.of(Items.NETHERITE_AXE, Items.DIAMOND_AXE, Items.GOLDEN_AXE, Items.IRON_AXE, Items.STONE_AXE, Items.WOODEN_AXE);

    public static AxeType fromItem(Item item) {
        if (item == Items.WOODEN_AXE) return WOODEN;
        if (item == Items.STONE_AXE) return STONE;
        if (item == Items.IRON_AXE) return IRON;
        if (item == Items.GOLDEN_AXE) return GOLDEN;
        if (item == Items.DIAMOND_AXE) return DIAMOND;
        if (item == Items.NETHERITE_AXE) return NETHERITE;
        return WOODEN;  // Default
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase();  // Returns the enum name in lowercase (e.g., "wooden", "stone", etc.)
    }
}
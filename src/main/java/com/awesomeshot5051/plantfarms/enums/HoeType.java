package com.awesomeshot5051.plantfarms.enums;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public enum HoeType implements StringRepresentable {
    WOODEN,
    STONE,
    IRON,
    GOLDEN,
    DIAMOND,
    NETHERITE;
    final List<Item> swordTypes = List.of(Items.NETHERITE_HOE, Items.DIAMOND_HOE, Items.GOLDEN_HOE, Items.IRON_HOE, Items.STONE_HOE, Items.WOODEN_HOE);

    public static HoeType fromItem(Item item) {
        if (item == Items.WOODEN_HOE) return WOODEN;
        if (item == Items.STONE_HOE) return STONE;
        if (item == Items.IRON_HOE) return IRON;
        if (item == Items.GOLDEN_HOE) return GOLDEN;
        if (item == Items.DIAMOND_HOE) return DIAMOND;
        if (item == Items.NETHERITE_HOE) return NETHERITE;
        return WOODEN;  // Default
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase();  // Returns the enum name in lowercase (e.g., "wooden", "stone", etc.)
    }
}
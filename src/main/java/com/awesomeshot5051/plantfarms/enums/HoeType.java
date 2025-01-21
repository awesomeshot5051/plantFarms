package com.awesomeshot5051.plantfarms.enums;

import net.minecraft.util.*;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.*;

import java.util.*;

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

    public static int getRank(Item item) {
        if (fromItem(item).equals(WOODEN)) return 0;
        if (fromItem(item).equals(STONE)) return 1;
        if (fromItem(item).equals(IRON)) return 2;
        if (fromItem(item).equals(GOLDEN)) return 3;
        if (fromItem(item).equals(DIAMOND)) return 4;
        if (fromItem(item).equals(NETHERITE)) return 5;
        return 0;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase();  // Returns the enum name in lowercase (e.g., "wooden", "stone", etc.)
    }
}
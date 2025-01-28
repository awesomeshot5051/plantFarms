package com.awesomeshot5051.plantfarms.enums;

import net.minecraft.util.*;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.*;

import java.util.*;

public enum AxeType implements StringRepresentable {
    WOODEN, STONE, IRON, GOLDEN, DIAMOND, NETHERITE;
    final List<Item> swordTypes = List.of(Items.NETHERITE_AXE, Items.DIAMOND_AXE, Items.GOLDEN_AXE, Items.IRON_AXE, Items.STONE_AXE, Items.WOODEN_AXE);

    public static AxeType fromItem(Item item) {
        if (item == Items.WOODEN_AXE) return WOODEN;
        if (item == Items.STONE_AXE) return STONE;
        if (item == Items.IRON_AXE) return IRON;
        if (item == Items.GOLDEN_AXE) return GOLDEN;
        if (item == Items.DIAMOND_AXE) return DIAMOND;
        if (item == Items.NETHERITE_AXE) return NETHERITE;
        return WOODEN;
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
        return this.name().toLowerCase();
    }
}
package com.awesomeshot5051.plantfarms.datacomponents;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.HashMap;
import java.util.Map;

public class HoeEnchantments {
    // Initialize the enchantments map with default values


    // Method to initialize the enchantments map
    public static Map<ResourceKey<Enchantment>, Boolean> initializeHoeEnchantments() {
        Map<ResourceKey<Enchantment>, Boolean> enchantmentsMap = new HashMap<>();
        enchantmentsMap.put(Enchantments.MENDING, false);      // Repairs using experience orbs
        enchantmentsMap.put(Enchantments.EFFICIENCY, false);  // Increases mining speed
        enchantmentsMap.put(Enchantments.UNBREAKING, false);  // Increases durability
        enchantmentsMap.put(Enchantments.FORTUNE, false);     // Increases drops
        enchantmentsMap.put(Enchantments.SILK_TOUCH, false);  // Mines blocks intact
        return enchantmentsMap;
    }

    // Helper method to set the value for a single enchantment
    private static void setHoeEnchantment(Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments, ResourceKey<Enchantment> enchantment, boolean value) {
        if (hoeEnchantments.containsKey(enchantment)) {
            hoeEnchantments.put(enchantment, value);
        } else {
            throw new IllegalArgumentException("Invalid enchantment: " + enchantment);
        }
    }

    public static boolean getHoeEnchantmentStatus(Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments, ResourceKey<Enchantment> enchantment) {
        if (hoeEnchantments.containsKey(enchantment)) {
            return hoeEnchantments.get(enchantment);
        } else {
            throw new IllegalArgumentException("Invalid enchantment: " + enchantment);
        }
    }

    // Method to toggle a single enchantment
    public static void toggleHoeEnchantment(Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments, ResourceKey<Enchantment> enchantment, boolean value) {
        setHoeEnchantment(hoeEnchantments, enchantment, value);
    }

    // Method to toggle multiple enchantments
    public static void toggleHoeEnchantments(Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments, Map<ResourceKey<Enchantment>, Boolean> enchantmentsToToggle) {
        for (Map.Entry<ResourceKey<Enchantment>, Boolean> entry : enchantmentsToToggle.entrySet()) {
            setHoeEnchantment(hoeEnchantments, entry.getKey(), entry.getValue());
        }
    }
}

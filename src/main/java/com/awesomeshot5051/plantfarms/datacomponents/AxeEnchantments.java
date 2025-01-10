package com.awesomeshot5051.plantfarms.datacomponents;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.HashMap;
import java.util.Map;

public class AxeEnchantments {
    // Initialize the enchantments map with default values


    // Method to initialize the enchantments map
    public static Map<ResourceKey<Enchantment>, Boolean> initializeAxeEnchantments() {
        Map<ResourceKey<Enchantment>, Boolean> enchantmentsMap = new HashMap<>();
        enchantmentsMap.put(Enchantments.MENDING, false);         // Repairs using experience orbs
        enchantmentsMap.put(Enchantments.EFFICIENCY, false);      // Increases mining speed
        enchantmentsMap.put(Enchantments.UNBREAKING, false);      // Increases durability
        enchantmentsMap.put(Enchantments.SILK_TOUCH, false);      // Mines blocks intact
        return enchantmentsMap;
    }


    // Helper method to set the value for a single enchantment
    private static void setAxeEnchantment(Map<ResourceKey<Enchantment>, Boolean> axeEnchantments, ResourceKey<Enchantment> enchantment, boolean value) {
        if (axeEnchantments.containsKey(enchantment)) {
            axeEnchantments.put(enchantment, value);
        } else {
            throw new IllegalArgumentException("Invalid enchantment: " + enchantment);
        }
    }

    public static boolean getAxeEnchantmentStatus(Map<ResourceKey<Enchantment>, Boolean> axeEnchantments, ResourceKey<Enchantment> enchantment) {
        if (axeEnchantments.containsKey(enchantment)) {
            return axeEnchantments.get(enchantment);
        } else {
            throw new IllegalArgumentException("Invalid enchantment: " + enchantment);
        }
    }

    // Method to toggle a single enchantment
    public static void toggleAxeEnchantment(Map<ResourceKey<Enchantment>, Boolean> axeEnchantments, ResourceKey<Enchantment> enchantment, boolean value) {
        setAxeEnchantment(axeEnchantments, enchantment, value);
    }

    // Method to toggle multiple enchantments
    public static void toggleAxeEnchantments(Map<ResourceKey<Enchantment>, Boolean> axeEnchantments, Map<ResourceKey<Enchantment>, Boolean> enchantmentsToToggle) {
        for (Map.Entry<ResourceKey<Enchantment>, Boolean> entry : enchantmentsToToggle.entrySet()) {
            setAxeEnchantment(axeEnchantments, entry.getKey(), entry.getValue());
        }
    }
}

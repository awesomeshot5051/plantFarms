
package com.awesomeshot5051.plantfarms.fluids.items;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;
import com.awesomeshot5051.plantfarms.fluids.modFluids;


public class WaterItem extends BucketItem {
    public WaterItem() {
        super(modFluids.WATER.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(64).rarity(Rarity.EPIC));
    }
}

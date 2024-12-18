package src.main.java.com.awesomeshot5051.api;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.items.ModItems;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class main {
    public static final DeferredRegister.Items EXTERNAL_ITEM_REGISTER = DeferredRegister.createItems(Main.MODID);
    public static final DeferredHolder<Item, Item> CHORUS_FARM = EXTERNAL_ITEM_REGISTER.register("chorus_farm", () -> ModBlocks.CHORUS_FARM.get().toItem());

    public static void main(String[] args) {
        ModItems.EXTERNAL_ITEM_REGISTER.getEntries();
    }
}

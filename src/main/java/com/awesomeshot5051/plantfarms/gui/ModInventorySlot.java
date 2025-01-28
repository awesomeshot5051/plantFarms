package com.awesomeshot5051.plantfarms.gui;

import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.entity.*;
import net.minecraft.world.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;

public class ModInventorySlot extends Slot {
    protected final InventoryViewerTileentity inventoryViewer;

    public ModInventorySlot(Container c, int index, int xPos, int yPos, InventoryViewerTileentity inventoryViewer) {
        super(c, index, xPos, yPos);
        this.inventoryViewer = inventoryViewer;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        EasyVillagerEntity v = inventoryViewer.getVillagerEntity();
        if (v == null) {
            return false;
        }
        return super.mayPlace(stack) && v.wantsToPickUp(stack);
    }
}
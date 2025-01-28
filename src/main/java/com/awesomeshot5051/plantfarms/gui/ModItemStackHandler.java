package com.awesomeshot5051.plantfarms.gui;

import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.entity.*;
import net.minecraft.core.*;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.items.*;
import org.jetbrains.annotations.*;

public class ModItemStackHandler extends ItemStackHandler {
    protected final InventoryViewerTileentity inventoryViewer;

    public ModItemStackHandler(NonNullList<ItemStack> stacks, InventoryViewerTileentity inventoryViewer) {
        super(stacks);
        this.inventoryViewer = inventoryViewer;
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        EasyVillagerEntity v = inventoryViewer.getVillagerEntity();
        return super.isItemValid(slot, stack) && v != null && v.wantsToPickUp(stack);
    }
}
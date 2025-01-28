package com.awesomeshot5051.plantfarms.gui;

import com.awesomeshot5051.corelib.inventory.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.*;

public abstract class ModContainerBase extends ContainerBase {
    protected ContainerLevelAccess access;

    public ModContainerBase(MenuType containerType, int id, Container playerInventory, Container inventory, ContainerLevelAccess access) {
        super(containerType, id, playerInventory, inventory);
        this.access = access;
    }

    public abstract Block getBlock();

    @Override
    public boolean stillValid(Player player) {
        return super.stillValid(player) && AbstractContainerMenu.stillValid(access, player, getBlock());
    }
}
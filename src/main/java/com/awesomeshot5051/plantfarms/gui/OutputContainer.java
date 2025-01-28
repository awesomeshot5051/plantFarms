package com.awesomeshot5051.plantfarms.gui;

import com.awesomeshot5051.corelib.inventory.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.block.*;

import javax.annotation.*;
import java.util.function.*;

public class OutputContainer extends ModContainerBase {
    @Nullable
    protected Supplier<Block> blockSupplier;

    public OutputContainer(int id, Inventory playerInventory, Container outputInventory, ContainerLevelAccess access, Supplier<Block> blockSupplier) {
        super(Containers.OUTPUT_CONTAINER.get(), id, playerInventory, outputInventory, access);
        this.blockSupplier = blockSupplier;
        for (int i = 0; i < 4; i++) {
            addSlot(new LockedSlot(outputInventory, i, 52 + i * 18, 20, true, false));
        }
        addPlayerInventorySlots();
    }

    public OutputContainer(int id, Inventory playerInventory) {
        this(id, playerInventory, new SimpleContainer(4), ContainerLevelAccess.NULL, null);
    }

    @Override
    public int getInvOffset() {
        return -33;
    }

    @Override
    public int getInventorySize() {
        return 4;
    }

    @Override
    public Block getBlock() {
        if (blockSupplier == null) {
            return Blocks.AIR;
        }
        return blockSupplier.get();
    }
}
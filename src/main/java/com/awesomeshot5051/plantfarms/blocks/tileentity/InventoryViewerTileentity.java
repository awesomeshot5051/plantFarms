package com.awesomeshot5051.plantfarms.blocks.tileentity;

import com.awesomeshot5051.corelib.blockentity.*;
import com.awesomeshot5051.corelib.inventory.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.entity.*;
import com.awesomeshot5051.plantfarms.gui.*;
import net.minecraft.core.*;
import net.minecraft.world.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.*;
import net.neoforged.neoforge.items.*;

public class InventoryViewerTileentity extends VillagerTileentity implements IServerTickableBlockEntity {
    public InventoryViewerTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.INVENTORY_VIEWER.get(), ModBlocks.INVENTORY_VIEWER.get().defaultBlockState(), pos, state);
    }

    @Override
    public void tickServer() {
        if (hasVillager()) {
        }
    }

    public Container getVillagerInventory() {
        return new ItemListInventory(getVillagerEntity().getInventory().getItems(), this::setChanged);
    }

    public Container getVillagerArmorInventory() {
        return new ItemListInventory((NonNullList<ItemStack>) getVillagerEntity().getArmorSlots(), this::setChanged);
    }

    public IItemHandler getItemHandler() {
        EasyVillagerEntity ve = getVillagerEntity();
        if (ve == null) {
            return null;
        }
        return new ModItemStackHandler(ve.getInventory().getItems(), this);
    }
}
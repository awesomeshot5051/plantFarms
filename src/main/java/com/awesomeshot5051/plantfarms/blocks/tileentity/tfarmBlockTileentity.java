package com.awesomeshot5051.plantfarms.blocks.tileentity;

import com.awesomeshot5051.plantfarms.OutputItemHandler;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import de.maxhenkel.corelib.blockentity.IServerTickableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class tfarmBlockTileentity extends VillagerTileentity implements IServerTickableBlockEntity {
    public tfarmBlockTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.TFARM_BLOCK.get(), ModBlocks.TFARM_BLOCK.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    protected OutputItemHandler outputItemHandler;
    protected NonNullList<ItemStack> inventory;
    protected ItemStackHandler itemHandler;

    @Override
    public void tickServer() {

    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }
}

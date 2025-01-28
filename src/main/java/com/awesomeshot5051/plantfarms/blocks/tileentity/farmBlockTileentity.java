package com.awesomeshot5051.plantfarms.blocks.tileentity;

import com.awesomeshot5051.corelib.blockentity.*;
import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.*;
import net.minecraft.core.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.block.state.*;
import net.neoforged.neoforge.items.*;

import java.util.*;

import static com.awesomeshot5051.plantfarms.datacomponents.HoeEnchantments.*;

public class farmBlockTileentity extends VillagerTileentity implements IServerTickableBlockEntity {
    public farmBlockTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.FARM_BLOCK.get(), ModBlocks.FARM_BLOCK.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public Map<ResourceKey<Enchantment>, Boolean> hoeEnchantments = initializeHoeEnchantments();
    public ItemStack hoeType = new ItemStack(Items.WOODEN_HOE);
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
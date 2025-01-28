package com.awesomeshot5051.plantfarms.integration.waila;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import net.minecraft.*;
import net.minecraft.core.component.*;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.level.block.entity.*;
import org.jetbrains.annotations.*;
import snownee.jade.api.*;
import snownee.jade.api.config.*;
import snownee.jade.api.ui.*;
import snownee.jade.impl.ui.*;

import java.util.*;
import java.util.stream.*;

public class HUDHandlerVillager implements IBlockComponentProvider {
    public static final HUDHandlerVillager INSTANCE = new HUDHandlerVillager();
    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Main.MODID, "villager");

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getBlockEntity() instanceof VillagerTileentity blockEntity) {
            ItemStack axeType = blockEntity.getAxeType();
            ItemStack hoeType = blockEntity.getHoeType();
            if (blockEntity instanceof pumpkinFarmTileentity farm) {
                ItemStack shears = farm.getShears();
                if (shears != ItemStack.EMPTY)
                    iTooltip.add(Component.translatable(convertToReadableName(shears.getDescriptionId()) + " is enabled").withStyle(ChatFormatting.RED));
            }
            if (hoeType != ItemStack.EMPTY || axeType != ItemStack.EMPTY) {
                iTooltip.add(Component.translatable(convertToReadableName(axeOrHoe(axeType, hoeType).getDescriptionId())).withStyle(ChatFormatting.RED));
            }
        }
    }

    private ItemStack axeOrHoe(ItemStack axeType, ItemStack hoeType) {
        return axeType != ItemStack.EMPTY ? axeType : hoeType;
    }

    private String convertToReadableName(String block) {
        String readableName = block.replace("item.minecraft.", "").replace('_', ' ');
        return Arrays.stream(readableName.split(" ")).map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    @Override
    public @Nullable IElement getIcon(BlockAccessor accessor, IPluginConfig config, IElement currentIcon) {
        BlockEntity te = accessor.getBlockEntity();
        ItemStack stack2 = new ItemStack(te.getBlockState().getBlock().asItem());
        if (te.getLevel() != null) {
            CompoundTag blockEntityTag = te.saveWithoutMetadata(te.getLevel().registryAccess());
            stack2.set(DataComponents.BLOCK_ENTITY_DATA, CustomData.of(blockEntityTag));
        }
        return ItemStackElement.of(stack2);
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }
}
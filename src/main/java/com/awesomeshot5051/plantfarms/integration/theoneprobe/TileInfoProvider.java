package com.awesomeshot5051.plantfarms.integration.theoneprobe;

import com.awesomeshot5051.plantfarms.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.crops.*;
import mcjty.theoneprobe.api.*;
import net.minecraft.resources.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

import java.util.*;
import java.util.stream.*;

public class TileInfoProvider implements IProbeInfoProvider {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(Main.MODID, "probeinfoprovider");

    @Override
    public ResourceLocation getID() {
        return ID;
    }

    @Override
    public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player playerEntity, Level world, BlockState blockState, IProbeHitData iProbeHitData) {
        BlockEntity te = world.getBlockEntity(iProbeHitData.getPos());
        if (te instanceof VillagerTileentity v) {
            addVillager(v, iProbeInfo);
        }
    }

    private void addVillager(VillagerTileentity villager, IProbeInfo iProbeInfo) {
        if (villager != null) {
            IProbeInfo info = iProbeInfo.horizontal(iProbeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
            ItemStack axeType = villager.getAxeType();
            ItemStack hoeType = villager.getHoeType();
            if (villager instanceof pumpkinFarmTileentity farm) {
                ItemStack shears = farm.getShears();
                if (shears != ItemStack.EMPTY) {
                    info.item(shears).text(convertToReadableName(shears.getDescriptionId()) + " is enabled");
                } else {
                    info.text("Shears is disabled on this farm");
                }
            }
            info.item(axeOrHoe(axeType, hoeType)).text(convertToReadableName(axeOrHoe(axeType, hoeType).getDescriptionId()));
        }
    }

    private ItemStack axeOrHoe(ItemStack axeType, ItemStack hoeType) {
        return axeType != ItemStack.EMPTY ? axeType : hoeType;
    }

    private String convertToReadableName(String block) {
        String readableName = block.replace("item.minecraft.", "").replace('_', ' ');
        return Arrays.stream(readableName.split(" ")).map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }
}
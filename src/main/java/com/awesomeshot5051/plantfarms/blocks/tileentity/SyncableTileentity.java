package com.awesomeshot5051.plantfarms.blocks.tileentity;

import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraft.network.protocol.*;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.level.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.chunk.*;

import java.util.*;

public class SyncableTileentity extends BlockEntity {

    public SyncableTileentity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void sync() {
        if (level instanceof ServerLevel serverLevel) {
            LevelChunk chunk = serverLevel.getChunkAt(getBlockPos());
            if (chunk.getLevel().getChunkSource() instanceof ServerChunkCache chunkCache) {
                chunkCache.chunkMap.getPlayers(chunk.getPos(), false).forEach(this::syncContents);
            }
        }
    }

    public void syncContents(ServerPlayer player) {
        player.connection.send(getUpdatePacket());
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag updateTag = new CompoundTag();
        saveAdditional(updateTag, provider);
        return updateTag;
    }

    // Utility method to validate and parse the  type
    public static Optional<ItemStack> loadHoeType(CompoundTag compound, HolderLookup.Provider provider) {
        if (compound.contains("HoeType")) {
            Tag hoeTypeTag = compound.get("HoeType");
            if (hoeTypeTag != null && isValidHoe(hoeTypeTag.toString())) {
                return ItemStack.parse(provider, hoeTypeTag);
            }
        }
        return Optional.empty();
    }

    public static Optional<ItemStack> loadShears(CompoundTag compound, HolderLookup.Provider provider) {
        if (compound.contains("Shears")) {
            Tag shears = compound.get("Shears");
            if (shears != null) {
                return ItemStack.parse(provider, shears);
            }
        }
        return Optional.empty();
    }

    public static Optional<ItemStack> loadAxeType(CompoundTag compound, HolderLookup.Provider provider) {
        if (compound.contains("AxeType")) {
            Tag axeTypeTag = compound.get("AxeType");
            if (axeTypeTag != null && isValidAxe(axeTypeTag.toString())) {
                return ItemStack.parse(provider, axeTypeTag);
            }
        }
        return Optional.empty();
    }

    private static boolean isValidHoe(String itemId) {
        return itemId.contains("minecraft:wooden_hoe") ||
                itemId.contains("minecraft:stone_hoe") ||
                itemId.contains("minecraft:iron_hoe") ||
                itemId.contains("minecraft:diamond_hoe") ||
                itemId.contains("minecraft:golden_hoe") ||
                itemId.contains("minecraft:netherite_hoe");
    }

    // Helper method to check if an item is a valid axe
    private static boolean isValidAxe(String itemId) {
        return itemId.contains("minecraft:wooden_axe") ||
                itemId.contains("minecraft:stone_axe") ||
                itemId.contains("minecraft:iron_axe") ||
                itemId.contains("minecraft:diamond_axe") ||
                itemId.contains("minecraft:golden_axe") ||
                itemId.contains("minecraft:netherite_axe");
    }
}

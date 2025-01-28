package com.awesomeshot5051.plantfarms.datacomponents;

import com.awesomeshot5051.plantfarms.entity.*;
import com.awesomeshot5051.plantfarms.items.*;
import com.mojang.serialization.*;
import net.minecraft.core.component.*;
import net.minecraft.nbt.*;
import net.minecraft.network.*;
import net.minecraft.network.chat.*;
import net.minecraft.network.codec.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.npc.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.lang.ref.*;
import java.util.*;

public class VillagerData {
    public static final Codec<VillagerData> CODEC = CompoundTag.CODEC.xmap(VillagerData::of, villagerData -> villagerData.nbt);
    public static final StreamCodec<RegistryFriendlyByteBuf, VillagerData> STREAM_CODEC = new StreamCodec<>() {
        @Override
        public VillagerData decode(RegistryFriendlyByteBuf buf) {
            return new VillagerData(buf.readNbt());
        }

        @Override
        public void encode(RegistryFriendlyByteBuf buf, VillagerData villager) {
            buf.writeNbt(villager.nbt);
        }
    };
    private WeakReference<EasyVillagerEntity> villager = new WeakReference<>(null);
    private final CompoundTag nbt;

    private VillagerData(CompoundTag nbt) {
        this.nbt = nbt;
    }

    public static VillagerData of(CompoundTag nbt) {
        return new VillagerData(nbt.copy());
    }

    public static VillagerData of(Villager villager) {
        CompoundTag nbt = new CompoundTag();
        villager.addAdditionalSaveData(nbt);
        return new VillagerData(nbt);
    }

    @Nullable
    public static VillagerData get(ItemStack stack) {
        return stack.get(ModItems.VILLAGER_DATA_COMPONENT);
    }

    public static VillagerData getOrCreate(ItemStack stack) {
        VillagerData villagerData = get(stack);
        return villagerData;
    }

    public EasyVillagerEntity getCacheVillager(Level level) {
        EasyVillagerEntity easyVillager = villager.get();
        if (easyVillager == null) {
            easyVillager = createEasyVillager(level, null);
            villager = new WeakReference<>(easyVillager);
        }
        return easyVillager;
    }

    public EasyVillagerEntity createEasyVillager(Level level, @Nullable ItemStack stack) {
        EasyVillagerEntity v = new EasyVillagerEntity(EntityType.VILLAGER, level);
        v.readAdditionalSaveData(nbt);
        if (stack != null) {
            Component customName = stack.get(DataComponents.CUSTOM_NAME);
            if (customName != null) {
                v.setCustomName(customName);
            }
        }
        v.hurtTime = 0;
        v.yHeadRot = 0F;
        v.yHeadRotO = 0F;
        return v;
    }

    public static EasyVillagerEntity createEasyVillager(ItemStack stack, Level level) {
        VillagerData villagerData = getOrCreate(stack);
        return villagerData.createEasyVillager(level, stack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VillagerData villager1 = (VillagerData) o;
        return Objects.equals(nbt, villager1.nbt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nbt);
    }
}
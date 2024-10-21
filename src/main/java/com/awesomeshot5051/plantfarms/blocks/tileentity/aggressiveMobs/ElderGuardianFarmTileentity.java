package com.awesomeshot5051.plantfarms.blocks.tileentity.aggressiveMobs;

import com.awesomeshot5051.plantfarms.Main;
import com.awesomeshot5051.plantfarms.OutputItemHandler;
import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.ModTileEntities;
import com.awesomeshot5051.plantfarms.blocks.tileentity.VillagerTileentity;
import de.maxhenkel.corelib.blockentity.ITickableBlockEntity;
import de.maxhenkel.corelib.inventory.ItemListInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.Collections;
import java.util.List;

public class ElderGuardianFarmTileentity extends VillagerTileentity implements ITickableBlockEntity {

    private static final ResourceKey<LootTable> ELDERGUARDIAN_LOOT_TABLE = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("entities/elder_guardian"));

    protected NonNullList<ItemStack> inventory;
    protected long timer;

    protected ItemStackHandler itemHandler;
    protected OutputItemHandler outputItemHandler;

    public ElderGuardianFarmTileentity(BlockPos pos, BlockState state) {
        super(ModTileEntities.ELDER_GUARDIAN_FARM.get(), ModBlocks.ELDER_GUARDIAN_FARM.get().defaultBlockState(), pos, state);
        inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        itemHandler = new ItemStackHandler(inventory);
        outputItemHandler = new OutputItemHandler(inventory);
    }

    public static int getElderGuardianSpawnTime() {
        return Main.SERVER_CONFIG.elderGuardianSpawnTime.get() - 20 * 4;
    }

    public static int getElderGuardianExplodeTime() {
        return getElderGuardianSpawnTime() + 20 * 4; // 30 seconds spawn time + 10 seconds kill time
    }

    public long getTimer() {
        return timer;
    }

    @Override
    public void tick() {
        // No villager entity is needed
//        BlockBase.playRandomVillagerSound(level, getBlockPos(), SoundEvents.ELDERGUARDIAN_PRIMED);

        timer++;
        setChanged();

        if (timer == getElderGuardianSpawnTime()) {
//            // Play elderGuardian spawn sound
//            BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ELDERGUARDIAN_PRIMED);
            sync();
//        } else if (timer > getElderGuardianSpawnTime() && timer < getElderGuardianExplodeTime()) {
//            if (timer % 20L == 0L) {
//                BlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ELDERGUARDIAN_HURT);
//            }
        } else if (timer >= getElderGuardianExplodeTime()) {
            // Play elderGuardian death/explosion sound
//            // VillagerBlockBase.playVillagerSound(level, getBlockPos(), SoundEvents.ELDERGUARDIAN_DEATH);
            for (ItemStack drop : getDrops()) {
                for (int i = 0; i < itemHandler.getSlots(); i++) {
                    drop = itemHandler.insertItem(i, drop, false);
                    if (drop.isEmpty()) {
                        break;
                    }
                }
            }

            timer = 0L;
            sync();
        }
    }

    private List<ItemStack> getDrops() {
        if (!(level instanceof ServerLevel serverWorld)) {
            return Collections.emptyList();
        }

        LootParams.Builder builder = new LootParams.Builder(serverWorld)
                .withParameter(LootContextParams.THIS_ENTITY, new ElderGuardian(EntityType.ELDER_GUARDIAN, level))
                .withParameter(LootContextParams.ORIGIN, new Vec3(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()))
                .withParameter(LootContextParams.DAMAGE_SOURCE, serverWorld.damageSources().explosion(null));

        LootParams lootContext = builder.create(LootContextParamSets.ENTITY);

        LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(ELDERGUARDIAN_LOOT_TABLE);

        return lootTable.getRandomItems(lootContext);
    }

    public Container getOutputInventory() {
        return new ItemListInventory(inventory, this::setChanged);
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        super.saveAdditional(compound, provider);

        ContainerHelper.saveAllItems(compound, inventory, false, provider);
        compound.putLong("Timer", timer);
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider provider) {
        ContainerHelper.loadAllItems(compound, inventory, provider);
        timer = compound.getLong("Timer");
        super.loadAdditional(compound, provider);
    }

    public IItemHandler getItemHandler() {
        return outputItemHandler;
    }

}

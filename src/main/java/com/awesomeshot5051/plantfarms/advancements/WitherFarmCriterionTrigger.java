package com.awesomeshot5051.plantfarms.advancements;

import com.mojang.serialization.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.server.level.*;
import net.minecraft.world.item.*;

public class WitherFarmCriterionTrigger extends SimpleCriterionTrigger<MobFarmsTriggerInstance> {
    public void trigger(ServerPlayer player, ItemStack stack) {
        this.trigger(player, triggerInstance -> triggerInstance.matches(stack));
    }

    @Override
    public Codec<MobFarmsTriggerInstance> codec() {
        return MobFarmsTriggerInstance.CODEC;
    }
}
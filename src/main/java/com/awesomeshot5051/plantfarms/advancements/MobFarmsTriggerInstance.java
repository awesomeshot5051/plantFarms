package com.awesomeshot5051.plantfarms.advancements;

import com.awesomeshot5051.plantfarms.*;
import com.mojang.serialization.*;
import com.mojang.serialization.codecs.*;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.registries.*;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.*;

import java.util.*;
import java.util.function.*;

public record MobFarmsTriggerInstance(Optional<ContextAwarePredicate> player,
                                      ItemPredicate predicate) implements SimpleCriterionTrigger.SimpleInstance {
    public static final Codec<MobFarmsTriggerInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(MobFarmsTriggerInstance::player), ItemPredicate.CODEC.fieldOf("item").forGetter(MobFarmsTriggerInstance::predicate)).apply(instance, MobFarmsTriggerInstance::new));

    public boolean matches(ItemStack stack) {
        return this.predicate.test(stack);
    }

    public class MobFarmsTrigger extends SimpleCriterionTrigger<MobFarmsTriggerInstance> {
        public static final DeferredRegister<CriterionTrigger<?>> TRIGGER_TYPES = DeferredRegister.create(Registries.TRIGGER_TYPE, Main.MODID);
        public static final Supplier<WitherFarmCriterionTrigger> WITHER_FARM_TRIGGER = TRIGGER_TYPES.register("wither_farm_trigger", WitherFarmCriterionTrigger::new);

        public static Criterion<MobFarmsTriggerInstance> instance(ContextAwarePredicate player, ItemPredicate item) {
            return WITHER_FARM_TRIGGER.get().createCriterion(new MobFarmsTriggerInstance(Optional.of(player), item));
        }

        @Override
        public Codec<MobFarmsTriggerInstance> codec() {
            return MobFarmsTriggerInstance.CODEC;
        }
    }
}
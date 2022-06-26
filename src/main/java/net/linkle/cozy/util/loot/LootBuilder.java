package net.linkle.cozy.util.loot;

import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;

public class LootBuilder {
    private final LootPool.Builder pool = new LootPool.Builder();

    public LootBuilder setRolls(NumberProvider provider) {
        pool.setRolls(provider);
        return this;
    }

    public LootBuilder setBonusRolls(NumberProvider provider) {
        pool.setBonusRolls(provider);
        return this;
    }

    public LootBuilder add(LootPoolEntryContainer.Builder<?> builder) {
        pool.add(builder);
        return this;
    }

    public LootBuilder when(LootItemCondition.Builder builder) {
        pool.when(builder);
        return this;
    }

    public LootBuilder apply(LootItemFunction.Builder builder) {
        pool.apply(builder);
        return this;
    }

    public LootBuilder name(String name) {
        pool.name(name);
        return this;
    }

    public LootPool build() {
        return pool.build();
    }
}

package net.linkle.cozy.util.loot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.linkle.cozy.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Main.ID, bus = EventBusSubscriber.Bus.FORGE)
public class LootHelper {
    private static final HashMap<ResourceLocation, List<LootPool>> APPEND_MAP = new HashMap<>(64);
    
    /** Create and append a new pool. */
    public static void appendLoot(ResourceLocation lootID, LootBuilder loot) {
        APPEND_MAP.computeIfAbsent(lootID, k -> new ArrayList<>(5)).add(loot.build());
    }
    
    @SubscribeEvent()
    public static void onLootLoad(LootTableLoadEvent event) {
        var list = APPEND_MAP.get(event.getName());
        if (list != null) {
            var table = event.getTable();
            list.forEach(table::addPool);
        }
    }
}

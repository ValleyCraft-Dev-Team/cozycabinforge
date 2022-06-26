package net.linkle.cozy.util;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

import net.linkle.cozy.Main;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

public class Regs {
    private static final LinkedHashMap<Class<?>, DeferredRegister<?>> MAP = new LinkedHashMap<>();

    public static void start() {
        create(ForgeRegistries.BLOCKS, Block.class);
        create(ForgeRegistries.ITEMS, Item.class);
        create(ForgeRegistries.ITEMS, Item.class);
    }

    public static void end() {
        MAP.values().forEach(r -> r.register(FMLJavaModLoadingContext.get().getModEventBus()));
    }

    @SuppressWarnings("unchecked")
    public static <T> RegistryObject<T> register(String ID, Supplier<T> value, Class<T> clazz) {
        var reg = (DeferredRegister<T>) MAP.get(clazz);
        return reg.register(ID, value);
    }

    private static <T extends IForgeRegistryEntry<T>> void create(IForgeRegistry<T> registry, Class<?> clazz) {
        MAP.put(clazz, DeferredRegister.create(registry, Main.ID));
    }
}
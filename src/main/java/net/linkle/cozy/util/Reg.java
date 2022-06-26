package net.linkle.cozy.util;

import java.util.List;
import java.util.function.Supplier;

import net.linkle.cozy.Main;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.RegistryObject;

public class Reg {
    public static RegistryObject<Item> registerItem(String ID, Supplier<Item> item) {
        return Regs.register(ID, item, Item.class);
    }
    
    public static RegistryObject<Block> registerBlock(String ID, Supplier<Block> block) {
        return Regs.register(ID, block, Block.class);
    }
    
    public static RegistryObject<Block> registerWithItem(String ID, Supplier<Block> block, Item.Properties props) {
        var supplier = registerBlock(ID, block);
        registerItem(ID, () -> new BlockItem(supplier.get(), props));
        return supplier;
    }
    
    public static <T> Holder<T> add(Registry<T> registry, String id, T value) {
        return BuiltinRegistries.register(registry, Main.newId(id), value);
    }
    
    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> register(String id, F feature, FC config) {
        return add(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<FC, F>(feature, config));
    }

    public static Holder<PlacedFeature> register(String id, Holder<ConfiguredFeature<?, ?>> entry, List<PlacementModifier> modifiers) {
        return add(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(Holder.hackyErase(entry), modifiers));
    }
}

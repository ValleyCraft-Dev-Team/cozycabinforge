package net.linkle.cozy.init.features;

import java.util.List;
import java.util.stream.Stream;

import net.linkle.cozy.gen.feature.TreeConfigFeatures;
import net.linkle.cozy.init.ModBlocks;
import net.linkle.cozy.util.Reg;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OverworldFeatures {
    
    private static Holder<PlacedFeature> REDWOOD_PLACED;
    private static Holder<PlacedFeature> PATCH_REDWOOD_SORREL;
    private static Holder<PlacedFeature> PATCH_PUFF_FLOWER;
    private static Holder<PlacedFeature> PATCH_WILDFLOWERS;
    private static Holder<PlacedFeature> PATCH_ROSE_AND_LILAC;
    
    public static void intialize() {
        Holder<PlacedFeature> placed;
        Holder<ConfiguredFeature<?, ?>> config;
        List<PlacementModifier> list;
        var vegetal = GenerationStep.Decoration.VEGETAL_DECORATION;
        //var oldGrowthTaiga = BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA);
        //var birchForest = BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA);
        
        // Redwood tree
        list = VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(1), ModBlocks.REDWOOD_SAPLING.get());
        REDWOOD_PLACED = Reg.register("redwood_placed", TreeConfigFeatures.MEGA_REDWOOD, list);
        //BiomeModifications.addFeature(oldGrowthTaiga, vegetal, placed.getKey().get());
        
        PATCH_REDWOOD_SORREL = registerPlant(createConfig("patch_redwood_sorrel", 70, ModBlocks.REDWOOD_SORREL.get()), 16);
        //BiomeModifications.addFeature(oldGrowthTaiga, vegetal, placed.getKey().get());
        
        PATCH_PUFF_FLOWER = registerPlant(createConfig("patch_puff_flower", 80, ModBlocks.PUFF_FLOWER.get()), 20);
        //BiomeModifications.addFeature(birchForest, vegetal, placed.getKey().get());
        
        PATCH_WILDFLOWERS = registerPlant(createConfig("patch_wildflowers", 70, ModBlocks.WILDFLOWERS.get()), 20);
        //BiomeModifications.addFeature(birchForest.and(oldGrowthTaiga), vegetal, placed.getKey().get());
        
        PATCH_ROSE_AND_LILAC = registerPlant(createConfig("patch_rose_and_lilac", 70, ModBlocks.SHORT_ROSE_BUSH.get(), ModBlocks.SHORT_LILAC_BUSH.get()), 40);
        //BiomeModifications.addFeature(BiomeSelectors.categories(Category.FOREST), vegetal, placed.getKey().get());
    }
    
    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (event == null) return;
        var vegetal = GenerationStep.Decoration.VEGETAL_DECORATION;
        if (equals(event.getName(), Biomes.OLD_GROWTH_PINE_TAIGA) || equals(event.getName(), Biomes.OLD_GROWTH_SPRUCE_TAIGA)) {
            event.getGeneration().addFeature(vegetal, REDWOOD_PLACED);
            event.getGeneration().addFeature(vegetal, PATCH_REDWOOD_SORREL);
            event.getGeneration().addFeature(vegetal, PATCH_WILDFLOWERS);
        } 
        if (equals(event.getName(), Biomes.OLD_GROWTH_BIRCH_FOREST) || equals(event.getName(), Biomes.BIRCH_FOREST)) {
            event.getGeneration().addFeature(vegetal, PATCH_WILDFLOWERS);
            event.getGeneration().addFeature(vegetal, PATCH_PUFF_FLOWER);
        } if (event.getCategory() == BiomeCategory.FOREST) {
            event.getGeneration().addFeature(vegetal, PATCH_ROSE_AND_LILAC);
        }
    }
    
    private static boolean equals(ResourceLocation name, ResourceKey<Biome> key) {
        if (name == null) return false; 
        return name.equals(key.location());
    }
    
    /** Create a random patch feature config. */
    public static Holder<ConfiguredFeature<?, ?>> createConfig(String id, int tries, Block... blocks) {
        return createConfig(id, tries, Stream.of(blocks).map(Block::defaultBlockState).toArray(BlockState[]::new));
    }
    
    /** Create a random patch feature config. */
    public static Holder<ConfiguredFeature<?, ?>> createConfig(String id, int tries, BlockState... blocks) {
        SimpleBlockConfiguration config;
        if (blocks.length > 1) {
            var data = new SimpleWeightedRandomList.Builder<BlockState>();
            for (var block : blocks) {
                data.add(block, 1);
            }
            config = new SimpleBlockConfiguration(new WeightedStateProvider(data));
        } else {
            config = new SimpleBlockConfiguration(BlockStateProvider.simple(blocks[0]));
        }
        var entry = PlacementUtils.filtered(Feature.SIMPLE_BLOCK, config, BlockPredicate.ONLY_IN_AIR_PREDICATE);
        var configured = FeatureUtils.simpleRandomPatchConfiguration(tries, entry);
        return Reg.register(id, Feature.RANDOM_PATCH, configured);
    }
    
    public static Holder<PlacedFeature> registerPlant(Holder<ConfiguredFeature<?, ?>> config, int rarity) {
        return registerPlant(config.unwrapKey().get().location().getPath(), config, rarity);
    }
    
    public static Holder<PlacedFeature> registerPlant(String id, Holder<ConfiguredFeature<?, ?>> config, int rarity) {
        return Reg.register(id, config, List.of(RarityFilter.onAverageOnceEvery(rarity), BiomeFilter.biome(), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP));
    }
}

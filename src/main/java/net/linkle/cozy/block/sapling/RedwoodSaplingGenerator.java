package net.linkle.cozy.block.sapling;

import net.linkle.cozy.gen.feature.TreeConfigFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class RedwoodSaplingGenerator extends AbstractMegaTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bee) {
        return null;
    }

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
        return TreeConfigFeatures.MEGA_REDWOOD;
    }
}

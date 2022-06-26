package net.linkle.cozy.block.sapling;

import java.util.Random;

import net.linkle.cozy.gen.feature.TreeConfigFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class RedwoodSaplingGenerator extends AbstractMegaTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bees) {
        return null;
    }

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random random) {
        return TreeConfigFeatures.MEGA_REDWOOD;
    }
}

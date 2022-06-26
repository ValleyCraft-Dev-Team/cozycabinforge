package net.linkle.cozy.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class FloweringVines extends GlowLichenBlock {

    public FloweringVines() {
        super(Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).noCollission().strength(0.2f).sound(SoundType.GLOW_LICHEN));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.getItemInHand().is(this.asItem()) || super.canBeReplaced(state, context);
    }
}

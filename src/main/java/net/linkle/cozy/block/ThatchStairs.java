package net.linkle.cozy.block;

import net.linkle.cozy.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class ThatchStairs extends StairBlock {
    public ThatchStairs() {
        super(ModBlocks.THATCH_BLOCK.get()::defaultBlockState, 
                Properties.of(Material.GRASS, MaterialColor.WOOD)
                .sound(SoundType.GRASS)
                .strength(0.5f));
    }
    
    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.causeFallDamage(fallDistance, 0.2F, DamageSource.FALL);
    }
}
package net.linkle.cozy.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModPlantBlock extends BushBlock {
    private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 12, 13);
    private static final Properties SETTINGS = Properties.copy(Blocks.POPPY);

    public ModPlantBlock() {
        super(SETTINGS);
    }

    public ModPlantBlock(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}

package net.linkle.cozy.client;

import static net.linkle.cozy.init.ModBlocks.FLOWERING_VINES;
import static net.linkle.cozy.init.ModBlocks.FLOWER_LANTERN;
import static net.linkle.cozy.init.ModBlocks.GLOW_BERRY_LANTERN;
import static net.linkle.cozy.init.ModBlocks.POTTED_PUFF_FLOWER;
import static net.linkle.cozy.init.ModBlocks.POTTED_REDWOOD_SORREL;
import static net.linkle.cozy.init.ModBlocks.POTTED_SHORT_LILAC;
import static net.linkle.cozy.init.ModBlocks.POTTED_SHORT_PEONY;
import static net.linkle.cozy.init.ModBlocks.POTTED_SHORT_ROSE;
import static net.linkle.cozy.init.ModBlocks.POTTED_WILDFLOWERS;
import static net.linkle.cozy.init.ModBlocks.PUFF_FLOWER;
import static net.linkle.cozy.init.ModBlocks.REDWOOD_LEAVES;
import static net.linkle.cozy.init.ModBlocks.REDWOOD_SAPLING;
import static net.linkle.cozy.init.ModBlocks.REDWOOD_SORREL;
import static net.linkle.cozy.init.ModBlocks.SHORT_LILAC_BUSH;
import static net.linkle.cozy.init.ModBlocks.SHORT_PEONY_BUSH;
import static net.linkle.cozy.init.ModBlocks.SHORT_ROSE_BUSH;
import static net.linkle.cozy.init.ModBlocks.WILDFLOWERS;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class RenderLayers {

    @SuppressWarnings("unused")
    public static void intialize() {
        // Only use cullout if the block's texture contains empty pixels.
        var cullout = RenderType.cutout();

        // Only use translucent if the block's texture contains transparent pixels.
        var translucent = RenderType.translucent();

        // Example
        // put(Blocks.GLASS, cullout);
        put(GLOW_BERRY_LANTERN, cullout);
        put(FLOWER_LANTERN, cullout);
        put(SHORT_LILAC_BUSH, cullout);
        put(SHORT_ROSE_BUSH, cullout);
        put(SHORT_PEONY_BUSH, cullout);
        put(FLOWERING_VINES, cullout);
        put(REDWOOD_LEAVES, cullout);
        put(REDWOOD_SAPLING, cullout);
        put(REDWOOD_SORREL, cullout);
        put(WILDFLOWERS, cullout);
        put(PUFF_FLOWER, cullout);
        //put(LEATHERY_POLYPODY, cullout);
        put(POTTED_REDWOOD_SORREL, cullout);
        put(POTTED_PUFF_FLOWER, cullout);
        put(POTTED_WILDFLOWERS, cullout);
        put(POTTED_SHORT_ROSE, cullout);
        put(POTTED_SHORT_LILAC, cullout);
        put(POTTED_SHORT_PEONY, cullout);
    }

    private static void put(RegistryObject<Block> block, RenderType type) {
        ItemBlockRenderTypes.setRenderLayer(block.get(), type);
    }
}

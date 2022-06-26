package net.linkle.cozy.init;

import static net.linkle.cozy.init.ModBlocks.*;

import java.util.HashMap;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.linkle.cozy.Main;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BlockEvent.BlockToolModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = Main.ID, bus = EventBusSubscriber.Bus.FORGE)
public class Contents {
    
    private static final Object2IntMap<ItemLike> FUELS = new Object2IntOpenHashMap<>();
    private static final HashMap<Block, Block> STRIPS = new HashMap<>();
    
    public static void initialize() {
        compost();
        flammable();
        fuels();
        strips();
    }
    
    private static void strips() {
        putStrip(REDWOOD_LOG, STRIPPED_REDWOOD_LOG);
        putStrip(REDWOOD_WOOD, STRIPPED_REDWOOD_WOOD);
    }

    @SuppressWarnings("unused")
    private static void compost() {
        float levelLow = 0.3f; // leaves, seeds, saplings, grass.
        float levelMed = 0.5f; // double plant, vines.
        float levelHigh = 0.65f; // foods, flowers.
        float levelVery = 0.85f; // blocks.
        float levelUltra = 1.0f; // specials.
        
        putCompost(REDWOOD_LEAVES.get(), levelLow);
        putCompost(REDWOOD_SAPLING.get(), levelLow);
        
        putCompost(FLOWERING_VINES.get(), levelMed);
        putCompost(THATCH_SLAB.get(), levelMed);
        putCompost(SHORT_ROSE_BUSH.get(), levelMed);
        putCompost(SHORT_LILAC_BUSH.get(), levelMed);
        putCompost(SHORT_PEONY_BUSH.get(), levelMed);
        
        putCompost(THATCH_BLOCK.get(), levelHigh);
        putCompost(THATCH_STAIRS.get(), levelHigh);
        putCompost(REDWOOD_SORREL.get(), levelHigh);
        putCompost(PUFF_FLOWER.get(), levelHigh);
        putCompost(WILDFLOWERS.get(), levelHigh);
        //putCompost(LEATHERY_POLYPODY, levelHigh);
    }
    
    private static void flammable() {     
        putFlammable(REDWOOD_LOG, 5, 5);
        putFlammable(REDWOOD_WOOD, 5, 5);
        putFlammable(STRIPPED_REDWOOD_LOG, 5, 5);
        putFlammable(STRIPPED_REDWOOD_WOOD, 5, 5);
        putFlammable(REDWOOD_PLANKS, 5, 20);
        putFlammable(REDWOOD_SLAB, 5, 20);
        putFlammable(REDWOOD_STAIRS, 5, 20);
        putFlammable(REDWOOD_FENCE, 5, 20);
        putFlammable(REDWOOD_FENCE_GATE, 5, 20);
        putFlammable(ACACIA_CABIN_LOGS, 5, 5);
        putFlammable(BIRCH_CABIN_LOGS, 5, 5);
        putFlammable(DARK_OAK_CABIN_LOGS, 5, 5);
        putFlammable(JUNGLE_CABIN_LOGS, 5, 5);
        putFlammable(OAK_CABIN_LOGS, 5, 5);
        putFlammable(SPRUCE_CABIN_LOGS, 5, 5);
        putFlammable(REDWOOD_CABIN_LOGS, 5, 5);
        putFlammable(MANGROVE_CABIN_LOGS, 5, 5);
        putFlammable(ACACIA_BARK_PLANKS, 5, 10);
        putFlammable(BIRCH_BARK_PLANKS, 5, 10);
        putFlammable(DARK_OAK_BARK_PLANKS, 5, 10);
        putFlammable(JUNGLE_BARK_PLANKS, 5, 10);
        putFlammable(OAK_BARK_PLANKS, 5, 10);
        putFlammable(SPRUCE_BARK_PLANKS, 5, 10);
        putFlammable(REDWOOD_BARK_PLANKS, 5, 10);
        putFlammable(MANGROVE_BARK_PLANKS, 5, 10);
        
        putFlammable(REDWOOD_LEAVES, 30, 60);
        
        putFlammable(THATCH_BLOCK, 60, 20);
        putFlammable(THATCH_STAIRS, 60, 20);
        putFlammable(THATCH_SLAB, 60, 20);
        
        putFlammable(GLOW_BERRY_LANTERN, 5, 10);
        putFlammable(FLOWER_LANTERN, 5, 10);
        //putFlammable(AMETHYST_LANTERN, 5, 10);
        
        putFlammable(SHORT_ROSE_BUSH, 60, 100);
        putFlammable(SHORT_LILAC_BUSH, 60, 100);
        putFlammable(SHORT_PEONY_BUSH, 60, 100);
        
        putFlammable(CHARCOAL_BLOCK, 5, 5);
        putFlammable(FLOWERING_VINES, 15, 100);
    }
    
    @SubscribeEvent
    public static void fuelEvent(FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().isEmpty()) return;
        int time = FUELS.getOrDefault(event.getItemStack().getItem(), Integer.MIN_VALUE);
        if (time != Integer.MIN_VALUE) {
            event.setBurnTime(time);
        }
    }
    
    @SubscribeEvent
    public static void stripEvent(BlockToolModificationEvent event) {
        if (event.getToolAction() == ToolActions.AXE_STRIP) {
            var state = event.getState();
            var block = STRIPS.get(state.getBlock());
            var result = block != null ? block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)) : null;
            if (result != null) {
                event.setFinalState(result);
            }
        }
    }
    
    private static void fuels() {
        putFuels(CHARCOAL_BLOCK.get(), 16000);
    }
    
    private static void putStrip(RegistryObject<Block> input, RegistryObject<Block> stripped) {
        STRIPS.put(input.get(), stripped.get());
    }
    
    private static void putCompost(ItemLike item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
    
    private static void putFlammable(RegistryObject<Block> block, int burn, int spread) {
        //FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
    }
    
    private static void putFuels(ItemLike item, int tick) {
        FUELS.put(item.asItem(), tick);
    }
}

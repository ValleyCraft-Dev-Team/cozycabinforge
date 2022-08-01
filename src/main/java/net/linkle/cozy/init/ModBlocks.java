package net.linkle.cozy.init;

import net.linkle.cozy.block.FloweringVines;
import net.linkle.cozy.block.ModPlantBlock;
import net.linkle.cozy.block.ThatchSlab;
import net.linkle.cozy.block.ThatchStairs;
import net.linkle.cozy.block.sapling.RedwoodSaplingGenerator;
import net.linkle.cozy.util.Reg;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final RegistryObject<Block> REDWOOD_WOOD = Reg.registerWithItem("redwood_wood", ()->createLogBlock(MaterialColor.TERRACOTTA_BLACK, MaterialColor.TERRACOTTA_BLACK), itemSettings());
    public static final RegistryObject<Block> REDWOOD_LOG = Reg.registerWithItem("redwood_log", ()->createLogBlock(MaterialColor.TERRACOTTA_BROWN, MaterialColor.TERRACOTTA_BLACK), itemSettings());
    public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = Reg.registerWithItem("stripped_redwood_wood", ()->createLogBlock(MaterialColor.TERRACOTTA_BLACK, MaterialColor.TERRACOTTA_BLACK), itemSettings());
    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = Reg.registerWithItem("stripped_redwood_log", ()->createLogBlock(MaterialColor.TERRACOTTA_BROWN, MaterialColor.TERRACOTTA_BROWN), itemSettings());
    public static final RegistryObject<Block> REDWOOD_PLANKS = Reg.registerWithItem("redwood_planks", ()->new Block(Block.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_BROWN).strength(2.0f, 3.0f).sound(SoundType.WOOD)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_DOOR = Reg.registerWithItem("redwood_door", ()->new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR).color(MaterialColor.TERRACOTTA_BROWN)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_TRAPDOOR = Reg.registerWithItem("redwood_trapdoor", ()->new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR).color(MaterialColor.TERRACOTTA_BROWN)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_SLAB = Reg.registerWithItem("redwood_slab", ()->new SlabBlock(Block.Properties.copy(Blocks.OAK_SLAB).color(MaterialColor.TERRACOTTA_BROWN)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_STAIRS = Reg.registerWithItem("redwood_stairs", ()->new StairBlock(REDWOOD_PLANKS.get()::defaultBlockState, Block.Properties.copy(Blocks.OAK_STAIRS).color(MaterialColor.TERRACOTTA_BROWN)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_BUTTON = Reg.registerWithItem("redwood_button", ()->new WoodButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_FENCE = Reg.registerWithItem("redwood_fence", ()->new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE).color(MaterialColor.TERRACOTTA_BROWN)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_FENCE_GATE = Reg.registerWithItem("redwood_fence_gate", ()->new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE).color(MaterialColor.TERRACOTTA_BROWN)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = Reg.registerWithItem("redwood_pressure_plate", ()->new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE).color(MaterialColor.TERRACOTTA_BROWN)), itemSettings());
    //public static final RegistryObject<Block> REDWOOD_SIGN = Reg.registerBlock("redwood_sign", ()->new ModSignBlock(Block.Properties.copy(Blocks.OAK_SIGN).dropsLike(REDWOOD_FENCE.get()), ModSignType.REDWOOD));
    //public static final RegistryObject<Block> REDWOOD_WALL_SIGN = Reg.registerBlock("redwood_wall_sign", ()->new WallSignBlock(Block.Properties.copy(Blocks.OAK_WALL_SIGN).dropsLike(REDWOOD_SIGN.get()), ModSignType.REDWOOD));
    
    public static final RegistryObject<Block> ACACIA_CABIN_LOGS = Reg.registerWithItem("acacia_cabin_logs", ()->new RotatedPillarBlock(Block.Properties.copy(Blocks.ACACIA_LOG)), itemSettings());
    public static final RegistryObject<Block> BIRCH_CABIN_LOGS = Reg.registerWithItem("birch_cabin_logs", ()->new RotatedPillarBlock(Block.Properties.copy(Blocks.BIRCH_LOG)), itemSettings());
    public static final RegistryObject<Block> DARK_OAK_CABIN_LOGS = Reg.registerWithItem("dark_oak_cabin_logs", ()->new RotatedPillarBlock(Block.Properties.copy(Blocks.DARK_OAK_LOG)), itemSettings());
    public static final RegistryObject<Block> JUNGLE_CABIN_LOGS = Reg.registerWithItem("jungle_cabin_logs", ()->new RotatedPillarBlock(Block.Properties.copy(Blocks.JUNGLE_LOG)), itemSettings());
    public static final RegistryObject<Block> OAK_CABIN_LOGS = Reg.registerWithItem("oak_cabin_logs", ()->new RotatedPillarBlock(Block.Properties.copy(Blocks.OAK_LOG)), itemSettings());
    public static final RegistryObject<Block> SPRUCE_CABIN_LOGS = Reg.registerWithItem("spruce_cabin_logs", ()->new RotatedPillarBlock(Block.Properties.copy(Blocks.SPRUCE_LOG)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_CABIN_LOGS = Reg.registerWithItem("redwood_cabin_logs", ()->new RotatedPillarBlock(Block.Properties.copy(REDWOOD_LOG.get())), itemSettings());
    
    public static final RegistryObject<Block> ACACIA_BARK_PLANKS = Reg.registerWithItem("acacia_log_planks", ()->new Block(Block.Properties.copy(Blocks.ACACIA_PLANKS)), itemSettings());
    public static final RegistryObject<Block> BIRCH_BARK_PLANKS = Reg.registerWithItem("birch_log_planks", ()->new Block(Block.Properties.copy(Blocks.BIRCH_PLANKS)), itemSettings());
    public static final RegistryObject<Block> DARK_OAK_BARK_PLANKS = Reg.registerWithItem("dark_oak_log_planks", ()->new Block(Block.Properties.copy(Blocks.DARK_OAK_PLANKS)), itemSettings());
    public static final RegistryObject<Block> JUNGLE_BARK_PLANKS = Reg.registerWithItem("jungle_log_planks", ()->new Block(Block.Properties.copy(Blocks.JUNGLE_PLANKS)), itemSettings());
    public static final RegistryObject<Block> OAK_BARK_PLANKS = Reg.registerWithItem("oak_log_planks", ()->new Block(Block.Properties.copy(Blocks.OAK_PLANKS)), itemSettings());
    public static final RegistryObject<Block> SPRUCE_BARK_PLANKS = Reg.registerWithItem("spruce_log_planks", ()->new Block(Block.Properties.copy(Blocks.SPRUCE_PLANKS)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_BARK_PLANKS = Reg.registerWithItem("redwood_log_planks", ()->new Block(Block.Properties.copy(REDWOOD_PLANKS.get())), itemSettings());
    
    public static final RegistryObject<Block> CHARCOAL_BLOCK = Reg.registerWithItem("charcoal_block", ()->new Block(Block.Properties.copy(Blocks.COAL_BLOCK)), itemSettings());
    
    private static final Block.Properties LANTERN = Block.Properties.of(new Material.Builder(MaterialColor.WOOD).build()).sound(SoundType.WOOD).strength(2.5f).lightLevel(state -> 10);
    public static final RegistryObject<Block> GLOW_BERRY_LANTERN = Reg.registerWithItem("glow_berry_lantern", ()->new LanternBlock(LANTERN), itemSettings());
    public static final RegistryObject<Block> FLOWER_LANTERN = Reg.registerWithItem("flower_lantern", ()->new LanternBlock(LANTERN), itemSettings());
    
    public static final RegistryObject<Block> THATCH_BLOCK = Reg.registerWithItem("thatch_block", ()->new HayBlock(Block.Properties.copy(Blocks.HAY_BLOCK).color(MaterialColor.WOOD)), itemSettings());
    public static final RegistryObject<Block> PATTERNED_THATCH_BLOCK = Reg.registerWithItem("patterned_thatch_block", ()->new HayBlock(Block.Properties.copy(Blocks.HAY_BLOCK).color(MaterialColor.WOOD)), itemSettings());
    public static final RegistryObject<Block> THATCH_STAIRS = Reg.registerWithItem("thatch_stairs", ()->new ThatchStairs(), itemSettings());
    public static final RegistryObject<Block> THATCH_SLAB = Reg.registerWithItem("thatch_slab", ()->new ThatchSlab(), itemSettings());
    
    public static final RegistryObject<Block> REDWOOD_LEAVES = Reg.registerWithItem("redwood_leaves", ()->new LeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_SAPLING = Reg.registerWithItem("redwood_sapling", ()->new SaplingBlock(new RedwoodSaplingGenerator(), Block.Properties.copy(Blocks.OAK_SAPLING)), itemSettings());
    
    public static final RegistryObject<Block> SHORT_ROSE_BUSH = Reg.registerWithItem("short_rose_bush", ()->new ModPlantBlock(Block.Properties.copy(Blocks.POPPY)), itemSettings());
    public static final RegistryObject<Block> SHORT_LILAC_BUSH = Reg.registerWithItem("short_lilac_bush", ()->new ModPlantBlock(Block.Properties.copy(Blocks.POPPY)), itemSettings());
    public static final RegistryObject<Block> SHORT_PEONY_BUSH = Reg.registerWithItem("short_peony_bush", ()->new ModPlantBlock(Block.Properties.copy(Blocks.POPPY)), itemSettings());
    public static final RegistryObject<Block> REDWOOD_SORREL = Reg.registerWithItem("redwood_sorrel", ()->new ModPlantBlock(Block.Properties.copy(Blocks.POPPY)), itemSettings());
    public static final RegistryObject<Block> PUFF_FLOWER = Reg.registerWithItem("puff_flower", ()->new ModPlantBlock(Block.Properties.copy(Blocks.POPPY)), itemSettings());
    public static final RegistryObject<Block> WILDFLOWERS = Reg.registerWithItem("wildflowers", ()->new ModPlantBlock(Block.Properties.copy(Blocks.POPPY)), itemSettings());
    
    public static final RegistryObject<Block> POTTED_REDWOOD_SORREL = Reg.registerBlock("potted_redwood_sorrel", ()->new FlowerPotBlock(()->(FlowerPotBlock)Blocks.FLOWER_POT, REDWOOD_SORREL, Block.Properties.copy(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_PUFF_FLOWER = Reg.registerBlock("potted_puff_flower", ()->new FlowerPotBlock(()->(FlowerPotBlock)Blocks.FLOWER_POT, PUFF_FLOWER, Block.Properties.copy(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_WILDFLOWERS = Reg.registerBlock("potted_wildflowers", ()->new FlowerPotBlock(()->(FlowerPotBlock)Blocks.FLOWER_POT, WILDFLOWERS, Block.Properties.copy(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_SHORT_ROSE = Reg.registerBlock("potted_short_rose", ()->new FlowerPotBlock(()->(FlowerPotBlock)Blocks.FLOWER_POT, SHORT_ROSE_BUSH, Block.Properties.copy(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_SHORT_LILAC = Reg.registerBlock("potted_short_lilac", ()->new FlowerPotBlock(()->(FlowerPotBlock)Blocks.FLOWER_POT, SHORT_LILAC_BUSH, Block.Properties.copy(Blocks.POTTED_POPPY)));
    public static final RegistryObject<Block> POTTED_SHORT_PEONY = Reg.registerBlock("potted_short_peony", ()->new FlowerPotBlock(()->(FlowerPotBlock)Blocks.FLOWER_POT, SHORT_PEONY_BUSH, Block.Properties.copy(Blocks.POTTED_POPPY)));

    public static final RegistryObject<Block> FLOWERING_VINES = Reg.registerWithItem("flowering_vines", ()->new FloweringVines(), itemSettings());
    
    public static void intialize() {
        
    }
    
    public static void postInit() {
        addPottedPlant(REDWOOD_SORREL, POTTED_REDWOOD_SORREL);
        addPottedPlant(PUFF_FLOWER, POTTED_PUFF_FLOWER);
        addPottedPlant(WILDFLOWERS, POTTED_WILDFLOWERS);
        addPottedPlant(SHORT_ROSE_BUSH, POTTED_SHORT_ROSE);
        addPottedPlant(SHORT_LILAC_BUSH, POTTED_SHORT_LILAC);
        addPottedPlant(SHORT_PEONY_BUSH, POTTED_SHORT_PEONY);
    }
    
    private static void addPottedPlant(RegistryObject<Block> flower, RegistryObject<Block> fullPot) {
        ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(flower.get().getRegistryName(), fullPot);
    }
    
    private static Item.Properties itemSettings() {
        return new Item.Properties().tab(ModGroups.CABIN_GROUP);
    }
    
    private static RotatedPillarBlock createLogBlock(MaterialColor topMapColor, MaterialColor sideMapColor) {
        return new RotatedPillarBlock(Block.Properties.of(Material.WOOD, state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).strength(2.0f).sound(SoundType.WOOD));
    }
}

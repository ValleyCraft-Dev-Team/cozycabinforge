package net.linkle.cozy;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.linkle.cozy.client.Client;
import net.linkle.cozy.init.Contents;
import net.linkle.cozy.init.ModBlocks;
import net.linkle.cozy.init.ModGroups;
import net.linkle.cozy.init.ModItems;
import net.linkle.cozy.init.ModLootTables;
import net.linkle.cozy.init.features.OverworldFeatures;
import net.linkle.cozy.util.Regs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.ID)
public class Main
{
    public static final String ID = "cozycabincore";
    
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LoggerFactory.getLogger(ID);
            

    public Main() {
        Regs.start();
        ModBlocks.intialize();
        ModItems.intialize();
        Regs.end();
        
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.addListener(OverworldFeatures::onBiomeLoadingEvent);
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        DistExecutor.safeRunForDist(() -> Client::new, () -> Nothing::new).accept(bus);
    }
    
    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModBlocks.postInit();
            Contents.initialize();
            ModGroups.initialize();
            OverworldFeatures.intialize();
            ModLootTables.initialize();
        });
    }
    
    public static ResourceLocation newId(String id) {
        return new ResourceLocation(ID, id);
    }
    
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(modid = ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
            
        }
    }
    
    public static class Nothing implements Consumer<IEventBus> {
        @Override
        public void accept(IEventBus t) {
        }
    }
}

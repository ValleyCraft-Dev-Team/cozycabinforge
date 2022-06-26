package net.linkle.cozy.client;

import java.util.function.Consumer;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class Client implements Consumer<IEventBus> {
    @Override
    public void accept(IEventBus modEventBus) {
        modEventBus.addListener(this::clientSetup);
    }
    
    private void clientSetup(FMLClientSetupEvent event) {
        RenderLayers.intialize();
    }
}

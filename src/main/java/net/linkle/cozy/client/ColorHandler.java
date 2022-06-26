package net.linkle.cozy.client;

import net.linkle.cozy.Main;
import net.linkle.cozy.init.ModBlocks;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Main.ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorHandler {
    @SubscribeEvent
    public static void BlockColorHandler(ColorHandlerEvent.Block event) {
        event.getBlockColors().register(newBlockColor(0x84BF70), ModBlocks.REDWOOD_LEAVES.get());
    }
    
    @SubscribeEvent
    public static void ItemColorHandler(ColorHandlerEvent.Item event) {
        event.getItemColors().register(newItemColor(0x84BF70), ModBlocks.REDWOOD_LEAVES.get());
    }
    
    private static BlockColor newBlockColor(int color) {
        return (state, view, pos, index) -> color;
    }
    
    private static ItemColor newItemColor(int color) {
        return (stack, index) -> color;
    }
}

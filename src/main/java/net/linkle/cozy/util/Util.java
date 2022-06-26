package net.linkle.cozy.util;

import java.util.function.Supplier;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Util {
    public static CreativeModeTab newTap(String name, Supplier<ItemStack> stack) {
        return new CreativeModeTab(name) {
            @Override
            public ItemStack makeIcon() {
                return stack.get();
            }
        };
    }
}

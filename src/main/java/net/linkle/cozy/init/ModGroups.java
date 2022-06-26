package net.linkle.cozy.init;

import net.linkle.cozy.util.Util;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModGroups {
    public static final CreativeModeTab CABIN_GROUP = Util.newTap("cabin", ()->new ItemStack(ModItems.CABIN_ICON.get()));

    public static void initialize() {
    }
}

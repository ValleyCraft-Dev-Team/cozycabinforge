package net.linkle.cozy.init;

import static net.linkle.cozy.init.ModGroups.CABIN_GROUP;

import net.linkle.cozy.item.ItemIcon;
import net.linkle.cozy.util.Reg;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    
    //public static final RegistryObject<Item> REDWOOD_SIGN = Reg.registerItem("redwood_sign", ()->new SignItem(settings().stacksTo(16), ModBlocks.REDWOOD_SIGN.get(), ModBlocks.REDWOOD_WALL_SIGN.get()));
    public static final RegistryObject<Item> PINE_TAR = Reg.registerItem("pine_sap", ()->new Item(settings()));
    public static final RegistryObject<Item> PITCH_BOTTLE = Reg.registerItem("pitch_bottle", ()->new Item(settings().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));

    //icons

    public static final RegistryObject<Item> HOME_ICON = Reg.registerItem("home_icon", ()->new ItemIcon());
    public static final RegistryObject<Item> HONEY_ICON = Reg.registerItem("honey_icon", ()->new ItemIcon());
    public static final RegistryObject<Item> CABIN_ICON = Reg.registerItem("cabin_icon", ()->new ItemIcon());

    public static void intialize() {
    }

    private static Item.Properties settings() {
        return new Item.Properties().tab(CABIN_GROUP);
    }
}

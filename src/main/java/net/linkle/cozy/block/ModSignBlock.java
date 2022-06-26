package net.linkle.cozy.block;

import net.linkle.cozy.Main;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModSignBlock extends StandingSignBlock {

    public ModSignBlock(Properties settings, WoodType woodType) {
        super(settings, woodType);
        drops = Main.newId("blocks/" + woodType.name() + "_sign");
    }

}

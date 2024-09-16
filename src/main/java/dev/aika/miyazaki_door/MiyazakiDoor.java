package dev.aika.miyazaki_door;

import dev.aika.miyazaki_door.block.ModBlocks;
import dev.aika.miyazaki_door.item.ModItemGroup;
import dev.aika.miyazaki_door.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiyazakiDoor implements ModInitializer {
    public static final String MOD_ID = "miyazaki-door";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroup.initialize();
        ModItems.initialize();
        ModBlocks.initialize();
    }
}
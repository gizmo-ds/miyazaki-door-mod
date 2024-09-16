package dev.aika.miyazaki_door.item;

import dev.aika.miyazaki_door.MiyazakiDoor;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    @SafeVarargs
    public static <T extends Item> T register(String path, T item, RegistryKey<ItemGroup>... itemGroups) {
        T registeredItem = Registry.register(Registries.ITEM, Identifier.of(MiyazakiDoor.MOD_ID, path), item);
        for (RegistryKey<ItemGroup> itemGroup : itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registeredItem));
        }
        return registeredItem;
    }

    public static void initialize() {
    }
}

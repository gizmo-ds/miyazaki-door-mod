package dev.aika.miyazaki_door.block;

import dev.aika.miyazaki_door.MiyazakiDoor;
import dev.aika.miyazaki_door.item.ModItemGroup;
import dev.aika.miyazaki_door.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;


public class ModBlocks {
    public static final Block OAK_MIYAZAKI_DOOR = register("oak_miyazaki_door",
            new MiyazakiDoorBlock(
                    FabricBlockSettings.copyOf(Blocks.OAK_DOOR)
                            .pistonBehavior(PistonBehavior.BLOCK)
                            .strength(50.0F, 800.0F),
                    BlockSetTypeBuilder.copyOf(BlockSetType.OAK).openableByHand(false).build(new Identifier("miyazaki_door_oak"))),
            ModItemGroup.ITEM_GROUP_KEY
    );

    @SafeVarargs
    private static <T extends Block> T register(String path, T block, RegistryKey<ItemGroup>... itemGroups) {
        ModItems.register(path, new BlockItem(block, new Item.Settings()), itemGroups);
        return Registry.register(Registries.BLOCK, Identifier.of(MiyazakiDoor.MOD_ID, path), block);
    }

    public static void initialize() {
    }
}

package name.strangeworld.registry;

import name.strangeworld.StrangeWorld;
import name.strangeworld.item.HomeScrollItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModItem {
    public static final HomeScrollItem  HOME_SCROLL_ITEM=new HomeScrollItem(new Item.Settings().maxCount(16));
    public static final Item HOMESCROLLREGISTEY =
            registerItem("home_scroll",HOME_SCROLL_ITEM,ModItemGroup.STRANGEWORLD);
    public static void registerAllModItem() {
        FuelRegistry.INSTANCE.add(HOMESCROLLREGISTEY,3000);
        StrangeWorld.LOGGER.debug("Register mod item for "+StrangeWorld.MOD_ID);
    }
    public static Item registerItem(String name, Item item, ItemGroup... itemGroups) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(StrangeWorld.MOD_ID, name), item);
        for (ItemGroup itemGroup : itemGroups) {
            RegistryKey<ItemGroup> rK=RegistryKey.of(RegistryKeys.ITEM_GROUP,new Identifier(StrangeWorld.MOD_ID,"sw"));
            ItemGroupEvents.modifyEntriesEvent(rK).register(content -> content.add(item));
        }
        return registeredItem;
    }

}

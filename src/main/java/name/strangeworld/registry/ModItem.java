package name.strangeworld.registry;

import name.strangeworld.StrangeWorld;
import name.strangeworld.item.EnchantedHomeScrollItem;
import name.strangeworld.item.HomeScrollItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItem {
    public static final HomeScrollItem  HOME_SCROLL_ITEM=new HomeScrollItem(new Item.Settings().maxCount(16));
    public static final Item HOME_SCROLL_ITEM_REGISTRY =
            registerItem("home_scroll",HOME_SCROLL_ITEM,ModItemGroup.STRANGEWORLD);
    public static final EnchantedHomeScrollItem ENCHANTED_SCROLL_ITEM=new EnchantedHomeScrollItem(new Item.Settings().maxCount(16));
    public static final Item ENCHANTED_HOME_SCROLL_ITEM_REGISTRY =
            registerItem("enchanted_home_scroll",ENCHANTED_SCROLL_ITEM,ModItemGroup.STRANGEWORLD);
    public static void registerAllModItem() {
        FuelRegistry.INSTANCE.add(HOME_SCROLL_ITEM_REGISTRY,1000);
        FuelRegistry.INSTANCE.add(ENCHANTED_HOME_SCROLL_ITEM_REGISTRY,3000);
        StrangeWorld.LOGGER.debug("Register mod item for "+StrangeWorld.MOD_ID);
    }
    public static Item registerItem(String name, Item item, ItemGroup... itemGroups) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(StrangeWorld.MOD_ID, name), item);
        //for (ItemGroup itemGroup : itemGroups)
        {
            RegistryKey<ItemGroup> rK=RegistryKey.of(RegistryKeys.ITEM_GROUP,new Identifier(StrangeWorld.MOD_ID,"sw"));
            ItemGroupEvents.modifyEntriesEvent(rK).register(content -> content.add(item));
        }
        return registeredItem;
    }

}

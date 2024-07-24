package name.strangeworld.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.S2CPlayChannelEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import name.strangeworld.StrangeWorld;

public class ModItemGroup {
    public static ItemGroup STRANGEWORLD= FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.strangeworld.sw"))
            .icon(()->new ItemStack(ModItem.HOMESCROLLREGISTEY))
            .build();
    public static void registerModItemGroup(){
        Registry.register(Registries.ITEM_GROUP,new Identifier(StrangeWorld.MOD_ID,"sw"),STRANGEWORLD);
        StrangeWorld.LOGGER.debug("Register mod item groups for "+StrangeWorld.MOD_ID);
    }


}

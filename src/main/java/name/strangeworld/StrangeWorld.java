package name.strangeworld;

import name.strangeworld.registry.ModItem;
import name.strangeworld.registry.ModItemGroup;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrangeWorld implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("strangeworld");
	public static final String MOD_ID = "strangeworld";
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItem.registerAllModItem();
		ModItemGroup.registerModItemGroup();
		//LOGGER.info("Hello Fabric world!");
	}
}
package net.genesis.autofish;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Autofish implements ModInitializer {

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static MinecraftClient mc;
	public static net.minecraft.client.network.ClientPlayerEntity ClientPlayer;
	public static boolean on;


	public static final Logger LOGGER = LoggerFactory.getLogger("autofish");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution
		mc = MinecraftClient.getInstance();
		Commands.coms();
	}

}

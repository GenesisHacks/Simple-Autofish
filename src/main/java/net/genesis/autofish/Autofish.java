package net.genesis.autofish;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Autofish implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static KeyBinding vkeyBinding;
	public static boolean on;


	public static final Logger LOGGER = LoggerFactory.getLogger("autofish");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution

		vkeyBinding = new KeyBinding("On/Off Toggle", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_V, "Autofish");
		KeyBindingHelper.registerKeyBinding(vkeyBinding);

	}
}

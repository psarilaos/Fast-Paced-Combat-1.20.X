package net.opsarilaos.fastpacedcombat;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main common entrypoint of the mod, loaded on both physical client and dedicated server environments.
 * This class is where you initiate shared gameplay mechanics, such as registering blocks, items, and world generation.
 * (Source: Gemini)
 */
public class FastPacedCombat implements ModInitializer {
	public static final String MOD_ID = "fastpacedcombat";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/**
	 * Executed by Fabric during the early startup phase of both the client and dedicated server.
	 * This is where you should trigger your mod's registration systems and setup code.
	 * (Source: Gemini)
	 */
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// This is a test comment
		LOGGER.info("Initializing FastPacedCombat...");

		// This is where you will trigger your registration classes later
	}
}
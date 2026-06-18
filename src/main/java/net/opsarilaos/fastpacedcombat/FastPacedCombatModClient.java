package net.opsarilaos.fastpacedcombat;

import net.fabricmc.api.ClientModInitializer;

/**
 * The client-only entrypoint of the mod, executed exclusively on physical user machines.
 * It is completely ignored by dedicated servers, keeping them safe from loading client-only graphics and sound systems.
 * (Source: Gemini)
 */
public class FastPacedCombatModClient implements ClientModInitializer {

    /**
     * Executed by Fabric on start-up only when the physical client is loading.
     * Use this method safely to register keybindings, transparent block layers, particle effects, and screen layouts.
     * (Source: Gemini)
     */
    @Override
    public void onInitializeClient() {
        // Put client-only code here (e.g. keybindings or screen GUI registration)

    }
}

package net.opsarilaos.fastpacedcombat.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.opsarilaos.fastpacedcombat.FastPacedCombat;
import net.opsarilaos.fastpacedcombat.block.ModBlocks;

public class ModItems {

    // Use Item.Settings() for simple settings, use FabricItemSettings() for more settings provided by Fabric.
    // FabricItemSettings extends Item.Settings.
    public static final Item ARGENT = registerItem("argent",
            new Item(new FabricItemSettings().fireproof()));

    public static final Item REFINED_ARGENT_CELL = registerItem("refined_argent_cell",
            new Item(new FabricItemSettings().fireproof()));

    // static Item registerItem -> registers the Item by ID and returns it so that ARGENT (for example) can receive it
    private static Item registerItem(String name, Item item) {
        // A registry is an object that holds the mapping between the string ID, the numeric ID, and the registered value (source: Gemini).
        // Registry.register arguments:
        // arg1: The type of the register (Is it an Item specialized registry or a Block specialized registry?)
        // arg2: A new Identifier "MOD_ID:Name" (This is what we look up when doing /give in game)
        // arg3 object to register
        return Registry.register(Registries.ITEM, new Identifier(FastPacedCombat.MOD_ID, name), item);
    }

    // The core of this class. Handles the registrations.
    public static void registerModItems() {
        FastPacedCombat.LOGGER.info("Registering FastPacedCombat items for " + FastPacedCombat.MOD_ID);

        // Scary line breakdown (unprofessional comment but I don't care):
        // ItemGroups class - Each creative inventory tab like Ingredients or Redstone.
        // ItemGroupEvents class - contains every possible event that has to do with ItemGroups.
        // ItemGroupEvents.modifyEntriesEvent(Registry key) - the event which takes place when the time comes to
        // build the modded inventory (we don't care when it is done. We refer to a specific itemGroup by passing its
        // registry key.
        // modifyEntriesEvent(...).register(...) - IN THIS CONTEXT register means we register a listener method to the
        // modifyEntries event - when modifyEntries happens, itemGroupIngredients takes place.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::itemGroupNatural);
    }

    // Method which collects our custom Items and adds them to existing ItemGroups (Ingredients in this case)
    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(ARGENT);
        entries.add(REFINED_ARGENT_CELL);
    }

    private static void itemGroupNatural(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.ARGENT_ORE);
    }
}

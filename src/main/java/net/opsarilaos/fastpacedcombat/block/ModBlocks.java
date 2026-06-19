package net.opsarilaos.fastpacedcombat.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.opsarilaos.fastpacedcombat.FastPacedCombat;


// A Minecraft "block" consists of an actual block (the physical block that is placed in the world), and its item
// version, the one that is seen in our inventory. This in-between stage is called an "BlockItem", and it differs from
// the traditional Item, because a BlockItem will be placed when the player right clicks while holding it (with a few
// exceptions). Therefore, two registers are required. The one that registers our block as a BlockItem, and another one,
// that registers our block as a Block.
public class ModBlocks {

    public static final Block ARGENT_ORE = registerBlock("argent_ore", new Block(
            FabricBlockSettings.create()
                    .hardness(4.0f)
                    .luminance(8)
    ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FastPacedCombat.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FastPacedCombat.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()
                        .fireproof()
                ));
    }

    public static void registerModBlocks() {
        FastPacedCombat.LOGGER.info("Registering FastPacedCombat blocks for " + FastPacedCombat.MOD_ID);
    }
}

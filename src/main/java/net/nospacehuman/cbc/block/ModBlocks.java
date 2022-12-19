package net.nospacehuman.cbc.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.nospacehuman.cbc.CouldBeCursedMod;

public class ModBlocks {

    public static final Block TOTALITARIANITE_SHRAPNEL_MATRIX = registerBlock("totalitarianite_shrapnel_matrix",
            new Block(FabricBlockSettings.of(Material.METAL).strength(45f, 0.5f).requiresTool().sounds(
                    BlockSoundGroup.GLASS).slipperiness(0.5f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block TOTALITARIANITE_BLOCK = registerBlock("totalitarianite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(85f, 1200f).requiresTool().sounds(
                    BlockSoundGroup.GLASS).slipperiness(0.75f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block TOTALITARIANITE_ORE = registerBlock("totalitarianite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(15f, 15f).requiresTool().sounds(
                    BlockSoundGroup.STONE).slipperiness(0.75f), UniformIntProvider.create(10, 12)), ItemGroup.BUILDING_BLOCKS);
    public static final Block DEEPSLATE_TOTALITARIANITE_ORE = registerBlock("deepslate_totalitarianite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(17f, 15f).requiresTool().sounds(
                    BlockSoundGroup.STONE).slipperiness(0.75f), UniformIntProvider.create(10, 12)), ItemGroup.BUILDING_BLOCKS);
    public static final Block NETHER_TOTALITARIANITE_ORE = registerBlock("nether_totalitarianite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(5f, 5f).requiresTool().sounds(
                    BlockSoundGroup.STONE).slipperiness(0.75f), UniformIntProvider.create(10, 12)), ItemGroup.BUILDING_BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup itemGroup) {
        registerBlockItem(name, block, itemGroup);
        return Registry.register(Registry.BLOCK, new Identifier(CouldBeCursedMod.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block, ItemGroup itemGroup) {
        return Registry.register(Registry.ITEM, new Identifier(CouldBeCursedMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(itemGroup)));
    }


    public static void registerModBlocks() {
        CouldBeCursedMod.LOGGER.info("registering blocks for " + CouldBeCursedMod.MOD_REGISTRY_NAME);
    }

}

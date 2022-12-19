package net.nospacehuman.cbc.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nospacehuman.cbc.CouldBeCursedMod;

public class ModItems {

    public static final Item TOTALITARIANITE_INGOT = registerItem("totalitarianite_ingot", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item TOTALITARIANITE_NUGGET = registerItem("totalitarianite_nugget", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item TOTALITARIANITE_SHRAPNEL = registerItem("totalitarianite_shrapnel",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS).fireproof().rarity(Rarity.RARE).food(new FoodComponent.Builder().statusEffect(
                    new StatusEffectInstance(StatusEffects.GLOWING,20*99999, 255, false, false, false), 1f).statusEffect(
                    new StatusEffectInstance(StatusEffects.NAUSEA,20*99999, 255, false, false, false), 1f).statusEffect(
                    new StatusEffectInstance(StatusEffects.POISON,20*99999, 255, false, false, false), 1f).statusEffect(
                    new StatusEffectInstance(StatusEffects.WEAKNESS,20*99999, 255, false, false, false), 1f).statusEffect(
                    new StatusEffectInstance(StatusEffects.HUNGER,20*99999, 255, false, false, false), 1f).statusEffect(
                    new StatusEffectInstance(StatusEffects.HASTE,20*99999, 255, false, false, false), 1f).snack().build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CouldBeCursedMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CouldBeCursedMod.LOGGER.info("registering items for " + CouldBeCursedMod.MOD_REGISTRY_NAME);
    }
}

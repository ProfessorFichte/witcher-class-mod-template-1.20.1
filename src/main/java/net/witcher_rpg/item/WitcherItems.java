package net.witcher_rpg.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.item.armor.Armors;
import net.witcher_rpg.item.weapon.WeaponsRegister;
import net.spell_engine.api.item.trinket.SpellBooks;

import java.util.HashMap;

public class WitcherItems {

    public static final HashMap<String, Item> entries;
    static {
        entries = new HashMap<>();
        for(var weaponEntry: WeaponsRegister.entries) {
            entries.put(weaponEntry.id().toString(), weaponEntry.item());
        }
        for(var entry: Armors.entries) {
            var set = entry.armorSet();
            for (var piece: set.pieces()) {
                var armorItem = (ArmorItem) piece;
                entries.put(set.idOf(armorItem).toString(), armorItem);
            }
        }
    }

    //Custom Loot
    public static Item SILVER_INGOT  = new Item(new FabricItemSettings().maxCount(64));
    public static Item METEORITE_SILVER_INGOT = new Item(new FabricItemSettings().maxCount(64));
    public static Item DARK_STEEL_INGOT= new Item(new FabricItemSettings().maxCount(64));
    public static Item STEEL_INGOT= new Item(new FabricItemSettings().maxCount(64));
    public static Item RAW_SILVER = new Item(new FabricItemSettings().maxCount(64));
    public static Item METEORITE = new Item(new FabricItemSettings().maxCount(64));
    public static Item METEORITE_INGOT = new Item(new FabricItemSettings().maxCount(64));
    public static Item DARK_IRON_INGOT = new Item(new FabricItemSettings().maxCount(64));
    public static Item RAW_DARK_IRON = new Item(new FabricItemSettings().maxCount(64));

    public static void registerModItems(){
        SpellBooks.createAndRegister(new Identifier(WitcherClassMod.MOD_ID,"witcher_signs"), WitcherGroup.WITCHER_KEY);
        SpellBooks.createAndRegister(new Identifier(WitcherClassMod.MOD_ID,"witcher_combat"), WitcherGroup.WITCHER_KEY);


        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"silver_ingot"),SILVER_INGOT);
        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"meteorite_silver_ingot"),METEORITE_SILVER_INGOT);
        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"raw_silver"),RAW_SILVER );
        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"steel_ingot"),STEEL_INGOT);
        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"dark_steel_ingot"),DARK_STEEL_INGOT);
        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"meteorite"),METEORITE );
        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"meteorite_ingot"),METEORITE_INGOT);
        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"dark_iron_ingot"),DARK_IRON_INGOT);
        Registry.register(Registries.ITEM,new Identifier(WitcherClassMod.MOD_ID,"raw_dark_iron"),RAW_DARK_IRON);

        ItemGroupEvents.modifyEntriesEvent(WitcherGroup.WITCHER_KEY).register((content) -> {
            content.add(RAW_SILVER);
            content.add(RAW_DARK_IRON);
            content.add(METEORITE);
            content.add(SILVER_INGOT);
            content.add(METEORITE_SILVER_INGOT);
            content.add(STEEL_INGOT);
            content.add(METEORITE_INGOT);
            content.add(DARK_IRON_INGOT);
            content.add(DARK_STEEL_INGOT);
        });

        WitcherClassMod.LOGGER.info("Registering Mod Items for " + WitcherClassMod.MOD_ID);
    }
}

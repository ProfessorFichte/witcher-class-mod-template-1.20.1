package net.witcher_rpg.item.weapon;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.weapon.Weapon;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.item.WitcherGroup;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Supplier;

public class WeaponsRegister {
    public static final ArrayList<Weapon.Entry> entries = new ArrayList<>();

    private static Weapon.Entry entry(String name, Weapon.CustomMaterial material, Item item, ItemConfig.Weapon defaults) {
        return entry(null, name, material, item, defaults);
    }

    private static Weapon.Entry entry(String requiredMod, String name, Weapon.CustomMaterial material, Item item, ItemConfig.Weapon defaults) {
        var entry = new Weapon.Entry(WitcherClassMod.MOD_ID, name, material, item, defaults, null);
        if (entry.isRequiredModInstalled()) {
            entries.add(entry);
        }
        return entry;
    }

    private static Supplier<Ingredient> ingredient(String idString) {
        return ingredient(idString, Items.DIAMOND);
    }

    private static Supplier<Ingredient> ingredient(String idString, Item fallback) {
        var id = new Identifier(idString);
        return () -> {
            var item = Registries.ITEM.get(id);
            var ingredient = item != null ? item : fallback;
            return Ingredient.ofItems(ingredient);
        };
    }

    public static float witcher_sword_attackSpeed = -2.4f;

    // BASE_WITCHER-SWORDS
    private static Weapon.Entry witcherswords(String name, Weapon.CustomMaterial material, float damage,float sign, float adrenaline) {
        return witcherswords(null, name, material, damage, sign,adrenaline);}
    private static Weapon.Entry witcherswords(String requiredMod, String name, Weapon.CustomMaterial material, float damage, float sign, float adrenaline) {
        var settings = new Item.Settings();
        var item = new WitcherSword(material, damage,witcher_sword_attackSpeed,sign,adrenaline,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    private static Weapon.Entry witcher_silver_sword(String name, Weapon.CustomMaterial material, float damage,float sign, float adrenaline) {
        return witcher_silver_sword(null, name, material, damage, sign,adrenaline);
    }
    private static Weapon.Entry witcher_silver_sword(String requiredMod, String name, Weapon.CustomMaterial material, float damage, float sign, float adrenaline) {
        var settings = new Item.Settings();
        var item = new WitcherSilverSwordItem(material, damage,witcher_sword_attackSpeed,sign,adrenaline,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    private static Weapon.Entry witcher_steel_sword(String name, Weapon.CustomMaterial material, float damage,float sign, float adrenaline) {
        return witcher_steel_sword(null, name, material, damage, sign,adrenaline);}
    private static Weapon.Entry witcher_steel_sword(String requiredMod, String name, Weapon.CustomMaterial material, float damage, float sign, float adrenaline) {
        var settings = new Item.Settings();
        var item = new WitcherSteelSwordItem(material, damage, witcher_sword_attackSpeed,sign,adrenaline,settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    private static Weapon.Entry aerondight(String name, Weapon.CustomMaterial material, float damage) {
        return aerondight(null, name, material, damage);}
    private static Weapon.Entry aerondight(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new AerondightRelictItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    private static Weapon.Entry ultimatum(String name, Weapon.CustomMaterial material, float damage) {
        return ultimatum(null, name, material, damage);}
    private static Weapon.Entry ultimatum(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new UltimatumRelicItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    private static Weapon.Entry winters_blade(String name, Weapon.CustomMaterial material, float damage) {
        return winters_blade(null, name, material, damage);}
    private static Weapon.Entry winters_blade(String requiredMod, String name, Weapon.CustomMaterial material, float damage) {
        var settings = new Item.Settings();
        var item = new WintersBladeRelicItem(material, settings);
        return entry(requiredMod, name, material, item, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed));
    }

    public static final Weapon.Entry iron_witcher_sword = witcherswords("iron_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(Items.IRON_INGOT)), 4.0F,0.5F,0.01F)
            ;
    public static final Weapon.Entry golden_witcher_sword = witcherswords("golden_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.GOLD, () -> Ingredient.ofItems(Items.GOLD_INGOT)), 2.0F,0.5F,0.01F)
            ;
    public static final Weapon.Entry diamond_witcher_sword = witcherswords("diamond_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.DIAMOND)), 5.0F,1.0F,0.02F)
            ;
    public static final Weapon.Entry netherite_witcher_sword = witcherswords("netherite_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)), 6.0F,2.5F,0.05F)
            ;
    public static final Weapon.Entry steel_witcher_sword = witcher_steel_sword("steel_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, ingredient("witcher_rpg:steel_ingot")), 4.5F,0,0.02F)
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, 0.01F))
            ;
    public static final Weapon.Entry dark_iron_witcher_sword = witcher_steel_sword("dark_iron_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, ingredient("witcher_rpg:steel_ingot")), 5.5F,0,0.04F)
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, 0.02F))
            ;
    public static final Weapon.Entry dark_steel_witcher_sword = witcher_steel_sword("dark_steel_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, ingredient("witcher_rpg:dark_steel_ingot")), 6.5F,1.5F,0.075F)
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, 0.04F))
            ;
    public static final Weapon.Entry witcher_silver_sword = witcher_silver_sword("silver_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, ingredient("witcher_rpg:silver_ingot")), 2.2F,1.5F,0)
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, 0.01F))
            ;
    public static final Weapon.Entry witcher_meteorite_sword = witcher_silver_sword("meteorite_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, ingredient("witcher_rpg:meteorite_ingot")), 3.2F,3,0)
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, 0.02F))
            ;
    public static final Weapon.Entry witcher_meteorite_silver_sword = witcher_silver_sword("meteorite_silver_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, ingredient("witcher_rpg:meteorite_silver_ingot")), 4.2F,5,0.02F)
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, 0.03F))
            ;
public static final Weapon.Entry aerondight = aerondight("aerondight_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, ingredient("witcher_rpg:meteorite_silver_ingot")), 7.5F);
public static final Weapon.Entry ultimatum = ultimatum("ultimatum_sword",
        Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, ingredient("witcher_rpg:steel_ingot")), 5.5F)
        .attribute(ItemConfig.Attribute.bonus(SpellSchools.FIRE.id, 3))
        .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, 0.1F))
        .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_CHANCE.id, 0.03F));
        ;
    public static final Weapon.Entry winters_blade = winters_blade("winters_blade_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, ingredient("witcher_rpg:steel_ingot")), 5.5F)
            .attribute(ItemConfig.Attribute.bonus(SpellSchools.FROST.id, 3))
            .attribute(ItemConfig.Attribute.bonus(SpellSchools.LIGHTNING.id, 3))
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, 0.15F))
            ;


    //Registration
    public static void register(Map<String, ItemConfig.Weapon> configs) {
        Weapon.register(configs, entries, WitcherGroup.WITCHER_KEY);
    }
}

package net.witcher_rpg.item.weapon;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.weapon.Weapon;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;

import net.witcher_rpg.item.WitcherGroup;
import net.witcher_rpg.item.WitcherItems;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class WeaponsRegister {
    public static final ArrayList<Weapon.Entry> entries = new ArrayList<>();
    private static Weapon.Entry entry(String name, Weapon.CustomMaterial material, Weapon.Factory factory, ItemConfig.Weapon defaults, boolean fireproof) {
        return entry(null, name, material, factory, defaults, fireproof);
    }

    private static Weapon.Entry entry(String requiredMod, String name, Weapon.CustomMaterial material, Weapon.Factory factory, ItemConfig.Weapon defaults, boolean fireproof) {
        var entry = new Weapon.Entry(MOD_ID, name, material, factory, defaults, requiredMod);
        if (entry.isRequiredModInstalled()) {
            entries.add(entry);
        }
        return entry;
    }


    private static Supplier<Ingredient> ingredient(String idString, boolean requirement, Item fallback) {
        var id = Identifier.of(idString);
        if (requirement) {
            return () -> {
                return Ingredient.ofItems(fallback);
            };
        } else {
            return () -> {
                var item = Registries.ITEM.get(id);
                var ingredient = item != null ? item : fallback;
                return Ingredient.ofItems(ingredient);
            };
        }
    }

    public static float witcher_sword_attackSpeed = -2.4f;

    private static Weapon.Entry witcherswords(String requiredMod, String name, Weapon.CustomMaterial material, float damage, boolean fireproof) {
        return entry(name, material, WitcherSword::new, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed), fireproof);
    }
    private static Weapon.Entry witcher_silver_sword(String requiredMod, String name, Weapon.CustomMaterial material, float damage, boolean fireproof) {
        return entry(name, material, WitcherSilverSwordItem::new, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed), fireproof);
    }
    private static Weapon.Entry witcher_steel_sword(String requiredMod, String name, Weapon.CustomMaterial material, float damage, boolean fireproof) {
        return entry(name, material, WitcherSteelSwordItem::new, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed), fireproof);
    }
    private static Weapon.Entry aerondight(String requiredMod, String name, Weapon.CustomMaterial material, float damage, boolean fireproof) {
        return entry(name, material, AerondightRelictItem::new, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed), fireproof);
    }
    private static Weapon.Entry ultimatum(String requiredMod, String name, Weapon.CustomMaterial material, float damage, boolean fireproof) {
        return entry(name, material, UltimatumRelicItem::new, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed), fireproof);
    }
    private static Weapon.Entry winters_blade(String requiredMod, String name, Weapon.CustomMaterial material, float damage, boolean fireproof) {
        return entry(name, material, WintersBladeRelicItem::new, new ItemConfig.Weapon(damage, witcher_sword_attackSpeed), fireproof);
    }

    public static final Weapon.Entry iron_witcher_sword = witcherswords("","iron_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(Items.IRON_INGOT)), 4.0F, false)
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),0.5F))
            .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.02F))
            ;
    public static final Weapon.Entry golden_witcher_sword = witcherswords("","golden_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.GOLD, () -> Ingredient.ofItems(Items.GOLD_INGOT)), 2.0F, false)
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),0.5F))
            .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.02F))
            ;
    public static final Weapon.Entry diamond_witcher_sword = witcherswords("","diamond_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(Items.DIAMOND)), 5.0F, false)
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),1.0F))
            .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.035F))
            ;
    public static final Weapon.Entry netherite_witcher_sword = witcherswords("","netherite_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)), 6.0F, true)
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),2.5F))
            .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.06F))
            ;
    public static final Weapon.Entry steel_witcher_sword = witcher_steel_sword("","steel_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(WitcherItems.STEEL_INGOT)), 4.5F,false)
            .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.035F))
            ;
    public static final Weapon.Entry dark_iron_witcher_sword = witcher_steel_sword("","dark_iron_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(WitcherItems.DARK_IRON_INGOT)), 5.0F,false)
            .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.065F))
            ;
    public static final Weapon.Entry dark_steel_witcher_sword = witcher_steel_sword("","dark_steel_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(WitcherItems.DARK_STEEL_INGOT)), 6.0F,true)
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:aard_intensity")),1.5F))
            .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.1F))
            ;
    public static final Weapon.Entry witcher_silver_sword = witcher_silver_sword("","silver_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.IRON, () -> Ingredient.ofItems(WitcherItems.SILVER_INGOT)), 4.5F,false)
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),1.5F))
            ;
    public static final Weapon.Entry witcher_meteorite_sword = witcher_silver_sword("","meteorite_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(WitcherItems.METEORITE_INGOT)), 4.5F, false)
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),3.0F))
            ;
    public static final Weapon.Entry witcher_meteorite_silver_sword = witcher_silver_sword("","meteorite_silver_witcher_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, () -> Ingredient.ofItems(WitcherItems.METEORITE_SILVER_INGOT)), 5.0F,true)
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),5.0F))
            .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.04F))
            ;
public static final Weapon.Entry aerondight = aerondight("","aerondight_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE,() -> Ingredient.ofItems(WitcherItems.METEORITE_SILVER_INGOT)), 10.5F, true);
public static final Weapon.Entry ultimatum = ultimatum("","ultimatum_sword",
        Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(WitcherItems.STEEL_INGOT)), 5.5F,true)
        .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, 0.1F))
        .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.075F))
        .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:igni_intensity")),3.5F))
        ;

    public static final Weapon.Entry winters_blade = winters_blade("","winters_blade_sword",
            Weapon.CustomMaterial.matching(ToolMaterials.DIAMOND, () -> Ingredient.ofItems(WitcherItems.STEEL_INGOT)), 5.5F,true)
            .attribute(ItemConfig.Attribute.bonus(SpellSchools.FROST.id, 3))
            .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:aard_intensity")),3.5F))
            .attribute(ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, 0.15F))
            ;


    private static final String BETTER_END = "betterend";
    private static final String BETTER_NETHER = "betternether";
    //Registration
    public static void register(Map<String, ItemConfig.Weapon> configs) {
        if(FabricLoader.getInstance().isModLoaded(BETTER_NETHER)){
            var repair = ingredient("betternether:nether_ruby", FabricLoader.getInstance().isModLoaded(BETTER_NETHER), Items.NETHERITE_INGOT);
            witcherswords("betternether", "ruby_witcher_sword",
                    Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, repair),7.0F, true)
                    .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),3.5F))
                    .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.08F));

        }
        if(FabricLoader.getInstance().isModLoaded(BETTER_END)){
            var repair = ingredient("betterend:aeternium_ingot", FabricLoader.getInstance().isModLoaded(BETTER_NETHER), Items.NETHERITE_INGOT);
            witcherswords("betterend", "aeternium_witcher_sword",
                    Weapon.CustomMaterial.matching(ToolMaterials.NETHERITE, repair),7.0F, true)
                    .attribute(ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),3.5F))
                    .attribute(ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),0.08F));
        }
        Weapon.register(configs, entries, WitcherGroup.WITCHER_KEY);
    }
}

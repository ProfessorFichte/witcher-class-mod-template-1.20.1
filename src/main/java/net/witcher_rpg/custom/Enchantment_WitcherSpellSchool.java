package net.witcher_rpg.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.spell_power.api.enchantment.EnchantmentRestriction;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.config.EnchantingConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static net.minecraft.enchantment.EnchantmentTarget.BREAKABLE;
import static net.spell_power.internals.AmplifierEnchantment.Operation.ADD;
import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class Enchantment_WitcherSpellSchool {
    public static final String signName = "signs";
    public static final Identifier signs = new Identifier(MOD_ID, signName);
    public static final WitcherSchoolEnchanting SIGNS = new WitcherSchoolEnchanting(
            Enchantment.Rarity.COMMON,
            ADD,
            config().sign_intensity,
            Set.of(WitcherSpellSchools.SIGN, WitcherSpellSchools.AARD,WitcherSpellSchools.AXII,WitcherSpellSchools.IGNI,WitcherSpellSchools.QUEN,WitcherSpellSchools.YRDEN),
            BREAKABLE,
            EquipmentSlot.values())
            .requireTag(new Identifier(WitcherClassMod.MOD_ID, "enchant_sign_intensity"));


    private static EnchantingConfig config() {
        return (EnchantingConfig) WitcherClassMod.enchantmentConfig.value;
    }


    public static final Map<Identifier, WitcherSchoolEnchanting> all;
    static {
        all = new HashMap<>();
        all.put(signs, SIGNS);

        for(var entry: all.entrySet()) {
            var enchantment = entry.getValue();
            EnchantmentRestriction.prohibit(enchantment, itemStack -> {
                var typeMatches = enchantment.matchesRequiredTag(itemStack);
                var schoolMatches = !enchantment.requiresRelatedAttributes() || WitcherSchoolEnchanting.schoolsIntersect(enchantment.poweredSchools(), itemStack);
                return !typeMatches || !schoolMatches;
            });
        }
    }
}

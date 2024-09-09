package net.witcher_rpg.custom;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.util.Identifier;
import net.spell_power.SpellPowerMod;
import net.spell_power.api.SpellSchool;
import net.spell_power.api.SpellSchools;
import net.spell_power.api.enchantment.Enchantments_SpellPower;
import net.witcher_rpg.entity.attribute.WitcherAttributes;

import static net.spell_power.api.SpellPowerMechanics.PERCENT_ATTRIBUTE_BASELINE;

public class WitcherSpellSchools {
    public static final SpellSchool SIGN = new SpellSchool(SpellSchool.Archetype.MAGIC,
            new Identifier(SpellPowerMod.ID, "sign"),
            0xfffeca,
            DamageTypes.MAGIC,
            WitcherAttributes.SIGN_INTENSITY);
    public static final SpellSchool AARD = new SpellSchool(SpellSchool.Archetype.MAGIC,
            new Identifier(SpellPowerMod.ID, "aard"),
            0x3beeff,
            DamageTypes.MAGIC,
            WitcherAttributes.AARD_INTENSITY);
    public static final SpellSchool AXII = new SpellSchool(SpellSchool.Archetype.MAGIC,
            new Identifier(SpellPowerMod.ID, "axii"),
            0x008000,
            DamageTypes.MAGIC,
            WitcherAttributes.AXII_INTENSITY);
    public static final SpellSchool IGNI = new SpellSchool(SpellSchool.Archetype.MAGIC,
            new Identifier(SpellPowerMod.ID, "igni"),
            0xdd4e00,
            DamageTypes.MAGIC,
            WitcherAttributes.IGNI_INTENSITY);
    public static final SpellSchool QUEN= new SpellSchool(SpellSchool.Archetype.MAGIC,
            new Identifier(SpellPowerMod.ID, "quen"),
            0xfffeca,
            DamageTypes.MAGIC,
            WitcherAttributes.QUEN_INTENSITY);
    public static final SpellSchool YRDEN= new SpellSchool(SpellSchool.Archetype.MAGIC,
            new Identifier(SpellPowerMod.ID, "yrden"),
            0xe717fe,
            DamageTypes.MAGIC,
            WitcherAttributes.YRDEN_INTENSITY);


    public static void initialize() {
        ///GENERAL SIGN
        SIGN.attributeManagement = SpellSchool.Manage.EXTERNAL;
        SIGN.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var enchantment = Enchantments_SpellPower.SPELL_POWER;
            var power = query.entity().getAttributeValue(WitcherSpellSchools.SIGN.attribute);
            var level = EnchantmentHelper.getLevel(enchantment, query.entity().getMainHandStack());
            power *= 1 + (0.05 * level);
            return power;
        });
        SIGN.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;  // 0.1
        });
        SpellSchools.configureSpellCritChance(SIGN);
        SpellSchools.register(SIGN);
        ///AARD
        AARD.attributeManagement = SpellSchool.Manage.EXTERNAL;
        AARD.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var enchantment = Enchantments_SpellPower.SPELL_POWER;
            var power = query.entity().getAttributeValue(WitcherSpellSchools.AARD.attribute);
            var power2 = query.entity().getAttributeValue(SpellSchools.LIGHTNING.attribute);
            var level = EnchantmentHelper.getLevel(enchantment, query.entity().getMainHandStack());
            power *= power2 + 1 + (0.05 * level);
            return power;
        });
        AARD.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;  // 0.1
        });
        SpellSchools.configureSpellCritDamage(AARD);
        SpellSchools.configureSpellCritChance(AARD);
        SpellSchools.configureSpellHaste(AARD);
        SpellSchools.register(AARD);
        ///AXII
        AXII.attributeManagement = SpellSchool.Manage.EXTERNAL;
        AXII.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var enchantment = Enchantments_SpellPower.SPELL_POWER;
            var power = query.entity().getAttributeValue(WitcherSpellSchools.AXII.attribute);
            var power2 = query.entity().getAttributeValue(SpellSchools.SOUL.attribute);
            var level = EnchantmentHelper.getLevel(enchantment, query.entity().getMainHandStack());
            power *= power2 + 1 + (0.05 * level);
            return power;
        });
        AXII.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;  // 0.1
        });
        SpellSchools.configureSpellCritDamage(AXII);
        SpellSchools.configureSpellCritChance(AXII);
        SpellSchools.configureSpellHaste(AXII);
        SpellSchools.register(AXII);
        ///IGNI
        IGNI.attributeManagement = SpellSchool.Manage.EXTERNAL;
        IGNI.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var enchantment = Enchantments_SpellPower.SPELL_POWER;
            var power = query.entity().getAttributeValue(WitcherSpellSchools.IGNI.attribute);
            var power2 = query.entity().getAttributeValue(SpellSchools.FIRE.attribute);
            var level = EnchantmentHelper.getLevel(enchantment, query.entity().getMainHandStack());
            power *= power2 + 1 + (0.05 * level);
            return power;
        });
        IGNI.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;  // 0.1
        });
        SpellSchools.configureSpellCritChance(IGNI);
        SpellSchools.register(IGNI);
        ///QUEN
        QUEN.attributeManagement = SpellSchool.Manage.EXTERNAL;
        QUEN.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var enchantment = Enchantments_SpellPower.SPELL_POWER;
            var power = query.entity().getAttributeValue(WitcherSpellSchools.SIGN.attribute);
            var power2 = query.entity().getAttributeValue(SpellSchools.LIGHTNING.attribute);
            var level = EnchantmentHelper.getLevel(enchantment, query.entity().getMainHandStack());
            power *= power2 + 1 + (0.05 * level);
            return power;
        });
        QUEN.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;  // 0.1
        });
        SpellSchools.configureSpellCritChance(QUEN);
        SpellSchools.register(QUEN);
        ///YRDEN
        YRDEN.attributeManagement = SpellSchool.Manage.EXTERNAL;
        YRDEN.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var enchantment = Enchantments_SpellPower.SPELL_POWER;
            var power = query.entity().getAttributeValue(WitcherSpellSchools.YRDEN.attribute);
            var power2 = query.entity().getAttributeValue(SpellSchools.ARCANE.attribute);
            var level = EnchantmentHelper.getLevel(enchantment, query.entity().getMainHandStack());
            power *= power2 + 1 + (0.05 * level);
            return power;
        });
        YRDEN.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;
        });
        SpellSchools.configureSpellCritChance(YRDEN);
        SpellSchools.register(YRDEN);

    }
}

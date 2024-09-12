package net.witcher_rpg.custom;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.spell_power.SpellPowerMod;
import net.spell_power.api.SpellSchool;
import net.spell_power.api.SpellSchools;
import net.witcher_rpg.entity.attribute.WitcherAttributes;

import static net.spell_power.api.SpellPowerMechanics.PERCENT_ATTRIBUTE_BASELINE;

public class WitcherSpellSchools {
    public static final SpellSchool SIGN = new SpellSchool(SpellSchool.Archetype.MAGIC,
            Identifier.of(SpellPowerMod.ID, "sign"),
            0xfffeca,
            DamageTypes.MAGIC,
            WitcherAttributes.SIGN_INTENSITY);
    public static final SpellSchool AARD = new SpellSchool(SpellSchool.Archetype.MAGIC,
            Identifier.of(SpellPowerMod.ID, "aard"),
            0x3beeff,
            DamageTypes.MAGIC,
            WitcherAttributes.AARD_INTENSITY);
    public static final SpellSchool AXII = new SpellSchool(SpellSchool.Archetype.MAGIC,
            Identifier.of(SpellPowerMod.ID, "axii"),
            0x008000,
            DamageTypes.MAGIC,
            WitcherAttributes.AXII_INTENSITY);
    public static final SpellSchool IGNI = new SpellSchool(SpellSchool.Archetype.MAGIC,
            Identifier.of(SpellPowerMod.ID, "igni"),
            0xdd4e00,
            DamageTypes.MAGIC,
            WitcherAttributes.IGNI_INTENSITY);
    public static final SpellSchool QUEN= new SpellSchool(SpellSchool.Archetype.MAGIC,
            Identifier.of(SpellPowerMod.ID, "quen"),
            0xfffeca,
            DamageTypes.MAGIC,
            WitcherAttributes.QUEN_INTENSITY);
    public static final SpellSchool YRDEN= new SpellSchool(SpellSchool.Archetype.MAGIC,
            Identifier.of(SpellPowerMod.ID, "yrden"),
            0xe717fe,
            DamageTypes.MAGIC,
            WitcherAttributes.YRDEN_INTENSITY);


    public static void initialize() {

        SIGN.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var power = query.entity().getAttributeValue(WitcherAttributes.SIGN_INTENSITY);
            var world = query.entity().getWorld();
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
        AARD.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var power = query.entity().getAttributeValue(WitcherSpellSchools.AARD.attributeEntry);
            var power2 = query.entity().getAttributeValue(SpellSchools.LIGHTNING.attributeEntry);
            power *= power2 + 1 ;
            return power;
        });
        AARD.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;  // 0.1
        });
        SpellSchools.configureSpellCritChance(AARD);
        SpellSchools.register(AARD);
        ///AXII
        AXII.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var power = query.entity().getAttributeValue(WitcherSpellSchools.AXII.attributeEntry);
            var power2 = query.entity().getAttributeValue(SpellSchools.SOUL.attributeEntry);
            power *= power2 + 1 ;
            return power;
        });
        AXII.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;  // 0.1
        });
        SpellSchools.configureSpellCritChance(AXII);
        SpellSchools.register(AXII);
        ///IGNI
        IGNI.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var power = query.entity().getAttributeValue(WitcherSpellSchools.IGNI.attributeEntry);
            var power2 = query.entity().getAttributeValue(SpellSchools.FIRE.attributeEntry);
            power *= power2 + 1 ;
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
        QUEN.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var power = query.entity().getAttributeValue(WitcherSpellSchools.QUEN.attributeEntry);
            var power2 = query.entity().getAttributeValue(SpellSchools.LIGHTNING.attributeEntry);
            power *= power2 + 1 ;
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
        YRDEN.addSource(SpellSchool.Trait.POWER, SpellSchool.Apply.ADD, query -> {
            var power = query.entity().getAttributeValue(WitcherSpellSchools.YRDEN.attributeEntry);
            var power2 = query.entity().getAttributeValue(SpellSchools.ARCANE.attributeEntry);
            power *= power2 + 1 ;
            return power;
        });
        YRDEN.addSource(SpellSchool.Trait.CRIT_CHANCE, SpellSchool.Apply.ADD, query -> {
            var value = query.entity().getAttributeValue( WitcherAttributes.ADRENALINE_MODIFIER);
            var rate = (value / PERCENT_ATTRIBUTE_BASELINE);
            return rate - 1;  // 0.1
        });
        SpellSchools.configureSpellCritChance(YRDEN);
        SpellSchools.register(YRDEN);

    }
}

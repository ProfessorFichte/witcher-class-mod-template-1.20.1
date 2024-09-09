package net.witcher_rpg.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.effect.*;
import net.spell_power.api.SpellPowerMechanics;
import net.witcher_rpg.entity.attribute.WitcherAttributes;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;
import static net.witcher_rpg.WitcherClassMod.effectsConfig;

public class Effects {
    public static StatusEffect AARD_INTENSITY = new CustomEffect(StatusEffectCategory.BENEFICIAL, 0x3beeff);
    public static StatusEffect AXII= new CustomEffect(StatusEffectCategory.HARMFUL, 0x008000);
    public static StatusEffect AXII_INTENSITY = new CustomEffect(StatusEffectCategory.BENEFICIAL, 0x008000);
    public static StatusEffect AXII_PUPPET = new AxiiPuppetEffect(StatusEffectCategory.HARMFUL, 0x008000);
    public static StatusEffect IGNI_INTENSITY = new CustomEffect(StatusEffectCategory.BENEFICIAL, 0xdd4e00);
    public static StatusEffect QUEN_EXPLODE = new QuenEffect(StatusEffectCategory.BENEFICIAL, 0xfffeca);
    public static StatusEffect QUEN_SHIELD= new QuenEffect(StatusEffectCategory.BENEFICIAL, 0xfffeca);
    public static StatusEffect QUEN_ACTIVE = new QuenActiveEffect(StatusEffectCategory.BENEFICIAL, 0xfffeca);
    public static StatusEffect QUEN_INTENSITY = new CustomEffect(StatusEffectCategory.BENEFICIAL, 0xfffeca);
    public static StatusEffect YRDEN_INTENSITY = new CustomEffect(StatusEffectCategory.BENEFICIAL, 0xe717fe);
    public static StatusEffect YRDEN_CIRCLE = new YrdenCircleEffect(StatusEffectCategory.HARMFUL, 0xe717fe);
    public static StatusEffect YRDEN_GLYPH = new CustomEffect(StatusEffectCategory.HARMFUL, 0xe717fe);
    public static StatusEffect AERONDIGHT_CHARGE= new AerondightChargeEffect(StatusEffectCategory.BENEFICIAL, 0x6afecf);
    public static StatusEffect ADRENALINE_GAIN = new  CustomEffect(StatusEffectCategory.BENEFICIAL, 0xdd4e00);
    public static StatusEffect ALTERNATE_SIGN = new AlternateSignEffect(StatusEffectCategory.BENEFICIAL, 0xfffeca);
    public static StatusEffect BATTLE_TRANCE = new CustomEffect(StatusEffectCategory.BENEFICIAL, 0xb3b3b3);

    public static void register(){
        AERONDIGHT_CHARGE.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "d1843e0f-8a63-4c96-a854-9c9444981042",
                        effectsConfig.value.aerondight_attack_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
                .addAttributeModifier(SpellPowerMechanics.CRITICAL_CHANCE.attribute, "6e8a21f5-a47e-4663-876c-970f0e562369",
                        effectsConfig.value.aerondight_spell_crit_chance_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
                .addAttributeModifier(SpellPowerMechanics.CRITICAL_DAMAGE.attribute, "8424908e-0e3b-4bb0-bf1c-98bb9bc1e175",
                        effectsConfig.value.aerondight_spell_crit_damage_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        YRDEN_CIRCLE.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                effectsConfig.value.yrden_magical_trap_speed_reduction, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        YRDEN_GLYPH.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                effectsConfig.value.yrden_magical_trap_speed_reduction, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        ADRENALINE_GAIN.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "8df38693-8f24-4c8c-b346-75ab7e6cc1aa",
                effectsConfig.value.adrenaline_attack_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
                .addAttributeModifier(WitcherAttributes.SIGN_INTENSITY, "0f88e4e8-becb-437b-9beb-6ef08fda3b49",
                        effectsConfig.value.adrenaline_sign_intensity_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
                .addAttributeModifier(WitcherAttributes.ADRENALINE_MODIFIER,"355df58b-0a17-481f-b6f9-5fe2501ca6c8",
                effectsConfig.value.adrenaline_attribute_increase_per_stack,EntityAttributeModifier.Operation.MULTIPLY_BASE);
        QUEN_EXPLODE.addAttributeModifier(MRPGCEntityAttributes.DAMAGE_REFLECT_MODIFIER, "7c097c68-1e70-497f-88d7-b78cfa34cd0e",
                effectsConfig.value.quen_reflect_damage, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        AARD_INTENSITY.addAttributeModifier(WitcherAttributes.AARD_INTENSITY, "7f861ccb-7051-441a-8c35-d2362c3c24a2",
                effectsConfig.value.sign_school_intensity_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        AXII_INTENSITY.addAttributeModifier(WitcherAttributes.AXII_INTENSITY, "7f861ccb-7051-441a-8c35-d2362c3c24a2",
                effectsConfig.value.sign_school_intensity_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        IGNI_INTENSITY.addAttributeModifier(WitcherAttributes.IGNI_INTENSITY, "7f861ccb-7051-441a-8c35-d2362c3c24a2",
                effectsConfig.value.sign_school_intensity_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        QUEN_INTENSITY.addAttributeModifier(WitcherAttributes.QUEN_INTENSITY, "7f861ccb-7051-441a-8c35-d2362c3c24a2",
                effectsConfig.value.sign_school_intensity_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        YRDEN_INTENSITY.addAttributeModifier(WitcherAttributes.AXII_INTENSITY, "7f861ccb-7051-441a-8c35-d2362c3c24a2",
                effectsConfig.value.sign_school_intensity_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        AXII_PUPPET.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "8df38693-8f24-4c8c-b346-75ab7e6cc1aa",
                effectsConfig.value.axii_puppet_attack_damage_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE);
        BATTLE_TRANCE.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                effectsConfig.value.battle_trance_speed_increase, EntityAttributeModifier.Operation.MULTIPLY_BASE);


        Synchronized.configure(AERONDIGHT_CHARGE,true);
        Synchronized.configure(QUEN_SHIELD,true);
        Synchronized.configure(YRDEN_CIRCLE,true);
        Synchronized.configure(YRDEN_GLYPH,true);
        Synchronized.configure(AXII,true);
        Synchronized.configure(ADRENALINE_GAIN,true);
        Synchronized.configure(QUEN_EXPLODE,true);
        Synchronized.configure(AARD_INTENSITY,true);
        Synchronized.configure(AXII_INTENSITY,true);
        Synchronized.configure(IGNI_INTENSITY,true);
        Synchronized.configure(QUEN_INTENSITY,true);
        Synchronized.configure(YRDEN_INTENSITY,true);
        Synchronized.configure(ALTERNATE_SIGN,true);
        Synchronized.configure(QUEN_ACTIVE,true);
        Synchronized.configure(BATTLE_TRANCE,true);

        RemoveOnHit.configure(AXII, true);

        ActionImpairing.configure(AXII, EntityActionsAllowed.STUN);

        HealthImpacting.configureDamageTaken(AXII, effectsConfig.value.axii_damage_increase);


        int witcher_effectid = 4000;
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "aerondight_charge").toString(), AERONDIGHT_CHARGE);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "quen_shield").toString(), QUEN_SHIELD);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "axii").toString(), AXII);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "yrden_circle").toString(), YRDEN_CIRCLE);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "adrenaline_gain").toString(), ADRENALINE_GAIN);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "quen_explode").toString(), QUEN_EXPLODE);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "aard_intensity").toString(), AARD_INTENSITY);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "axii_intensity").toString(), AXII_INTENSITY);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "igni_intensity").toString(), IGNI_INTENSITY);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "quen_intensity").toString(), QUEN_INTENSITY);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "yrden_intensity").toString(), YRDEN_INTENSITY);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "alternate_sign").toString(), ALTERNATE_SIGN);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "quen_active").toString(), QUEN_ACTIVE);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "axii_puppet").toString(), AXII_PUPPET);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "yrden_glyph").toString(), YRDEN_GLYPH);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "battle_trance").toString(), BATTLE_TRANCE);
    }

}

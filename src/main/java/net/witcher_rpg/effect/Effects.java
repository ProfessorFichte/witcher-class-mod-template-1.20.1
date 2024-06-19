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

import static net.witcher_rpg.WitcherClassMod.MOD_ID;
import static net.witcher_rpg.WitcherClassMod.effectsConfig;

public class Effects {
    //AERONDIGHT_CHARGE
    public static StatusEffect AERONDIGHT_CHARGE= new AerondightChargeEffect(StatusEffectCategory.BENEFICIAL, 0x6afecf);
    //QUEN SHIELD
    public static StatusEffect QUEN_SHIELD= new QuenEffect(StatusEffectCategory.BENEFICIAL, 0x3beeff);
    //YRDEN MAGICAL TRAP
    public static StatusEffect MAGICAL_TRAP= new MagicalTrapEffect(StatusEffectCategory.HARMFUL, 0xe717fe);
    //AXII
    public static StatusEffect AXII= new AxiiEffect(StatusEffectCategory.HARMFUL, 0x008000);
    //ADRENALINE
    public static StatusEffect ADRENALINE_GAIN = new AdrenalineGainEffect(StatusEffectCategory.BENEFICIAL, 0xdd4e00);
    //QUEN EXPLODE
    public static StatusEffect QUEN_EXPLODE = new QuenEffect(StatusEffectCategory.BENEFICIAL, 0x01d9cf);

    public static void register(){
        AERONDIGHT_CHARGE.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "d1843e0f-8a63-4c96-a854-9c9444981042",
                        effectsConfig.value.aerondight_attack_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
                .addAttributeModifier(SpellPowerMechanics.CRITICAL_CHANCE.attribute, "6e8a21f5-a47e-4663-876c-970f0e562369",
                        effectsConfig.value.aerondight_spell_crit_chance_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
                .addAttributeModifier(SpellPowerMechanics.CRITICAL_DAMAGE.attribute, "8424908e-0e3b-4bb0-bf1c-98bb9bc1e175",
                        effectsConfig.value.aerondight_spell_crit_damage_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE);

        MAGICAL_TRAP.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "5e58808d-6042-45c6-bb4d-f5fcd82f485e",
                effectsConfig.value.magical_trap_speed_reduction, EntityAttributeModifier.Operation.MULTIPLY_BASE);

        ADRENALINE_GAIN.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "8df38693-8f24-4c8c-b346-75ab7e6cc1aa",
                effectsConfig.value.adrenaline_attack_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
                .addAttributeModifier(MRPGCEntityAttributes.SIGN_INTENSITY, "0f88e4e8-becb-437b-9beb-6ef08fda3b49",
                        effectsConfig.value.adrenaline_sign_intensity_increase_per_stack, EntityAttributeModifier.Operation.MULTIPLY_BASE)
                .addAttributeModifier(MRPGCEntityAttributes.ADRENALINE_MODIFIER,"355df58b-0a17-481f-b6f9-5fe2501ca6c8",
                effectsConfig.value.adrenaline_attribute_increase_per_stack,EntityAttributeModifier.Operation.MULTIPLY_BASE);

        QUEN_EXPLODE.addAttributeModifier(MRPGCEntityAttributes.DAMAGE_REFLECT_MODIFIER, "7c097c68-1e70-497f-88d7-b78cfa34cd0e",
                effectsConfig.value.quen_reflect_damage, EntityAttributeModifier.Operation.MULTIPLY_BASE);

        Synchronized.configure(AERONDIGHT_CHARGE,true);
        Synchronized.configure(QUEN_SHIELD,true);
        Synchronized.configure(MAGICAL_TRAP,true);
        Synchronized.configure(AXII,true);
        Synchronized.configure(ADRENALINE_GAIN,true);
        Synchronized.configure(QUEN_EXPLODE,true);

        RemoveOnHit.configure(AXII, true);

        ActionImpairing.configure(AXII, EntityActionsAllowed.STUN);

        HealthImpacting.configureDamageTaken(AXII, effectsConfig.value.axii_damage_increase);


        int witcher_effectid = 300;
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "aerondight_charge").toString(), AERONDIGHT_CHARGE);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "quen_shield").toString(), QUEN_SHIELD);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "axii").toString(), AXII);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "magical_trap").toString(), MAGICAL_TRAP);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "adrenaline_gain").toString(), ADRENALINE_GAIN);
        Registry.register(Registries.STATUS_EFFECT, witcher_effectid++, new Identifier(MOD_ID, "quen_explode").toString(), QUEN_EXPLODE);

    }

}

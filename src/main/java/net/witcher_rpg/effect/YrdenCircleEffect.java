package net.witcher_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.witcher_rpg.damage.MagicalTrapDamageSource;

public class YrdenCircleEffect extends StatusEffect {

    public YrdenCircleEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int pAmplifier) {
            entity.damage(new MagicalTrapDamageSource(entity.getDamageSources().magic().getTypeRegistryEntry()), 2.0F * (pAmplifier +1));
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        if (this == Effects.YRDEN_CIRCLE.effect) {
            i = 35 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return true;
    }
}
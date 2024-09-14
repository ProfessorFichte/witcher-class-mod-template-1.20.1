package net.witcher_rpg.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.tag.EntityTypeTags;
import net.witcher_rpg.damage.MagicalTrapDamageSource;

public class YrdenCircleEffect extends StatusEffect {
    public YrdenCircleEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int pAmplifier) {
        EntityType<?> type = ((Entity) entity).getType();
        if(type.isIn(EntityTypeTags.UNDEAD)){
            entity.damage(new MagicalTrapDamageSource(entity.getDamageSources().magic().getTypeRegistryEntry()), 2.0F * (pAmplifier +1));
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        if (this == Effects.YRDEN_CIRCLE.effect) {
            i = 30 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return true;
    }
}
package net.witcher_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.witcher_rpg.damage.MagicalTrapDamageSource;

public class MagicalTrapEffect extends StatusEffect {


    public MagicalTrapEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.isUndead()){
            pLivingEntity.damage(new MagicalTrapDamageSource(pLivingEntity.getDamageSources().magic().getTypeRegistryEntry()), 0.5F * (pAmplifier +1));
            pLivingEntity.setMovementSpeed(-100.0F);
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
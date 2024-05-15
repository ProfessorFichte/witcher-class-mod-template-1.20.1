package net.witcher_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import static net.more_rpg_classes.util.CustomMethods.clearNegativeEffects;

public class QuenEffect extends StatusEffect {
    private final int healthPerStack;
    public QuenEffect(StatusEffectCategory statusEffectCategory, int i) {
        this(statusEffectCategory, i, 4);
    }

    public QuenEffect(StatusEffectCategory statusEffectCategory, int i, int healthPerStack) {
        super(statusEffectCategory, i);
        this.healthPerStack = healthPerStack;
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() - (float)(healthPerStack * (amplifier + 1)));
        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        clearNegativeEffects(entity,true);
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() + (float)(healthPerStack * (amplifier + 1)));
        super.onApplied(entity, attributes, amplifier);
    }
}
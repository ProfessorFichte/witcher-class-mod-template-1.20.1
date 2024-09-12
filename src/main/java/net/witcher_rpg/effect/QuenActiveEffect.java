package net.witcher_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.spell_engine.api.spell.ParticleBatch;
import net.spell_engine.particle.ParticleHelper;

import static net.more_rpg_classes.util.CustomMethods.clearNegativeEffects;
import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class QuenActiveEffect extends StatusEffect {
    public static final Identifier QUEN_BREAK_ID = Identifier.of(MOD_ID, "quen_sign_break");
    public static final SoundEvent QUEN_BREAK = SoundEvent.of(QUEN_BREAK_ID );
    private final int healthPerStack;

    public static final ParticleBatch quen_break = new ParticleBatch(
            "spell_engine:electric_arc_a",
            ParticleBatch.Shape.SPHERE, ParticleBatch.Origin.CENTER,
            null, 4, 0.01F, 0.1F, 0);
    public QuenActiveEffect(StatusEffectCategory statusEffectCategory, int i) {
        this(statusEffectCategory, i, 8);
    }

    public QuenActiveEffect(StatusEffectCategory statusEffectCategory, int i, int healthPerStack) {
        super(statusEffectCategory, i);
        this.healthPerStack = healthPerStack;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        clearNegativeEffects(entity,true);
        return false;
    }

    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() - (float)(healthPerStack * (amplifier + 1)));
        if (!entity.getWorld().isClient()) {
                entity.getWorld().playSoundFromEntity(null, entity, QUEN_BREAK, SoundCategory.PLAYERS, 1F, 1F);
            ParticleHelper.sendBatches(entity, new ParticleBatch[]{quen_break});
            }
    }

    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        clearNegativeEffects(entity,true);
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() + (float)(healthPerStack * (amplifier + 1)));
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}

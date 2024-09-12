package net.witcher_rpg.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.spell_engine.api.spell.ParticleBatch;
import net.spell_engine.particle.ParticleHelper;

import static net.more_rpg_classes.util.CustomMethods.clearNegativeEffects;
import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class QuenEffect extends StatusEffect {
    public QuenEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        return entity.getAbsorptionAmount() > 0.0F || entity.getWorld().isClient;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        entity.setAbsorptionAmount(Math.max(entity.getAbsorptionAmount(), (float)(4 * (1 + amplifier))));
    }
    /*
    public static final Identifier QUEN_BREAK_ID = Identifier.of(MOD_ID, "quen_sign_break");
    public static final SoundEvent QUEN_BREAK = SoundEvent.of(QUEN_BREAK_ID );
    public static final ParticleBatch quen_break = new ParticleBatch(
            "spell_engine:electric_arc_a",
            ParticleBatch.Shape.SPHERE, ParticleBatch.Origin.CENTER,
            null, 4, 0.01F, 0.1F, 0);



    public void onRemove(LivingEntity entity, int amplifier) {
        super.onEntityRemoval(entity,amplifier, Entity.RemovalReason.DISCARDED);
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() - (float)(healthPerStack * (amplifier + 1)));
        if (!entity.getWorld().isClient()) {
            entity.getWorld().playSoundFromEntity(null, entity, QUEN_BREAK, SoundCategory.PLAYERS, 1F, 1F);
            ParticleHelper.sendBatches(entity, new ParticleBatch[]{quen_break});
        }
    }

    public void onApplied(LivingEntity entity,int amplifier) {
        super.onApplied(entity, amplifier);
        clearNegativeEffects(entity,true);
        entity.setAbsorptionAmount(entity.getAbsorptionAmount() + (float)(healthPerStack * (amplifier + 1)));
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }*/

}
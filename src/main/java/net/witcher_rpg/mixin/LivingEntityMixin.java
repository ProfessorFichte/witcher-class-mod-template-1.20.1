package net.witcher_rpg.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.spell_engine.internals.SpellRegistry;
import net.spell_engine.internals.casting.SpellCasterEntity;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.attribute.WitcherAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Random;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {


    @Inject(method = "createLivingAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;",
            require = 1, allow = 1, at = @At("RETURN"))
    private static void witcherEntityAttributes$addAttributes
            (CallbackInfoReturnable<DefaultAttributeContainer.Builder> info){
        info.getReturnValue().add(WitcherAttributes.AARD_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.ADRENALINE_MODIFIER);
        info.getReturnValue().add(WitcherAttributes.AXII_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.IGNI_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.QUEN_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.YRDEN_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.SIGN_INTENSITY);
    }


    @Inject(at = @At("HEAD"), method = "isBlocking", cancellable = true)
    private void witcherBlockingMechanics( final CallbackInfoReturnable<Boolean> info) {
        LivingEntity player2 = ((LivingEntity) (Object) this);
        if (player2 instanceof ServerPlayerEntity player && player instanceof SpellCasterEntity caster) {
            if (SpellRegistry.getSpell(new Identifier(MOD_ID, "defensive_witcher_mechanics")) != null
                    && Objects.equals(caster.getCurrentSpell(), SpellRegistry.getSpell(new Identifier(MOD_ID, "defensive_witcher_mechanics")))) {
                info.setReturnValue(true);
            }
            if (SpellRegistry.getSpell(new Identifier(MOD_ID, "whirl")) != null
                    && Objects.equals(caster.getCurrentSpell(), SpellRegistry.getSpell(new Identifier(MOD_ID, "whirl")))) {
                info.setReturnValue(true);
            }
        }
    }

    @Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"))
    private void applyQuenHealBeforeDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity damagedTarget = ((LivingEntity) (Object) this);
        if(damagedTarget.isPlayer() && damagedTarget.hasStatusEffect(Effects.QUEN_ACTIVE) && !source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)){
            damagedTarget.heal(amount/2);
        }
    }
    @Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"))
    private void decreaseAdrenalineAmplifierOnDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity damagedTarget = ((LivingEntity) (Object) this);
        if(damagedTarget.isPlayer() && damagedTarget.hasStatusEffect(Effects.ADRENALINE_GAIN)){
            int adrenaline_effect_amplifier = damagedTarget.getStatusEffect(Effects.ADRENALINE_GAIN).getAmplifier();
            int adrenaline_effect_duration = damagedTarget.getStatusEffect(Effects.ADRENALINE_GAIN).getDuration();
            float adrenaline_attribute_player = (float) (damagedTarget.getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER)-100.0F);
            float random = new Random().nextFloat(100);
            if(adrenaline_effect_amplifier != 0){
                if(random > adrenaline_attribute_player){
                    damagedTarget.removeStatusEffect(Effects.ADRENALINE_GAIN);
                    damagedTarget.addStatusEffect(new StatusEffectInstance(Effects.ADRENALINE_GAIN,adrenaline_effect_duration,
                            adrenaline_effect_amplifier-1,false,false,true));
                }

            }else{
                damagedTarget.removeStatusEffect(Effects.ADRENALINE_GAIN);
            }
        }
    }
}

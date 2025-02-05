package net.witcher_rpg.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.attribute.WitcherAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.witcher_rpg.WitcherClassMod.effectsConfig;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {


    /*
    @Inject(method = "createPlayerAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;", require = 1, allow = 1, at = @At("RETURN"))
    private static void witcherEntityAttributes$addAttributes(final CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
        info.getReturnValue().add(WitcherAttributes.AARD_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.ADRENALINE_MODIFIER);
        info.getReturnValue().add(WitcherAttributes.AXII_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.IGNI_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.QUEN_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.YRDEN_INTENSITY);
        info.getReturnValue().add(WitcherAttributes.SIGN_INTENSITY);
    }

     */

    @Inject(at = @At("HEAD"), method = "attack")
    public void witcherStackAdrenaline(Entity target, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        EntityAttributeInstance adrenaline = ((LivingEntity) (Object) this).getAttributeInstance(WitcherAttributes.ADRENALINE_MODIFIER);
        int value1 = (int) adrenaline.getValue();
        if (player instanceof ServerPlayerEntity) {
            if (value1 != 100) {
                value1 = value1 -100;
                int adrenaline_duration_multiplier = value1 * 3;
                if(!player.hasStatusEffect(Effects.ADRENALINE_GAIN.registryEntry)){
                    player.addStatusEffect(new StatusEffectInstance(Effects.ADRENALINE_GAIN.registryEntry,
                            200+adrenaline_duration_multiplier,0,false,false,true));
                }
                else
                {
                    int currentAmplifier = player.getStatusEffect(Effects.ADRENALINE_GAIN.registryEntry).getAmplifier();
                    int currentDuration = player.getStatusEffect(Effects.ADRENALINE_GAIN.registryEntry).getDuration();
                    int effectDuration = adrenaline_duration_multiplier + currentDuration;
                    if(effectDuration > (effectsConfig.value.adrenaline_max_seconds_duration *20)){
                        effectDuration = (effectsConfig.value.adrenaline_max_seconds_duration *20);
                    }
                    if(currentAmplifier < effectsConfig.value.adrenaline_max_amplifier-1){
                        player.addStatusEffect(new StatusEffectInstance(Effects.ADRENALINE_GAIN.registryEntry,effectDuration,
                                currentAmplifier+1,false,false,true));
                    }
                    else{
                        player.addStatusEffect(new StatusEffectInstance(Effects.ADRENALINE_GAIN.registryEntry,effectDuration,
                                effectsConfig.value.adrenaline_max_amplifier-1,false,false,true));
                    }
                }
            }
        }
    }

    @ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float modifyWitcherDamageBattleTrance(float damage) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.hasStatusEffect(Effects.BATTLE_TRANCE.registryEntry) && player.hasStatusEffect(Effects.ADRENALINE_GAIN.registryEntry)){
            int adrenaline_effect_amplifier = player.getStatusEffect(Effects.ADRENALINE_GAIN.registryEntry).getAmplifier() + 1;
            return (float) (damage + (1 + (adrenaline_effect_amplifier / 10)));
        }
        return damage;
    }


}

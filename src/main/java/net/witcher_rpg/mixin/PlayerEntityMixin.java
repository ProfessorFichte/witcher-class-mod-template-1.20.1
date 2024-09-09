package net.witcher_rpg.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.attribute.WitcherAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.more_rpg_classes.util.CustomMethods.increaseAmpByChance;
import static net.witcher_rpg.WitcherClassMod.effectsConfig;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

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

    @Inject(at = @At("HEAD"), method = "attack")
    public void witcher$attack(Entity target, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        EntityAttributeInstance adrenaline = ((LivingEntity) (Object) this).getAttributeInstance(WitcherAttributes.ADRENALINE_MODIFIER);
        int value1 = (int) adrenaline.getValue();
        if (player instanceof ServerPlayerEntity) {
            if (value1 != 100) {
                value1 = value1 -100;
                int duration_multiplier = value1 * 4;
                if(!player.hasStatusEffect(Effects.ADRENALINE_GAIN)){
                    player.addStatusEffect(new StatusEffectInstance(Effects.ADRENALINE_GAIN,200+duration_multiplier,0,false,false,true));
                }else{
                    int currentDuration= player.getStatusEffect(Effects.ADRENALINE_GAIN).getDuration();
                    int adrenaline_chance_inc = (int) Math.round((float) value1 /5);
                    increaseAmpByChance(player,Effects.ADRENALINE_GAIN,currentDuration+duration_multiplier,1,effectsConfig.value.adrenaline_max_amplifier-1,1);
                }
            }
        }
    }

    @ModifyArg(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), index = 1)
    private float modifyWitcherDamage(float damage) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.hasStatusEffect(Effects.BATTLE_TRANCE) && player.hasStatusEffect(Effects.ADRENALINE_GAIN)){
            int adrenaline_effect_amplifier = player.getStatusEffect(Effects.ADRENALINE_GAIN).getAmplifier() + 1;
            return (float) (damage + (1 + (adrenaline_effect_amplifier / 10)));
        }
        return damage;
    }


}

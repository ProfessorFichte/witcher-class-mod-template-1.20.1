package net.witcher_rpg.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.witcher_rpg.effect.Effects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.more_rpg_classes.util.CustomMethods.increaseAmpByChance;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {


    @Inject(at = @At("HEAD"), method = "attack")
    public void witcher$attack(Entity target, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        EntityAttributeInstance adrenaline = ((LivingEntity) (Object) this).getAttributeInstance(MRPGCEntityAttributes.ADRENALINE_MODIFIER);
        int value1 = (int) adrenaline.getValue();
        if (player instanceof ServerPlayerEntity) {
            if (value1 != 100) {
                value1 = value1 -100;
                int duration_multiplier = value1 * 5;
                if(!player.hasStatusEffect(Effects.ADRENALINE_GAIN)){
                    player.addStatusEffect(new StatusEffectInstance(Effects.ADRENALINE_GAIN,350+duration_multiplier,0,false,false,true));
                }else{
                    int adrenaline_chance_inc = (int) Math.round((float) value1 /5);
                    increaseAmpByChance(player,Effects.ADRENALINE_GAIN,350+duration_multiplier,1,20+adrenaline_chance_inc,10-adrenaline_chance_inc);
                }
            }
        }
    }
}

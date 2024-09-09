package net.witcher_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemStack;
import net.witcher_rpg.item.weapon.AerondightRelictItem;

public class AerondightChargeEffect extends StatusEffect {
    public AerondightChargeEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        ItemStack itemStack = entity.getMainHandStack();
        if(itemStack.getItem() instanceof AerondightRelictItem){
        }
        else{
            entity.removeStatusEffect(Effects.AERONDIGHT_CHARGE);
        }
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

}

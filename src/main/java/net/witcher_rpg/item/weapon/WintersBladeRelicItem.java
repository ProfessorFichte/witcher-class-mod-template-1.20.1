package net.witcher_rpg.item.weapon;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.more_rpg_classes.effect.MRPGCEffects;

public class WintersBladeRelicItem extends WitcherSword {
    public WintersBladeRelicItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    //10% chance to frost
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int frosted_duration = 200;
        int frosted_chance = 10;
        int roll = (int) ((Math.random() * (1 + frosted_chance)) + 1);


        if(!target.hasStatusEffect(MRPGCEffects.FROZEN_SOLID.registryEntry)){
        if (roll >= frosted_chance)    {
            if(!target.hasStatusEffect(MRPGCEffects.FROSTED.registryEntry)){

                target.addStatusEffect(new StatusEffectInstance(MRPGCEffects.FROSTED.registryEntry,frosted_duration,0,false,false,true));
            }else {
                int currentAmplifier = target.getStatusEffect(MRPGCEffects.FROSTED.registryEntry).getAmplifier();
                target.addStatusEffect(new StatusEffectInstance(MRPGCEffects.FROSTED.registryEntry,frosted_duration,currentAmplifier+1,false,false,true));
            }
        }
        }

        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }
}

package net.witcher_rpg.item.weapon;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.more_rpg_classes.effect.MRPGCEffects;

public class WitcherSteelSwordItem extends WitcherSword {
    public WitcherSteelSwordItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    //10% chance to bleed non-undead
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!target.isDead()){
            int bleed_duration = 200;
            int bleed_chance = 10;
            int randomrange_bleed = (int) ((Math.random() * (1 + bleed_chance)) + 1);

            if (randomrange_bleed >= bleed_chance ) {
                target.addStatusEffect(new StatusEffectInstance(MRPGCEffects.BLEEDING.registryEntry,bleed_duration,0,false,false,true));
            }
        }
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }
}

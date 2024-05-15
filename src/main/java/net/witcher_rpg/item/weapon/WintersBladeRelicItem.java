package net.witcher_rpg.item.weapon;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.item.weapon.SpellSwordItem;

public class WintersBladeRelicItem extends SpellSwordItem {
    public WintersBladeRelicItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    //10% chance to frost
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int frosted_duration = 100;
        int frosted_chance = 10;
        int randomrange_freeze = (int) ((Math.random() * (1 + frosted_chance)) + 1);

        if (randomrange_freeze >= frosted_duration ) {
            target.addStatusEffect(new StatusEffectInstance(MRPGCEffects.FROSTED, frosted_duration));

        }
        stack.damage(1, attacker, (e)->{
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }
}

package net.witcher_rpg.item.weapon;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.item.weapon.SpellSwordItem;
import net.witcher_rpg.effect.Effects;

import static net.more_rpg_classes.util.CustomMethods.increaseAmpByChance;
import static net.witcher_rpg.WitcherClassMod.effectsConfig;

public class WintersBladeRelicItem extends SpellSwordItem {
    public WintersBladeRelicItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    //10% chance to frost
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int frosted_duration = 200;
        int frosted_chance = 10;
        increaseAmpByChance(target, MRPGCEffects.FROSTED,frosted_duration,0,9,frosted_chance);


        stack.damage(1, attacker, (e)->{
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }
}

package net.witcher_rpg.item.weapon;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.more_rpg_classes.effect.MRPGCEffects;

import java.util.List;

public class WintersBladeRelicItem extends WitcherSword {
    public WintersBladeRelicItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //SteelSword Bleed
        EntityType<?> type = ((Entity) target).getType();
        if(!type.isIn(EntityTypeTags.UNDEAD)){
            int bleed_duration = 200;
            int bleed_chance = 10;
            int randomrange_bleed = (int) ((Math.random() * (1 + bleed_chance)) + 1);

            if (randomrange_bleed >= bleed_chance ) {
                target.addStatusEffect(new StatusEffectInstance(MRPGCEffects.BLEEDING.registryEntry,bleed_duration,0,false,false,true));
            }
        }
        //10% chance to frost
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

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.witcher_rpg.steel_witcher_swords.description_1").formatted(Formatting.DARK_RED));
            tooltip.add(Text.translatable("item.witcher_rpg.winters_blade.description_1").formatted(Formatting.AQUA));
        }else {
            tooltip.add(Text.translatable("tooltip.witcher_rpg.shift_down"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}

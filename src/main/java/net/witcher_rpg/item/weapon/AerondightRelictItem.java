package net.witcher_rpg.item.weapon;


import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.witcher_rpg.effect.Effects;

import java.util.List;

import static net.more_rpg_classes.util.CustomMethods.increaseHiddenEffectLevel;

public class AerondightRelictItem extends WitcherSword {
    public AerondightRelictItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        PlayerEntity player = (PlayerEntity) attacker;
        int charge_duration = 130;
        int charge_amplifier_max = 9;
        int charge_incamp =1;

        if(target.isDead()){
            float attack = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
            target.damage(target.getDamageSources().magic(), attack * 0.30F);
            player.addEnchantedHitParticles(target);
        }
        increaseHiddenEffectLevel(player, Effects.AERONDIGHT_CHARGE.effect,charge_duration,charge_incamp,charge_amplifier_max);
        int currentAmplifier = player.getStatusEffect(Effects.AERONDIGHT_CHARGE.registryEntry).getAmplifier();
        if(currentAmplifier == charge_amplifier_max){
                target.damage(target.getDamageSources().magic(), 1.0f);
                player.addEnchantedHitParticles(target);
            }
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    public void appendTooltip(ItemStack stack, List<Text> tooltip, TooltipContext context, TooltipType.Default type) {
        tooltip.add(Text.translatable(this.getTranslationKey() + ".description_1").formatted(Formatting.AQUA));
        tooltip.add(Text.translatable(this.getTranslationKey() + ".description_2").formatted(Formatting.DARK_AQUA));
        tooltip.add(Text.translatable(this.getTranslationKey() + ".description_3").formatted(Formatting.DARK_AQUA));
        tooltip.add(Text.translatable(this.getTranslationKey() + ".description_4").formatted(Formatting.DARK_AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
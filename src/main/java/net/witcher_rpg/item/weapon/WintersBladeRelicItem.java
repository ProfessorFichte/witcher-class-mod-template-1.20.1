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
import java.util.Random;

import static net.more_rpg_classes.util.CustomMethods.applyStatusEffect;
import static net.witcher_rpg.WitcherClassMod.tweaksConfig;

public class WintersBladeRelicItem extends WitcherSword {
    public WintersBladeRelicItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //GENERAL STEEL SWORD PASSIVE
        EntityType<?> type = ((Entity) target).getType();
        if(!type.isIn(EntityTypeTags.UNDEAD)){
            float random = new Random().nextFloat(1.0F);
            if (random < tweaksConfig.value.steel_swords_bleed_chance ) {
                target.addStatusEffect(new StatusEffectInstance(MRPGCEffects.BLEEDING.registryEntry,
                        tweaksConfig.value.steel_swords_bleed_duration_seconds, 0,false,false,true));
            }
        }
        //FROST CHANCE
        float random = new Random().nextFloat(1.0F);
        if(random > tweaksConfig.value.wintersblade_freeze_chance){
            applyStatusEffect(target,0,8, MRPGCEffects.FROSTED.registryEntry,
                    4, true,true,false,0);
        }

        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.witcher_rpg.relic_witcher_swords.description_1").formatted(Formatting.RED));
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.witcher_rpg.steel_witcher_swords.description_1").formatted(Formatting.DARK_RED));
            tooltip.add(Text.translatable("item.witcher_rpg.winters_blade.description_1").formatted(Formatting.AQUA));
        }else {
            tooltip.add(Text.translatable("tooltip.witcher_rpg.shift_down"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}

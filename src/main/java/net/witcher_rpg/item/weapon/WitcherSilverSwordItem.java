package net.witcher_rpg.item.weapon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class WitcherSilverSwordItem extends WitcherSword {
    public WitcherSilverSwordItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EntityType<?> type = ((Entity) target).getType();
        PlayerEntity player = (PlayerEntity) attacker;
        float attack = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if(type.isIn(EntityTypeTags.UNDEAD)){
            target.damage(target.getDamageSources().magic(), attack * 0.20F);
            player.addEnchantedHitParticles(target);
        }
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    public void appendTooltip(ItemStack stack, List<Text> tooltip, TooltipContext context, TooltipType.Default type) {
        tooltip.add(Text.translatable("item.witcher_rpg.silver_witcher_swords.description_1").formatted(Formatting.AQUA));
        super.appendTooltip(stack, context, tooltip, type);
    }
}

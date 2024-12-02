package net.witcher_rpg.item.weapon;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.witcher_rpg.damage.SilverDamageSource;
import net.witcher_rpg.util.tags.WitcherEntityTags;

import java.util.List;

import static net.witcher_rpg.WitcherClassMod.tweaksConfig;

public class WitcherSilverSwordItem extends WitcherSword {
    public WitcherSilverSwordItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //GENERAL SILVER SWORD PASSIVE
        EntityType<?> type = ((Entity) target).getType();
        if(type.isIn(WitcherEntityTags.SILVER_VULNERABLE)){
            float attack = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
            target.damage(new SilverDamageSource(target.getDamageSources().magic().getTypeRegistryEntry()),
                    attack * tweaksConfig.value.silver_swords_silver_damage_attack_damage_multiplier);
        }
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.witcher_rpg.silver_witcher_swords.description_1").formatted(Formatting.AQUA));
        }else {
            tooltip.add(Text.translatable("tooltip.witcher_rpg.shift_down"));

        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}

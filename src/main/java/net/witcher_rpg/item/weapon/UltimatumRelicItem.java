package net.witcher_rpg.item.weapon;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class UltimatumRelicItem extends WitcherSword {
    public UltimatumRelicItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int fire_duration = 5;
        int fire_chance = 12;
        int randomrange_fire = (int) ((Math.random() * (1 + fire_chance)) + 1);

        if (randomrange_fire >= fire_chance ) {
            target.setOnFireFor(fire_duration);
        }
        stack.damage(1, attacker, (e)->{
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }
}

package net.witcher_rpg.custom;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.spell_power.api.SpellSchool;
import net.spell_power.api.enchantment.SpellPowerEnchanting;
import net.spell_power.internals.AmplifierEnchantment;
import net.witcher_rpg.config.PowerEnchantingConfig;

import java.util.Iterator;
import java.util.Set;


public class WitcherSchoolEnchanting extends AmplifierEnchantment{

    private Set<SpellSchool> schools;

    public Set<SpellSchool> poweredSchools() {
        return this.schools;
    }

    public void setPoweredSchools(Set<SpellSchool> schools) {
        this.schools = schools;
    }

    public WitcherSchoolEnchanting(Enchantment.Rarity weight, AmplifierEnchantment.Operation operation, PowerEnchantingConfig config, Set<SpellSchool> schools, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, operation, config, type, slotTypes);
        this.schools = schools;
    }

    public WitcherSchoolEnchanting requireTag(Identifier tagId) {
        this.tagId = tagId;
        return this;
    }

    protected boolean method_8180(Enchantment other) {
        return !(other instanceof WitcherSchoolEnchanting) && super.canAccept(other);
    }

    public boolean requiresRelatedAttributes() {
        return ((PowerEnchantingConfig)this.config).requires_related_attributes;
    }

    public static boolean schoolsIntersect(Set<SpellSchool> schools, ItemStack stack) {
        Set<SpellSchool> itemStackSchools = SpellPowerEnchanting.relevantSchools(stack);
        Iterator var3 = itemStackSchools.iterator();

        SpellSchool school;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            school = (SpellSchool)var3.next();
        } while(!schools.contains(school));

        return true;
    }
}

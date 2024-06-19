package net.witcher_rpg.custom.custom_spells;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.spell.CustomSpellHandler;
import net.spell_engine.api.spell.SpellInfo;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.utils.TargetHelper;
import net.witcher_rpg.effect.Effects;

import java.util.List;
import java.util.function.Predicate;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;
import static net.more_rpg_classes.util.CustomMethods.*;
import static net.spell_engine.internals.SpellRegistry.getSpell;

public class CustomSpells {
    public static void register() {


        ///////WITCHER_SPELLS
        /// STRONG_ATTACK
        CustomSpellHandler.register(new Identifier(MOD_ID, "strong_attack"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            for (Entity entity : data1.targets()) {
                if (entity instanceof LivingEntity ) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(new Identifier(MOD_ID, "strong_attack")),new Identifier(MOD_ID)), data1.impactContext());
                    if(!data1.caster().hasStatusEffect(Effects.ADRENALINE_GAIN)){
                        data1.caster().addStatusEffect(new StatusEffectInstance(Effects.ADRENALINE_GAIN, 350, 0, false, false, true));
                    }
                    increaseAmpByChance(data1.caster(), Effects.ADRENALINE_GAIN,350,1,20,3);
                    return true;
                }
            }
            return true;
        });
        /// WHIRL
        CustomSpellHandler.register(new Identifier(MOD_ID, "whirl"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.DIRECT, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };

            double whirlspeed = data1.caster().getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                    + (((data1.caster().getAttributeValue(MRPGCEntityAttributes.ADRENALINE_MODIFIER)-100)/100)*1.5);
            data1.caster().velocityDirty = true;
            data1.caster().velocityModified = true;
            data1.caster().setVelocity(data1.caster().getRotationVec(1).subtract(0, data1.caster().getRotationVec(1).y, 0).normalize().multiply(whirlspeed, whirlspeed * 1, whirlspeed).add(0, data1.caster().getVelocity().y, 0));
            if (!data1.caster().getWorld().isClient) {
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(new Identifier(MOD_ID, "whirl")).range), selectionPredicate);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(new Identifier(MOD_ID, "whirl")),new Identifier(MOD_ID)), data1.impactContext());

                }
            }
            return false;
        });
        /// REND
        CustomSpellHandler.register(new Identifier(MOD_ID, "rend"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float adrenaline_damage_multiplier = (float) ((data1.caster().getAttributeValue(MRPGCEntityAttributes.ADRENALINE_MODIFIER)-100));
            var actualSchool = data1.caster().getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
            for (Entity entity : data1.targets()) {


                if (entity instanceof LivingEntity living) {
                    double amount = adrenaline_damage_multiplier;
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(new Identifier(MOD_ID, "rend")),new Identifier(MOD_ID)), data1.impactContext());
                    if(data1.caster().hasStatusEffect(Effects.ADRENALINE_GAIN)){
                        entity.damage(living.getDamageSources().magic(),(float) amount);
                    }
                }
                return true;
            }
            return true;
        });

    }
}

package net.witcher_rpg.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.spell_engine.api.spell.CustomSpellHandler;
import net.spell_engine.api.spell.SpellInfo;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.utils.TargetHelper;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.attribute.WitcherAttributes;

import java.util.List;
import java.util.function.Predicate;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;
import static net.spell_engine.internals.SpellRegistry.getSpell;

public class CustomSpells {
    public static void register() {
        ///////WITCHER_SPELLS
        /// AARD
        CustomSpellHandler.register(Identifier.of(MOD_ID, "aard"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.DIRECT, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };

            if (!data1.caster().getWorld().isClient) {
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(Identifier.of(MOD_ID, "aard")).range), selectionPredicate);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "aard")),Identifier.of(MOD_ID)), data1.impactContext());
                    if(entity instanceof PersistentProjectileEntity arrow){
                        Vec3d vec3d = arrow.getPos().subtract(arrow.getX(), arrow.getY(), arrow.getZ());
                        arrow.setVelocity(vec3d);
                    }

                }
            }
            return true;
        });
        /// AARD_SWEEP
        CustomSpellHandler.register(Identifier.of(MOD_ID, "aard_sweep"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            Predicate<Entity> selectionPredicate = (target2) -> {
                return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.DIRECT, TargetHelper.Intent.HARMFUL, data1.caster(), target2)
                );
            };

            if (!data1.caster().getWorld().isClient) {
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(Identifier.of(MOD_ID, "aard_sweep")).range), selectionPredicate);
                for (Entity entity : list) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "aard_sweep")),Identifier.of(MOD_ID)), data1.impactContext());
                    if(entity instanceof PersistentProjectileEntity arrow){
                        Vec3d vec3d = arrow.getPos().subtract(arrow.getX(), arrow.getY(), arrow.getZ());
                        arrow.setVelocity(vec3d);
                    }

                }
            }
            return true;
        });
        /// QUEN_ACTIVE_SHIELD
        CustomSpellHandler.register(Identifier.of(MOD_ID, "quen_active_shield"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            if (!data1.caster().getWorld().isClient) {
                float currentAbsorption = data1.caster().getAbsorptionAmount();
                if(currentAbsorption == 0 ){
                    return true;
                }
            }
            return false;
        });
        /// REND
        CustomSpellHandler.register(Identifier.of(MOD_ID, "rend"), (data) -> {
            CustomSpellHandler.Data data1 = (CustomSpellHandler.Data) data;
            float adrenaline_damage_multiplier = (float)
                    ((data1.caster().getAttributeValue(WitcherAttributes.ADRENALINE_MODIFIER)-100));
            for (Entity entity : data1.targets()) {
                if (entity instanceof LivingEntity living) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "rend")),Identifier.of(MOD_ID)), data1.impactContext());
                    if(data1.caster().hasStatusEffect(Effects.ADRENALINE_GAIN.registryEntry)){
                        entity.damage(living.getDamageSources().magic(),(float) (double) adrenaline_damage_multiplier);
                    }
                }
                return true;
            }
            return true;
        });

    }
}

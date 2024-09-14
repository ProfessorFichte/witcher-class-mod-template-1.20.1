package net.witcher_rpg.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.more_rpg_classes.effect.MRPGCEffects;
import net.spell_engine.api.spell.CustomSpellHandler;
import net.spell_engine.api.spell.SpellInfo;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.utils.TargetHelper;

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
                float knockback= getSpell(Identifier.of(MOD_ID, "aard")).impact[0].action.damage.knockback;
                for (Entity entity : list) {
                    if(entity instanceof PersistentProjectileEntity arrow){
                        Vec3d vec3d = arrow.getPos().subtract(arrow.getX(), arrow.getY(), arrow.getZ());
                        arrow.setVelocity(vec3d);
                    }else if (entity.isLiving()){
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "aard_sweep")),Identifier.of(MOD_ID)), data1.impactContext());
                        LivingEntity livingEntity = (LivingEntity) entity;
                        Vec3d currentMovement = entity.getVelocity();
                        entity.setVelocity(currentMovement.x , currentMovement.y + 0.5, currentMovement.z);
                        entity.velocityModified = true;
                        livingEntity.takeKnockback(knockback* 0.4F,currentMovement.x,currentMovement.z);
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
            float knockback= getSpell(Identifier.of(MOD_ID, "aard_sweep")).impact[0].action.damage.knockback;
            if (!data1.caster().getWorld().isClient) {
                List<Entity> list = data1.caster().getWorld().getOtherEntities(data1.caster(), data1.caster().getBoundingBox().expand(getSpell(Identifier.of(MOD_ID, "aard_sweep")).range), selectionPredicate);
                for (Entity entity : list) {
                    if(entity instanceof PersistentProjectileEntity arrow){
                        Vec3d vec3d = arrow.getPos().subtract(arrow.getX(), arrow.getY(), arrow.getZ());
                        arrow.setVelocity(vec3d);
                    }else if (entity.isLiving()){
                        SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "aard_sweep")),Identifier.of(MOD_ID)), data1.impactContext());
                        LivingEntity livingEntity = (LivingEntity) entity;
                        Vec3d currentMovement = entity.getVelocity();
                        entity.setVelocity(currentMovement.x , currentMovement.y + 0.5, currentMovement.z);
                        entity.velocityModified = true;
                        livingEntity.takeKnockback(knockback * 0.4F,currentMovement.x,currentMovement.z);
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
            for (Entity entity : data1.targets()) {
                if (entity instanceof LivingEntity living) {
                    SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "rend")),Identifier.of(MOD_ID)), data1.impactContext());
                    if (!data1.caster().getWorld().isClient) {
                        if (living.isBlocking()) {
                            living.addStatusEffect(new StatusEffectInstance(MRPGCEffects.STUNNED.registryEntry, 40, 0, false, false, true));
                            SpellHelper.performImpacts(entity.getWorld(), data1.caster(), entity, entity, new SpellInfo(getSpell(Identifier.of(MOD_ID, "rend")), Identifier.of(MOD_ID)), data1.impactContext());
                        }
                    }
                }
                return true;
            }
            return true;
        });

    }
}

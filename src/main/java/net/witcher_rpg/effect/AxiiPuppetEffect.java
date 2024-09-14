package net.witcher_rpg.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Box;

public class AxiiPuppetEffect extends StatusEffect {
    protected AxiiPuppetEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
            if (entity instanceof MobEntity mobEntity) {
                float range = 20.0F;
                Box radius = new Box(mobEntity.getX() + range,
                        mobEntity.getY() + (float) range / 3,
                        mobEntity.getZ() + range,
                        mobEntity.getX() - range,
                        mobEntity.getY() - (float) range / 3,
                        mobEntity.getZ() - range);
                for(Entity entities : mobEntity.getEntityWorld().getOtherEntities(mobEntity, radius, EntityPredicates.VALID_LIVING_ENTITY)){
                    if (entities != null) {
                        if(entities instanceof MobEntity otherMobEntity){
                            mobEntity.setTarget(otherMobEntity);
                        }
                    }

                }
            }else{
                entity.addStatusEffect(new StatusEffectInstance(Effects.AXII.registryEntry,40,0,false,false,true));
                entity.removeStatusEffect(Effects.AXII_PUPPET.registryEntry);
            }
        super.applyUpdateEffect(entity, amplifier);
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}

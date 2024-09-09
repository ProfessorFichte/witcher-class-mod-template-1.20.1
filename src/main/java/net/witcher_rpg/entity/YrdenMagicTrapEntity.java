package net.witcher_rpg.entity;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.more_rpg_classes.MRPGCMod;
import net.spell_engine.api.entity.SpellSpawnedEntity;
import net.spell_engine.api.spell.ParticleBatch;
import net.spell_engine.api.spell.Spell;
import net.spell_engine.internals.SpellRegistry;
import net.spell_engine.particle.ParticleHelper;
import net.spell_engine.utils.TargetHelper;
import net.witcher_rpg.damage.MagicalTrapDamageSource;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.attribute.WitcherAttributes;


public class YrdenMagicTrapEntity extends Entity implements SpellSpawnedEntity {
    public static EntityType<YrdenMagicTrapEntity > ENTITY_TYPE;
    public static final ParticleBatch yrden_damage_circle = new ParticleBatch(
            "witcher_rpg:yrden_cloud",
            ParticleBatch.Shape.CIRCLE,
            ParticleBatch.Origin.CENTER,
            null,
            15,
            0.001F,
            0.02F,
            0);
    public static final ParticleBatch yrden_damage_spehre = new ParticleBatch(
            "witcher_rpg:yrden_cloud",
            ParticleBatch.Shape.SPHERE,
            ParticleBatch.Origin.CENTER,
            null,
            15,
            0.001F,
            0.02F,
            0);


    private Identifier spellId;
    private int timeToLive = 20;
    private int ownerId;
    public static final Identifier yrdenSoundId = new Identifier(MRPGCMod.MOD_ID, "yrden_sign");
    public static final SoundEvent yrdenSound = SoundEvent.of(yrdenSoundId);

    public YrdenMagicTrapEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    public void onCreatedFromSpell(LivingEntity owner, Identifier spellId, Spell.Impact.Action.Spawn spawn) {
        this.spellId = spellId;
        this.getDataTracker().set(SPELL_ID_TRACKER, this.spellId.toString());
        this.ownerId = owner.getId();
        this.getDataTracker().set(OWNER_ID_TRACKER, this.ownerId);
        this.timeToLive = spawn.time_to_live_seconds * 20;
        this.getDataTracker().set(TIME_TO_LIVE_TRACKER, this.timeToLive);

    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }


    @Override
    public boolean damage(DamageSource source, float amount) {
        this.getWorld().playSoundFromEntity(null, this, yrdenSound, SoundCategory.PLAYERS, 1F, 1F);
        return super.damage(source, amount);
    }

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        var spell = getSpell();
        if (spell != null) {
            var width = spell.range * 2;
            var height = spell.range;
            return EntityDimensions.changing(width, height);
        } else {
            return super.getDimensions(pose);
        }
    }

    private static final TrackedData<String> SPELL_ID_TRACKER  = DataTracker.registerData(YrdenMagicTrapEntity.class, TrackedDataHandlerRegistry.STRING);
    private static final TrackedData<Integer> OWNER_ID_TRACKER  = DataTracker.registerData(YrdenMagicTrapEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> TIME_TO_LIVE_TRACKER  = DataTracker.registerData(YrdenMagicTrapEntity.class, TrackedDataHandlerRegistry.INTEGER);


    @Override
    protected void initDataTracker() {
        this.getDataTracker().startTracking(SPELL_ID_TRACKER, "");
        this.getDataTracker().startTracking(OWNER_ID_TRACKER, 0);
        this.getDataTracker().startTracking(TIME_TO_LIVE_TRACKER, 0);
    }

    @Override
    public void onTrackedDataSet(TrackedData<?> data) {
        super.onTrackedDataSet(data);
        var rawSpellId = this.getDataTracker().get(SPELL_ID_TRACKER);
        if (rawSpellId != null && !rawSpellId.isEmpty()) {
            this.spellId = new Identifier(rawSpellId);
        }
        this.timeToLive = this.getDataTracker().get(TIME_TO_LIVE_TRACKER);
        this.calculateDimensions();
    }


    private enum NBTKey {
        OWNER_ID("OwnerId"),
        SPELL_ID("SpellId"),
        TIME_TO_LIVE("TTL"),
        ;

        public final String key;
        NBTKey(String key) {
            this.key = key;
        }
    }


    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.spellId = new Identifier(nbt.getString(NBTKey.SPELL_ID.key));
        this.ownerId = nbt.getInt(NBTKey.OWNER_ID.key);
        this.timeToLive = nbt.getInt(NBTKey.TIME_TO_LIVE.key);
        this.getDataTracker().set(SPELL_ID_TRACKER, this.spellId.toString());
        this.getDataTracker().set(OWNER_ID_TRACKER, this.ownerId);
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putString(NBTKey.SPELL_ID.key, this.spellId.toString());
        nbt.putInt(NBTKey.OWNER_ID.key, this.ownerId);
        nbt.putInt(NBTKey.TIME_TO_LIVE.key, this.timeToLive);
    }

    @Override
    public boolean isSilent() {
        return false;
    }

    private static final int checkInterval = 4;
    private static final int checkDamageInterval = 30;


    @Override
    public void tick() {
        float yrden_intensity = 0;
        var owner = this.cachedOwner;
        if(owner == null){
            yrden_intensity = 1;
        }
        else{
            yrden_intensity = (float) owner.getAttributeValue(WitcherAttributes.YRDEN_INTENSITY);
        }
        super.tick();
        var spell = getSpell();
        if (spell == null) {
            return;
        }
        var world = this.getWorld();
        if (world.isClient()) {

        } else {
            if (this.age > this.timeToLive) {
                this.kill();
            }
            if (this.age % checkInterval == 0) {
                var entities = getWorld().getOtherEntities(this, this.getBoundingBox().expand(0.1F));
                for (var entity : entities) {
                    if(entity instanceof ProjectileEntity projectile){
                        if (!isProtected(projectile.getOwner())) {
                            entity.playSound(yrdenSound,1F,1F);
                            ParticleHelper.sendBatches(entity, new ParticleBatch[]{yrden_damage_circle});
                            ParticleHelper.sendBatches(entity, new ParticleBatch[]{yrden_damage_spehre});
                            projectile.kill();
                        }
                    }
                    if (entity instanceof LivingEntity livingEntity) {
                        if (!isProtected(livingEntity)) {
                            if(this.age % checkDamageInterval == 0){
                                livingEntity.damage(new MagicalTrapDamageSource(entity.getDamageSources().magic().getTypeRegistryEntry()), 0.75F * yrden_intensity);
                                livingEntity.addStatusEffect(new StatusEffectInstance(Effects.YRDEN_GLYPH,150, (int) (0 * (yrden_intensity +1 )),false,false,true));
                                livingEntity.playSound(yrdenSound,1F,1F);
                                ParticleHelper.sendBatches(entity, new ParticleBatch[]{yrden_damage_circle});
                                ParticleHelper.sendBatches(entity, new ParticleBatch[]{yrden_damage_spehre});
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isProtected(Entity other) {
        var owner = this.getOwner();
        if (owner == null) {
            return false;
        }
        var relation = TargetHelper.getRelation(owner, other);
        switch (relation) {
            case FRIENDLY, SEMI_FRIENDLY -> {
                return true;
            }
            case NEUTRAL, MIXED, HOSTILE -> {
                return false;
            }
        }
        return false;
    }

    public Spell getSpell() {
        return SpellRegistry.getSpell(spellId);
    }

    private LivingEntity cachedOwner = null;
    @Nullable
    public LivingEntity getOwner() {
        if (cachedOwner != null) {
            return cachedOwner;
        }
        var owner = this.getWorld().getEntityById(this.ownerId);
        if (owner instanceof LivingEntity livingOwner) {
            cachedOwner = livingOwner;
            return livingOwner;
        }
        return null;
    }
}

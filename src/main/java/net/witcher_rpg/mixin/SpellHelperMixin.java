package net.witcher_rpg.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.spell_engine.api.spell.Spell;
import net.spell_engine.api.spell.registry.SpellRegistry;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.internals.casting.SpellCast;
import net.spell_engine.internals.casting.SpellCasterEntity;
import net.spell_engine.internals.target.SpellTarget;
import net.spell_power.api.SpellSchool;
import net.witcher_rpg.custom.WitcherSpellSchools;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.attribute.WitcherAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.util.math.Box;

import java.util.List;
import java.util.Objects;

import static net.more_rpg_classes.util.CustomMethods.applyStatusEffect;
import static net.witcher_rpg.WitcherClassMod.MOD_ID;
import static net.witcher_rpg.WitcherClassMod.effectsConfig;

@Mixin(SpellHelper.class)
public abstract class SpellHelperMixin {

    @Inject(at = @At("HEAD"), method = "performSpell", cancellable = true)
    private static void witcherQuenActiveShield(World world, PlayerEntity player, RegistryEntry<Spell> spellEntry, SpellTarget.SearchResult targetResult, SpellCast.Action action, float progress, CallbackInfo callbackInfo) {
        if (!player.isSpectator()&& player instanceof SpellCasterEntity spellCasterEntity) {
            var spell = spellCasterEntity.getCurrentSpell();
            var spellEntryQuen = SpellRegistry.from(player.getWorld()).getEntry(Identifier.of(MOD_ID, "quen_active_shield")).orElse(null);
            var spellQuen = spellEntryQuen.value();

            if (spell != null) {
                if(action == SpellCast.Action.CHANNEL && Objects.equals(spell, spellQuen)){
                    float absorb = player.getAbsorptionAmount();
                    if(absorb == 0){
                        player.removeStatusEffect(Effects.QUEN_ACTIVE.registryEntry);

                    }
                }

                if(action == SpellCast.Action.RELEASE && Objects.equals(spell, spellQuen)){
                    player.removeStatusEffect(Effects.QUEN_ACTIVE.registryEntry);
                }
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "performSpell", cancellable = true)
    private static void damagingSignAdrenalineGain(World world, PlayerEntity player, RegistryEntry<Spell> spellEntry, SpellTarget.SearchResult targetResult, SpellCast.Action action, float progress, CallbackInfo callbackInfo) {
        if (!player.isSpectator() ) {
            var spell = spellEntry.value();
            SpellSchool school = spell.school;
            List<Entity> entities = targetResult.entities();

            if (spell != null && action == SpellCast.Action.RELEASE && entities != null && school == WitcherSpellSchools.IGNI || school == WitcherSpellSchools.AARD) {

                EntityAttributeInstance adrenaline = player.getAttributeInstance(WitcherAttributes.ADRENALINE_MODIFIER);
                int value1 = (int) adrenaline.getValue()-100;
                int adrenaline_duration_multiplier = value1 * 3;

                int durationSeconds = 20 + adrenaline_duration_multiplier;
                if(player.hasStatusEffect(Effects.ADRENALINE_GAIN.registryEntry)){
                    int actualDuration = player.getStatusEffect(Effects.ADRENALINE_GAIN.registryEntry).getDuration()*20;
                    durationSeconds = durationSeconds + actualDuration;
                    if(durationSeconds > (effectsConfig.value.adrenaline_max_seconds_duration *20)){
                        durationSeconds = (effectsConfig.value.adrenaline_max_seconds_duration *20);
                    }
                }

                applyStatusEffect(player,0,durationSeconds,Effects.ADRENALINE_GAIN.registryEntry,effectsConfig.value.adrenaline_max_amplifier-1,
                        true,true,false,0);
            }
        }
    }
}

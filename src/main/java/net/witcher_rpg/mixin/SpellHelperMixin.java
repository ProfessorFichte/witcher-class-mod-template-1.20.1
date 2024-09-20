package net.witcher_rpg.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.spell_engine.api.spell.Spell;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.internals.casting.SpellCast;
import net.spell_engine.utils.TargetHelper;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.attribute.WitcherAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

import static java.lang.Math.round;
import static net.spell_engine.internals.SpellRegistry.getSpell;
import static net.witcher_rpg.WitcherClassMod.MOD_ID;
import static net.witcher_rpg.WitcherClassMod.effectsConfig;

@Mixin(SpellHelper.class)
public abstract class SpellHelperMixin {

    @Inject(at = @At("HEAD"), method = "performSpell", cancellable = true)
    private static void witcherQuenActiveShield(World world, PlayerEntity player, Identifier spellId, TargetHelper.SpellTargetResult targetResult, SpellCast.Action action, float progress, CallbackInfo callbackInfo) {
        if (!player.isSpectator()) {
            boolean quen_check = false;
            float quen_intensity = (float) player.getAttributeValue(WitcherAttributes.QUEN_INTENSITY);
            int amplifier = round(quen_intensity * effectsConfig.value.quen_active_shield_quen_intensity_amplifier_multiplier);
            Spell spell = getSpell(spellId);
            if (spell != null) {
                if(action == SpellCast.Action.CHANNEL &&
                        Objects.equals(spellId, Identifier.of(MOD_ID, "quen_active_shield"))){
                    if(!player.hasStatusEffect(Effects.QUEN_ACTIVE.registryEntry)){
                        player.addStatusEffect(new StatusEffectInstance(Effects.QUEN_ACTIVE.registryEntry,1000,amplifier,false,false,true));

                    }
                }

                if(action == SpellCast.Action.RELEASE && Objects.equals(spellId, Identifier.of(MOD_ID, "quen_active_shield"))){
                    player.removeStatusEffect(Effects.QUEN_ACTIVE.registryEntry);
                }
            }
        }
    }
}

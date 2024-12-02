package net.witcher_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.util.Identifier;

import java.util.*;

import static net.spell_engine.compat.TrinketsCompat.getSpellBookStack;
import static net.spell_engine.internals.SpellContainerHelper.containerFromItemStack;
import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class AlternateSignEffect extends StatusEffect {
    public AlternateSignEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        ItemStack itemStack = getSpellBookStack((PlayerEntity) entity);
        if(!itemStack.isEmpty()){
            List<String> stringlist = List.of();
            stringlist = containerFromItemStack(itemStack).spell_ids();
            NbtList list = new NbtList();
            for (String string : stringlist) {
                list.add(NbtString.of(string));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "aard").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "aard_sweep").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "aard").toString()));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "axii").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "axii_puppet").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "axii").toString()));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "igni").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "igni_firestream").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "igni").toString()));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "quen").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "quen_active_shield").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "quen").toString()));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "yrden").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "yrden_magic_trap").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "yrden").toString()));
            }
            list.remove(NbtString.of(Identifier.of(MOD_ID, "signs_change_form").toString()));
            list.add(NbtString.of(Identifier.of(MOD_ID, "signs_change_form").toString()));

        }
    }


    public static void onRemove(LivingEntity entity) {
        ItemStack itemStack = getSpellBookStack((PlayerEntity) entity);
        if(!itemStack.isEmpty()){
            List<String> stringlist = List.of();
            stringlist = containerFromItemStack(itemStack).spell_ids();

            NbtList list = new NbtList();
            for (String string : stringlist) {
                list.add(NbtString.of(string));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "aard_sweep").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "aard").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "aard_sweep").toString()));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "axii_puppet").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "axii").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "axii_puppet").toString()));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "igni_firestream").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "igni").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "igni_firestream").toString()));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "quen_active_shield").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "quen").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "quen_active_shield").toString()));
            }
            if (list.contains(NbtString.of(Identifier.of(MOD_ID, "yrden_magic_trap").toString()))) {
                list.add(NbtString.of(Identifier.of(MOD_ID, "yrden").toString()));
                list.remove(NbtString.of(Identifier.of(MOD_ID, "yrden_magic_trap").toString()));
            }
            list.remove(NbtString.of(Identifier.of(MOD_ID, "signs_change_form").toString()));
            list.add(NbtString.of(Identifier.of(MOD_ID, "signs_change_form").toString()));

        }
    }
}


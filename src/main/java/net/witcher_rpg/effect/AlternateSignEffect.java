package net.witcher_rpg.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.util.Identifier;
import net.spell_engine.api.item.trinket.SpellBookItem;
import net.spell_engine.api.item.trinket.SpellBookTrinketItem;

import java.util.*;

import static net.spell_engine.compat.TrinketsCompat.getSpellBookStack;
import static net.spell_engine.internals.SpellContainerHelper.containerFromItemStack;
import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class AlternateSignEffect extends StatusEffect {
    public AlternateSignEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void onApplied(LivingEntity pLivingEntity, AttributeContainer attributes, int amplifier) {
        ItemStack itemStack = getSpellBookStack((PlayerEntity) pLivingEntity);
        if(!itemStack.isEmpty()){
            NbtCompound compound = itemStack.getOrCreateNbt();
            List<String> stringlist = List.of();
            stringlist = containerFromItemStack(itemStack).spell_ids;
            NbtList list = new NbtList();
            for (String string : stringlist) {
                list.add(NbtString.of(string));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "aard").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "aard_sweep").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "aard").toString()));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "axii").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "axii_puppet").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "axii").toString()));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "igni").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "igni_firestream").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "igni").toString()));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "quen").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "quen_active_shield").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "quen").toString()));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "yrden").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "yrden_magic_trap").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "yrden").toString()));
            }
            list.remove(NbtString.of(new Identifier(MOD_ID, "signs_change_form").toString()));
            list.add(NbtString.of(new Identifier(MOD_ID, "signs_change_form").toString()));

            NbtCompound compound1 = itemStack.getOrCreateNbt().getCompound("spell_container");
            compound1.putBoolean("is_proxy", true);
            compound1.put("spell_ids", list);
            compound.remove("spell_container");
            compound.put("spell_container", compound1);
        }
        super.onApplied(pLivingEntity, attributes, amplifier);
    }
    @Override
    public void onRemoved(LivingEntity pLivingEntity, AttributeContainer attributes, int amplifier) {
        ItemStack itemStack = getSpellBookStack((PlayerEntity) pLivingEntity);
        if(!itemStack.isEmpty()){
            NbtCompound compound = itemStack.getOrCreateNbt();
            List<String> stringlist = List.of();
            stringlist = containerFromItemStack(itemStack).spell_ids;

            NbtList list = new NbtList();
            for (String string : stringlist) {
                list.add(NbtString.of(string));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "aard_sweep").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "aard").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "aard_sweep").toString()));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "axii_puppet").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "axii").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "axii_puppet").toString()));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "igni_firestream").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "igni").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "igni_firestream").toString()));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "quen_active_shield").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "quen").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "quen_active_shield").toString()));
            }
            if (list.contains(NbtString.of(new Identifier(MOD_ID, "yrden_magic_trap").toString()))) {
                list.add(NbtString.of(new Identifier(MOD_ID, "yrden").toString()));
                list.remove(NbtString.of(new Identifier(MOD_ID, "yrden_magic_trap").toString()));
            }
            list.remove(NbtString.of(new Identifier(MOD_ID, "signs_change_form").toString()));
            list.add(NbtString.of(new Identifier(MOD_ID, "signs_change_form").toString()));

            NbtCompound compound1 = itemStack.getOrCreateNbt().getCompound("spell_container");
            compound1.putBoolean("is_proxy", true);
            compound1.put("spell_ids", list);
            compound.remove("spell_container");
            compound.put("spell_container", compound1);
        }
        super.onRemoved(pLivingEntity, attributes, amplifier);
    }
}


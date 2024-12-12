package net.witcher_rpg.item.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.spell_power.api.SpellPowerMechanics;
import net.witcher_rpg.item.WitcherGroup;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.armor.Armor;
import net.witcher_rpg.item.WitcherItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class Armors {
    private static final Supplier<Ingredient> WITCHER_INGREDIENTS = () -> Ingredient.ofItems(
            Items.LEATHER, WitcherItems.SILVER_INGOT
    );
    private static final Supplier<Ingredient> FELINE_INGREDIENTS = () -> Ingredient.ofItems(
            Items.LEATHER, WitcherItems.STEEL_INGOT, WitcherItems.DARK_IRON_INGOT, WitcherItems.DARK_STEEL_INGOT
    );
    private static final Supplier<Ingredient> GRIFFIN_INGREDIENTS = () -> Ingredient.ofItems(
            Items.LEATHER, WitcherItems.SILVER_INGOT ,  WitcherItems.METEORITE_INGOT, WitcherItems.METEORITE_SILVER_INGOT
    );
    private static final Supplier<Ingredient> WOLVEN_INGREDIENTS = () -> Ingredient.ofItems(
            Items.LEATHER, WitcherItems.SILVER_INGOT ,  WitcherItems.METEORITE_INGOT, WitcherItems.METEORITE_SILVER_INGOT
    );
    private static final Supplier<Ingredient> URSINE_INGREDIENTS = () -> Ingredient.ofItems(
            Items.CHAIN, WitcherItems.STEEL_INGOT, WitcherItems.DARK_IRON_INGOT, WitcherItems.DARK_STEEL_INGOT
    );


    public static RegistryEntry<ArmorMaterial> material(String name,
                                                        int protectionHead, int protectionChest, int protectionLegs, int protectionFeet,
                                                        int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient) {
        var material = new ArmorMaterial(
                Map.of(
                        ArmorItem.Type.HELMET, protectionHead,
                        ArmorItem.Type.CHESTPLATE, protectionChest,
                        ArmorItem.Type.LEGGINGS, protectionLegs,
                        ArmorItem.Type.BOOTS, protectionFeet),
                enchantability, equipSound, repairIngredient,
                List.of(new ArmorMaterial.Layer(Identifier.of(MOD_ID, name))),
                0,0
        );
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(MOD_ID, name), material);
    }
    public static final ArrayList<Armor.Entry> entries = new ArrayList<>();
    private static Armor.Entry create(RegistryEntry<ArmorMaterial> material, Identifier id, int durability, Armor.Set.ItemFactory factory, ItemConfig.ArmorSet defaults) {
        var entry = Armor.Entry.create(
                material,
                id,
                durability,
                factory,
                defaults);
        entries.add(entry);
        return entry;
    }


    private static final Identifier ATTACK_DAMAGE = Identifier.ofVanilla("generic.attack_damage");
    private static final Identifier ATTACK_SPEED = Identifier.ofVanilla("generic.attack_speed");
    private static final Identifier KNOCKBACK_RESISTANCE = Identifier.ofVanilla("generic.knockback_resistance");
    private static final Identifier ARMOR_TOUGHNESS = Identifier.ofVanilla("generic.armor_toughness");
    private static final Identifier MAX_HEALTH = Identifier.ofVanilla("generic.max_health");
    private static final Identifier COMBATROLL_RECHARGE = Identifier.of("combatroll:recharge");
    private static final Identifier ADRENALINE = Identifier.of("witcher_rpg:adrenaline_modifier");
    private static final Identifier AARD_INTENSITY = Identifier.of("witcher_rpg:aard_intensity");
    private static final Identifier AXII_INTENSITY = Identifier.of("witcher_rpg:axii_intensity");
    private static final Identifier IGNI_INTENSITY = Identifier.of("witcher_rpg:igni_intensity");
    private static final Identifier QUEN_INTENSITY = Identifier.of("witcher_rpg:quen_intensity");
    private static final Identifier YRDEN_INTENSITY = Identifier.of("witcher_rpg:yrden_intensity");
    private static final Identifier SIGN_INTENSITY = Identifier.of("witcher_rpg:sign_intensity");

    ////MODIFIERS
    //TIER1 MODIFIERS
    private static final float witcherSign = 0.15F;
    public static final float witcherAdrenaline = 0.03F;
    private static final float witcherAttackDamage = 0.03F;

    //FELINE MODIFIERS
    private static final float felineAttackSpeed = 0.04F;
    private static final float felineAdrenaline = 0.02F;

    private static final float felineAttackSpeedT2 = 0.05F;
    private static final float felineAdrenalineT2 = 0.04F;
    private static final float felineAttackDamageT2 = 0.02F;

    private static final float felineAttackSpeedT3 = 0.05F;
    private static final float felineAdrenalineT3 = 0.075F;
    private static final float felineAttackDamageT3 = 0.03F;
    private static final float felineRollRechargeT3 = 0.01F;

    //GRIFFIN MODIFIERS
    private static final float griffinSign = 0.20F;
    public static final float griffinAdrenaline = 0.01F;

    private static final float griffinSignT2 = 0.25F;
    public static final float griffinAdrenalineT2 = 0.025F;
    public static final float griffinHasteT2 = 0.02F;

    private static final float griffinSignT3 = 0.3F;
    public static final float griffinAdrenalineT3 = 0.05F;
    public static final float griffinHasteT3 = 0.02F;

    //WOLVEN MODIFIERS
    private static final float wolvenAttackDamage = 0.03F;
    private static final float wolvenSign = 0.15F;

    private static final float wolvenAttackDamageT2 = 0.05F;
    private static final float wolvenSignT2 = 0.20F;
    private static final float wolvenAdrenalineT2 = 0.025F;

    private static final float wolvenAttackDamageT3 = 0.05F;
    private static final float wolvenSignT3 = 0.20F;
    private static final float wolvenAdrenalineT3 = 0.075F;

    //URSINE MODIFIERS
    private static final float ursineKnockBackResi = 0.05F;
    private static final float ursineAdrenaline = 0.04F;

    private static final float ursineKnockBackResiT2 = 0.1F;
    private static final float ursineAdrenalineT2 = 0.075F;
    private static final float ursineAttackDamageT2 = 0.04F;

    private static final float ursineKnockBackResiT3 = 0.1F;
    private static final float ursineAdrenalineT3 = 0.10F;
    private static final float ursineAttackDamageT3 = 0.04F;
    private static final float ursineArmorToughnessT3 = 1.0F;

    ////MATERIALS
    //TIER 1 MATERIAL
    public static RegistryEntry<ArmorMaterial> material_witcher = material(
            "witcher", 2, 4, 4, 2, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WITCHER_INGREDIENTS);
    //FELINE MATERIAL
    public static RegistryEntry<ArmorMaterial> material_feline = material(
            "feline",1, 3, 3, 1, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, FELINE_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_enhanced_feline = material(
            "enhanced_feline",2, 4, 4, 2, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, FELINE_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_superior_feline = material(
            "superior_feline",2, 4, 4, 2, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, FELINE_INGREDIENTS);
    //GRIFFIN MATERIAL
    public static RegistryEntry<ArmorMaterial> material_griffin = material(
            "griffin", 2, 5, 4, 1,9,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, GRIFFIN_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_enhanced_griffin = material(
            "enhanced_griffin", 2, 5, 4, 3, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, GRIFFIN_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_superior_griffin = material(
            "superior_griffin", 2, 5, 4, 3, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, GRIFFIN_INGREDIENTS);
    //WOLVEN MATERIAL
    public static RegistryEntry<ArmorMaterial> material_wolven = material(
            "wolven",2, 5, 4, 1,9,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, WOLVEN_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_enhanced_wolven = material(
            "enhanced_wolven",2, 5, 4, 3, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, WOLVEN_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_superior_wolven = material(
            "superior_wolven", 2, 5, 4, 3, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, WOLVEN_INGREDIENTS);
    //URSINE MATERIAL
    public static RegistryEntry<ArmorMaterial> material_ursine = material(
            "ursine", 2, 6, 5, 2, 9,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, URSINE_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_enhanced_ursine = material(
            "enhanced_ursine", 3, 8, 6, 3, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, URSINE_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_superior_ursine = material(
            "superior_ursine", 3, 8, 6, 3, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, URSINE_INGREDIENTS);

    ////ARMOR SETS
    //TIER 1 ARMOR
    public static final Armor.Set witcherArmorSet =
            create(
                    material_witcher, Identifier.of(MOD_ID, "witcher"), 20, WitcherArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_witcher.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,witcherSign),
                                            ItemConfig.Attribute.multiply(ADRENALINE,witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_witcher.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,witcherSign),
                                            ItemConfig.Attribute.multiply(ADRENALINE,witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_witcher.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,witcherSign),
                                            ItemConfig.Attribute.multiply(ADRENALINE,witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_witcher.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,witcherSign),
                                            ItemConfig.Attribute.multiply(ADRENALINE,witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,witcherAttackDamage)
                                    )))).armorSet();

    //FELINE SCHOOL ARMOR
    public static final Armor.Set felineSchoolArmorSet =
            create(
                    material_feline, Identifier.of(MOD_ID, "feline"), 15, CatSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_feline.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenaline),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeed)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_feline.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenaline),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeed)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_feline.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenaline),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeed)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_feline.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenaline),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeed)
                                    )))).armorSet();

    public static final Armor.Set enhancedFelineSchoolArmorSet =
            create(
                    material_enhanced_feline, Identifier.of(MOD_ID, "enhanced_feline"), 20, CatSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_enhanced_feline.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeedT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,felineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_feline.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeedT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,felineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_feline.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeedT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,felineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_feline.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeedT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,felineAttackDamageT2)
                                    )))).armorSet();

    public static final Armor.Set superiorFelineSchoolArmorSet =
            create(
                    material_superior_feline, Identifier.of(MOD_ID, "superior_feline"), 25, CatSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_superior_feline.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeedT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,felineAttackDamageT3),
                                            ItemConfig.Attribute.multiply(COMBATROLL_RECHARGE,felineRollRechargeT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_feline.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeedT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,felineAttackDamageT3),
                                            ItemConfig.Attribute.multiply(COMBATROLL_RECHARGE,felineRollRechargeT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_feline.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeedT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,felineAttackDamageT3),
                                            ItemConfig.Attribute.multiply(COMBATROLL_RECHARGE,felineRollRechargeT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_feline.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,felineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(ATTACK_SPEED,felineAttackSpeedT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,felineAttackDamageT3),
                                            ItemConfig.Attribute.multiply(COMBATROLL_RECHARGE,felineRollRechargeT3)
                                    )))).armorSet();
    //GRIFFIN SCHOOL ARMOR
    public static final Armor.Set griffinArmorSet =
            create(
                    material_griffin, Identifier.of(MOD_ID, "griffin"), 15, GriffinSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_griffin.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSign),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenaline)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_griffin.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSign),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenaline)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_griffin.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSign),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenaline)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_griffin.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSign),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenaline)
                                    )))).armorSet();

    public static final Armor.Set enhancedGriffinArmorSet =
            create(
                    material_enhanced_griffin, Identifier.of(MOD_ID, "enhanced_griffin"), 20, GriffinSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_enhanced_griffin.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSignT2),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenalineT2),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,griffinHasteT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_griffin.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSignT2),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenalineT2),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,griffinHasteT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_griffin.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSignT2),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenalineT2),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_griffin.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSignT2),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenalineT2),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,griffinHasteT2)
                                    )))).armorSet();

    public static final Armor.Set superiorGriffinArmorSet =
            create(
                    material_superior_griffin, Identifier.of(MOD_ID, "superior_griffin"), 25, GriffinSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_superior_griffin.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSignT3),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenalineT3),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,griffinHasteT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_griffin.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSignT3),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenalineT3),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,griffinHasteT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_griffin.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSignT3),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenalineT3),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,griffinHasteT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_griffin.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,griffinSignT3),
                                            ItemConfig.Attribute.multiply(ADRENALINE,griffinAdrenalineT3),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id,griffinHasteT3)
                                    )))).armorSet();

    //WOLVEN SCHOOL ARMOR
    public static final Armor.Set wolvenArmorSet =
            create(
                    material_wolven, Identifier.of(MOD_ID, "wolven"), 15, WolfSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_wolven.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSign),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_wolven.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSign),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_wolven.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSign),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_wolven.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSign),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamage)
                                    )))).armorSet();
    public static final Armor.Set enhancedWolvenArmorSet =
            create(
                    material_enhanced_wolven, Identifier.of(MOD_ID, "enhanced_wolven"), 20, WolfSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_enhanced_wolven.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSignT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamageT2),
                                            ItemConfig.Attribute.multiply(ADRENALINE,wolvenAdrenalineT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_wolven.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSignT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamageT2),
                                            ItemConfig.Attribute.multiply(ADRENALINE,wolvenAdrenalineT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_wolven.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSignT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamageT2),
                                            ItemConfig.Attribute.multiply(ADRENALINE,wolvenAdrenalineT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_wolven.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSignT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamageT2),
                                            ItemConfig.Attribute.multiply(ADRENALINE,wolvenAdrenalineT2)
                                    )))).armorSet();
    public static final Armor.Set superiorWolvenArmorSet =
            create(
                    material_superior_wolven, Identifier.of(MOD_ID, "superior_wolven"), 25, WolfSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_superior_wolven.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSignT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamageT3),
                                            ItemConfig.Attribute.multiply(ADRENALINE,wolvenAdrenalineT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_wolven.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSignT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamageT3),
                                            ItemConfig.Attribute.multiply(ADRENALINE,wolvenAdrenalineT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_wolven.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSignT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamageT3),
                                            ItemConfig.Attribute.multiply(ADRENALINE,wolvenAdrenalineT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_wolven.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SIGN_INTENSITY,wolvenSignT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,wolvenAttackDamageT3),
                                            ItemConfig.Attribute.multiply(ADRENALINE,wolvenAdrenalineT3)
                                    )))).armorSet();

    //URSINE SCHOOL ARMOR
    public static final Armor.Set ursineArmorSet =
            create(
                    material_ursine, Identifier.of(MOD_ID, "ursine"), 15, BearSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_ursine.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenaline),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResi)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_ursine.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenaline),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResi)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_ursine.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenaline),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResi)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_ursine.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenaline),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResi)
                                    )))).armorSet();
    public static final Armor.Set enhancedUrsineArmorSet =
            create(
                    material_enhanced_ursine, Identifier.of(MOD_ID, "enhanced_ursine"), 20, BearSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_enhanced_ursine.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResiT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,ursineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_ursine.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResiT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,ursineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_ursine.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResiT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,ursineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_enhanced_ursine.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResiT2),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,ursineAttackDamageT2)
                                    )))).armorSet();
    public static final Armor.Set superiorUrsineArmorSet =
            create(
                    material_superior_ursine, Identifier.of(MOD_ID, "superior_ursine"), 25, BearSchoolArmor::new,
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(material_superior_ursine.value().getProtection(ArmorItem.Type.HELMET))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResiT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,ursineAttackDamageT3),
                                            ItemConfig.Attribute.bonus(ARMOR_TOUGHNESS,ursineArmorToughnessT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_ursine.value().getProtection(ArmorItem.Type.CHESTPLATE))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResiT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,ursineAttackDamageT3),
                                            ItemConfig.Attribute.bonus(ARMOR_TOUGHNESS,ursineArmorToughnessT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_ursine.value().getProtection(ArmorItem.Type.LEGGINGS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResiT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,ursineAttackDamageT3),
                                            ItemConfig.Attribute.bonus(ARMOR_TOUGHNESS,ursineArmorToughnessT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(material_superior_ursine.value().getProtection(ArmorItem.Type.BOOTS))
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(ADRENALINE,ursineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(KNOCKBACK_RESISTANCE,ursineKnockBackResiT3),
                                            ItemConfig.Attribute.multiply(ATTACK_DAMAGE,ursineAttackDamageT3),
                                            ItemConfig.Attribute.bonus(ARMOR_TOUGHNESS,ursineArmorToughnessT3)
                                    )))).armorSet();


    public static void register(Map<String, ItemConfig.ArmorSet> configs) {
        Armor.register(configs, entries, WitcherGroup.WITCHER_KEY);
    }
}
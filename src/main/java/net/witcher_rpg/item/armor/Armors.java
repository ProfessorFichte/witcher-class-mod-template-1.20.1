package net.witcher_rpg.item.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.spell_power.api.SpellPowerMechanics;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.item.WitcherGroup;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.armor.Armor;
import net.witcher_rpg.item.WitcherItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

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
    private static final Supplier<Ingredient> URSINE_INGREDIENTS = () -> Ingredient.ofItems(
            Items.CHAIN, WitcherItems.STEEL_INGOT, WitcherItems.DARK_IRON_INGOT, WitcherItems.DARK_STEEL_INGOT
    );

    ////MODIFIERS
    //TIER1 MODIFIERS
    private static final float witcherSign = 0.15F;
    public static final float witcherAdrenaline = 0.03F;
    private static final float witcherAttackDamage = 0.03F;

    //FELINE MODIFIERS
    private static final float felineAttackSpeedT2 = 0.05F;
    private static final float felineAdrenalineT2 = 0.04F;
    private static final float felineAttackDamageT2 = 0.02F;

    private static final float felineAttackSpeedT3 = 0.05F;
    private static final float felineAdrenalineT3 = 0.075F;
    private static final float felineAttackDamageT3 = 0.03F;
    private static final float felineRollRechargeT3 = 0.05F;

    //GRIFFIN MODIFIERS
    private static final float griffinSignT2 = 0.25F;
    public static final float griffinAdrenalineT2 = 0.025F;
    public static final float griffinHasteT2 = 0.02F;

    private static final float griffinSignT3 = 0.3F;
    public static final float griffinAdrenalineT3 = 0.05F;
    public static final float griffinHasteT3 = 0.02F;

    //URSINE MODIFIERS
    private static final float ursineKnockBackResiT2 = 0.1F;
    private static final float ursineAdrenalineT2 = 0.075F;
    private static final float ursineAttackDamageT2 = 0.04F;

    private static final float ursineKnockBackResiT3 = 0.1F;
    private static final float ursineAdrenalineT3 = 0.10F;
    private static final float ursineAttackDamageT3 = 0.04F;
    private static final float ursineArmorToughnessT3 = 1.0F;

    public static final ArrayList<Armor.Entry> entries = new ArrayList<>();
    private static Armor.Entry create(Armor.CustomMaterial material, ItemConfig.ArmorSet defaults) {
        return new Armor.Entry(material, null, defaults);
    }
    public static final Armor.Set witcherArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "witcher",
                            15,
                            9,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            WITCHER_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),witcherSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),witcherSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),witcherSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),witcherSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),witcherAttackDamage)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new WitcherArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);

    public static final Armor.Set catSchoolArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "feline",
                            20,
                            10,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            WITCHER_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeedT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeedT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeedT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeedT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamageT2)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new CatSchoolArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);

    public static final Armor.Set ursineArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "ursine",
                            20,
                            10,
                            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
                            WITCHER_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.knockback_resistance")),ursineKnockBackResiT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(6)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.knockback_resistance")),ursineKnockBackResiT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(6)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.knockback_resistance")),ursineKnockBackResiT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamageT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.knockback_resistance")),ursineKnockBackResiT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenalineT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamageT2)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new BearSchoolArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new BearSchoolArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new BearSchoolArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new BearSchoolArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);

    public static final Armor.Set griffinArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "griffin",
                            20,
                            10,
                            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                            WITCHER_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSignT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenalineT2),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(5)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSignT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenalineT2),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSignT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenalineT2),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT2)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSignT2),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenalineT2),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT2)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new GriffinSchoolArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new GriffinSchoolArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new GriffinSchoolArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new GriffinSchoolArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);
    //SUPERIOR
    public static final Armor.Set superiorCatSchoolArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "superior_feline",
                            25,
                            15,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            WITCHER_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeedT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamageT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("combatroll:recharge")),felineRollRechargeT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeedT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamageT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("combatroll:recharge")),felineRollRechargeT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeedT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamageT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("combatroll:recharge")),felineRollRechargeT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeedT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamageT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("combatroll:recharge")),felineRollRechargeT3)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new CatSchoolArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);

    public static final Armor.Set superiorUrsineArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "superior_ursine",
                            25,
                            15,
                            SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
                            WITCHER_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.knockback_resistance")),ursineKnockBackResiT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamageT3),
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.armor_toughness")),ursineArmorToughnessT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(8)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.knockback_resistance")),ursineKnockBackResiT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamageT3),
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.armor_toughness")),ursineArmorToughnessT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(6)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.knockback_resistance")),ursineKnockBackResiT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamageT3),
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.armor_toughness")),ursineArmorToughnessT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.knockback_resistance")),ursineKnockBackResiT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenalineT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamageT3),
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.armor_toughness")),ursineArmorToughnessT3)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new BearSchoolArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new BearSchoolArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new BearSchoolArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new BearSchoolArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);

    public static final Armor.Set superiorGriffinArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "superior_griffin",
                            25,
                            15,
                            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                            WITCHER_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSignT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenalineT3),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(5)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSignT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenalineT3),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSignT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenalineT3),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT3)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSignT3),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenalineT3),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHasteT3)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new GriffinSchoolArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new GriffinSchoolArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new GriffinSchoolArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new GriffinSchoolArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);

    public static void register(Map<String, ItemConfig.ArmorSet> configs) {
        Armor.register(configs, entries, WitcherGroup.WITCHER_KEY);
    }
}
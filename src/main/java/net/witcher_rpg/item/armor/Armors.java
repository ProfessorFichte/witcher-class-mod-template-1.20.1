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

    private static final float felineAttackSpeed = 0.02F;
    private static final float felineAttackDamage = 0.04F;
    private static final float felineAdrenaline = 0.10F;

    private static final float ursineHealth = 2.0F;
    private static final float ursineAttackDamage = 0.04F;
    private static final float ursineAdrenaline = 0.10F;

    private static final float witcherSign = 1.0F;
    public static final float witcherAdrenaline = 0.075F;
    private static final float witcherAttackDamage = 0.03F;

    private static final float griffinSign = 0.25F;
    public static final float griffinAdrenaline = 0.075F;
    private static final float griffinHaste = 0.03F;

    public static final ArrayList<Armor.Entry> entries = new ArrayList<>();
    private static Armor.Entry create(Armor.CustomMaterial material, ItemConfig.ArmorSet defaults) {
        return new Armor.Entry(material, null, defaults);
    }

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
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeed),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeed),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeed),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_speed")),felineAttackSpeed),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),felineAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),felineAttackDamage)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new CatSchoolArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new CatSchoolArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);

    public static final Armor.Set witcherArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "witcher",
                            20,
                            10,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            WITCHER_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),witcherSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(5)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),witcherSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),witcherSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),witcherAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),witcherAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),witcherSign),
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
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.max_health")),ursineHealth),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(6)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.max_health")),ursineHealth),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(6)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.max_health")),ursineHealth),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamage)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.bonus(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.max_health")),ursineHealth),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),ursineAdrenaline),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("minecraft:generic.attack_damage")),ursineAttackDamage)
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
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenaline),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(5)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenaline),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenaline),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:sign_intensity")),griffinSign),
                                            ItemConfig.Attribute.multiply(Objects.requireNonNull(Identifier.tryParse("witcher_rpg:adrenaline_modifier")),griffinAdrenaline),
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, griffinHaste)
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
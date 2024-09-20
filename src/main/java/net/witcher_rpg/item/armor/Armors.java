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
import java.util.Objects;
import java.util.function.Supplier;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

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

    public static RegistryEntry<ArmorMaterial> material_feline = material(
            "feline",
            2, 4, 4, 2,
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WITCHER_INGREDIENTS);

    public static RegistryEntry<ArmorMaterial> material_witcher = material(
            "witcher",
            2, 5, 4, 3,
            11,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WITCHER_INGREDIENTS);
    public static RegistryEntry<ArmorMaterial> material_ursine = material(
            "ursine",
            2, 6, 6, 3,
            9,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WITCHER_INGREDIENTS);

    public static RegistryEntry<ArmorMaterial> material_griffin = material(
            "griffin",
            2, 5, 4, 3,
            11,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, WITCHER_INGREDIENTS);

    public static final Armor.Set catSchoolArmorSet =
            create(
                    material_feline,
                    Identifier.of(MOD_ID, "feline"),
                    20,
                    CatSchoolArmor::new,
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
                    ))
                    .armorSet();

    public static final Armor.Set witcherArmorSet =
            create(
                    material_witcher,
                    Identifier.of(MOD_ID, "witcher"),
                    20,
                    WitcherArmor::new,
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
                    ))
                    .armorSet();

    public static final Armor.Set ursineArmorSet =
            create(
                    material_ursine,
                    Identifier.of(MOD_ID, "ursine"),
                    20,
                    BearSchoolArmor::new,
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
                    ))
                    .armorSet();

    public static final Armor.Set griffinArmorSet =
            create(
                    material_griffin,
                    Identifier.of(MOD_ID, "griffin"),
                    20,
                    GriffinSchoolArmor::new,
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
                    ))
                    .armorSet();

    public static void register(Map<String, ItemConfig.ArmorSet> configs) {
        Armor.register(configs, entries, WitcherGroup.WITCHER_KEY);
    }
}
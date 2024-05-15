package net.witcher_rpg.item.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.more_rpg_classes.item.MRPGCItems;
import net.spell_power.api.SpellPowerMechanics;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.item.WitcherGroup;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.item.armor.Armor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Armors {
    private static final Supplier<Ingredient> NORTHLING_INGREDIENTS = () -> Ingredient.ofItems(
            Items.IRON_INGOT, Items.CHAIN, MRPGCItems.WOLF_FUR
    );

    private static final float adeptSuitCritDmg = 0.05F;
    private static final float witcherSuitCritDmg = 0.1F;
    public static final float adeptHaste = 0.01F;
    public static final float witcherHaste = 0.01F;

    public static final ArrayList<Armor.Entry> entries = new ArrayList<>();
    private static Armor.Entry create(Armor.CustomMaterial material, ItemConfig.ArmorSet defaults) {
        return new Armor.Entry(material, null, defaults);
    }

    public static final Armor.Set adeptArmorSet =
            create(
                    new Armor.CustomMaterial(
                            "adept",
                            10,
                            9,
                            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                            NORTHLING_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, adeptHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, adeptSuitCritDmg)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, adeptHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(1)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, adeptHaste)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new AdeptArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new AdeptArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new AdeptArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new AdeptArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
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
                            NORTHLING_INGREDIENTS
                    ),
                    ItemConfig.ArmorSet.with(
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, witcherHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(4)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.CRITICAL_DAMAGE.id, witcherSuitCritDmg)
                                    )),
                            new ItemConfig.ArmorSet.Piece(3)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, witcherHaste)
                                    )),
                            new ItemConfig.ArmorSet.Piece(2)
                                    .addAll(List.of(
                                            ItemConfig.Attribute.multiply(SpellPowerMechanics.HASTE.id, witcherHaste)
                                    ))
                    ))   .bundle(material -> new Armor.Set<>(WitcherClassMod.MOD_ID,
                            new WitcherArmor(material, ArmorItem.Type.HELMET, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.CHESTPLATE, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.LEGGINGS, new Item.Settings()),
                            new WitcherArmor(material, ArmorItem.Type.BOOTS, new Item.Settings())
                    ))
                    .put(entries).armorSet()
                    .allowSpellPowerEnchanting(true);


    public static void register(Map<String, ItemConfig.ArmorSet> configs) {
        Armor.register(configs, entries, WitcherGroup.WITCHER_KEY);
    }
}
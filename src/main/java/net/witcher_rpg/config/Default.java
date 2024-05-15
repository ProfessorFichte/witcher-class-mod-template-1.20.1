package net.witcher_rpg.config;

import net.witcher_rpg.item.armor.Armors;
import net.witcher_rpg.item.weapon.WeaponsRegister;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.loot.LootConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Default {
    public final static ItemConfig itemConfig;
    public final static LootConfig lootConfig;

    static {
        itemConfig = new ItemConfig();
        for (var armorSet : Armors.entries) {
            itemConfig.armor_sets.put(armorSet.name(), armorSet.defaults());
        }
        for (var weapon: WeaponsRegister.entries) {
            itemConfig.weapons.put(weapon.name(), weapon.defaults());
        }

        lootConfig = new LootConfig();


        final var weapons_epic = "weapons_epic";
        lootConfig.item_groups.put(weapons_epic, new LootConfig.ItemGroup(List.of(
                WeaponsRegister.ultimatum.id().toString(),
                WeaponsRegister.winters_blade.id().toString()),
                1
        ).chance(0.15F));

        final var weapons_legend = "weapons_legend";
        lootConfig.item_groups.put(weapons_legend, new LootConfig.ItemGroup(List.of(
                WeaponsRegister.aerondight.id().toString()),
                1
        ).chance(0.1F));



        List.of("minecraft:chests/end_city_treasure",
                        "minecraft:chests/bastion_treasure",
                        "minecraft:chests/ancient_city",
                        "minecraft:chests/stronghold_library")
                .forEach(id -> lootConfig.loot_tables.put(id, List.of(weapons_epic,weapons_legend)));

    }

    @SafeVarargs
    private static <T> List<T> joinLists(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
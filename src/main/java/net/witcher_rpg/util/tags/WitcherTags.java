package net.witcher_rpg.util.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.witcher_rpg.WitcherClassMod;

public class WitcherTags {

    public static final TagKey<Item> SILVER_SWORDS= register("silver_swords");

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, WitcherClassMod.id(id));
    }
}

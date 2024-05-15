package net.witcher_rpg.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.more_rpg_classes.MRPGCMod;
import net.witcher_rpg.WitcherClassMod;

public class WitcherGroup {
    public static Identifier ID = new Identifier(WitcherClassMod.MOD_ID, "generic");
    public static RegistryKey<ItemGroup> WITCHER_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),new Identifier(WitcherClassMod.MOD_ID,"generic"));
    public static ItemGroup WITCHER;



    public static void registerItemGroups() {
        MRPGCMod.LOGGER.info("Registering Item Groups for " + WitcherClassMod.MOD_ID);
    }
}
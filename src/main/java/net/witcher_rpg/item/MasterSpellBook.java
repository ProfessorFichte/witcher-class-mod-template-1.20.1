package net.witcher_rpg.item;

import net.minecraft.util.Identifier;
import net.spell_engine.api.item.trinket.SpellBookTrinketItem;

public class MasterSpellBook extends SpellBookTrinketItem {
    public MasterSpellBook(Identifier poolId, Settings settings) {
        super(poolId, settings.fireproof());
    }
}

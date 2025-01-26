package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.item.armor.WitcherArmor;
import net.witcher_rpg.WitcherClassMod;

public class WitcherArmorModel extends GeoModel<WitcherArmor> {
    @Override
    public Identifier getModelResource(WitcherArmor object) {
        return new Identifier(WitcherClassMod.MOD_ID, "geo/witcher_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WitcherArmor armor) {
        return new Identifier(WitcherClassMod.MOD_ID, "textures/armor/witcher.png");
    }

    @Override
    public Identifier getAnimationResource(WitcherArmor animatable) {
        return null;
    }
}

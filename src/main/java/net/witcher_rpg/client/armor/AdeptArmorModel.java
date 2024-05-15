package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.item.armor.AdeptArmor;
import net.witcher_rpg.WitcherClassMod;

public class AdeptArmorModel extends GeoModel<AdeptArmor> {
    @Override
    public Identifier getModelResource(AdeptArmor object) {
        return new Identifier(WitcherClassMod.MOD_ID, "geo/adept_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(AdeptArmor armor) {
        return new Identifier(WitcherClassMod.MOD_ID, "textures/armor/adept_armor.png");
    }

    @Override
    public Identifier getAnimationResource(AdeptArmor animatable) {
        return null;
    }
}

package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.item.armor.BearSchoolArmor;

public class BearSchoolArmorModel extends GeoModel<BearSchoolArmor> {
    @Override
    public Identifier getModelResource(BearSchoolArmor object) {
        return new Identifier(WitcherClassMod.MOD_ID, "geo/ursine_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(BearSchoolArmor armor) {
        return new Identifier(WitcherClassMod.MOD_ID, "textures/armor/ursine_armor.png");
    }

    @Override
    public Identifier getAnimationResource(BearSchoolArmor animatable) {
        return null;
    }
}


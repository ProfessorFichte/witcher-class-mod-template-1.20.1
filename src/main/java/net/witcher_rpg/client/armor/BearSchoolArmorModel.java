package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.item.armor.BearSchoolArmor;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class BearSchoolArmorModel extends GeoModel<BearSchoolArmor> {
    @Override
    public Identifier getModelResource(BearSchoolArmor object) {
        return new Identifier(MOD_ID, "geo/ursine_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(BearSchoolArmor armor) {
        var texture = armor.customMaterial.name();
        return new Identifier(MOD_ID, "textures/armor/" + texture +".png");
    }

    @Override
    public Identifier getAnimationResource(BearSchoolArmor animatable) {
        return null;
    }
}


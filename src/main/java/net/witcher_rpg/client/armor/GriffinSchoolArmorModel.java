package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.item.armor.GriffinSchoolArmor;

public class GriffinSchoolArmorModel extends GeoModel<GriffinSchoolArmor> {
    @Override
    public Identifier getModelResource(GriffinSchoolArmor object) {
        return new Identifier(WitcherClassMod.MOD_ID, "geo/griffin_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(GriffinSchoolArmor armor) {
        return new Identifier(WitcherClassMod.MOD_ID, "textures/armor/griffin_armor.png");
    }

    @Override
    public Identifier getAnimationResource(GriffinSchoolArmor animatable) {
        return null;
    }
}
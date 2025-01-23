package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.item.armor.GriffinSchoolArmor;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class GriffinSchoolArmorModel extends GeoModel<GriffinSchoolArmor> {
    @Override
    public Identifier getModelResource(GriffinSchoolArmor object) {
        return new Identifier(WitcherClassMod.MOD_ID, "geo/griffin_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(GriffinSchoolArmor armor) {
        var texture = armor.customMaterial.name();
        return new Identifier(MOD_ID, "textures/armor/" + texture +".png");
    }

    @Override
    public Identifier getAnimationResource(GriffinSchoolArmor animatable) {
        return null;
    }
}
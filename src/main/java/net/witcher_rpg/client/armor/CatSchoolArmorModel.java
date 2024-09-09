package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.item.armor.CatSchoolArmor;
import net.witcher_rpg.WitcherClassMod;

public class CatSchoolArmorModel extends GeoModel<CatSchoolArmor> {
    @Override
    public Identifier getModelResource(CatSchoolArmor object) {
        return new Identifier(WitcherClassMod.MOD_ID, "geo/feline_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(CatSchoolArmor armor) {
        return new Identifier(WitcherClassMod.MOD_ID, "textures/armor/feline_armor.png");
    }

    @Override
    public Identifier getAnimationResource(CatSchoolArmor animatable) {
        return null;
    }
}

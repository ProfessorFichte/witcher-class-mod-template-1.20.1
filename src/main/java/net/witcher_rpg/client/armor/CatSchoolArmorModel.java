package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.item.armor.CatSchoolArmor;
import net.witcher_rpg.WitcherClassMod;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class CatSchoolArmorModel extends GeoModel<CatSchoolArmor> {
    @Override
    public Identifier getModelResource(CatSchoolArmor object) {
        return Identifier.of(WitcherClassMod.MOD_ID, "geo/feline_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(CatSchoolArmor armor) {
        var textureId = armor.getFirstLayerId();
        return Identifier.of(MOD_ID, "textures/armor/"+ textureId.getPath() + ".png");
    }

    @Override
    public Identifier getAnimationResource(CatSchoolArmor animatable) {
        return null;
    }
}

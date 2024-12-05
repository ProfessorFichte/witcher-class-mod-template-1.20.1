package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.item.armor.BearSchoolArmor;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class BearSchoolArmorModel extends GeoModel<BearSchoolArmor> {
    @Override
    public Identifier getModelResource(BearSchoolArmor object) {
        return Identifier.of(MOD_ID, "geo/ursine_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(BearSchoolArmor armor) {
        var textureId = armor.getFirstLayerId();
        return Identifier.of(MOD_ID, "textures/armor/"+ textureId.getPath() + ".png");
    }

    @Override
    public Identifier getAnimationResource(BearSchoolArmor animatable) {
        return null;
    }
}


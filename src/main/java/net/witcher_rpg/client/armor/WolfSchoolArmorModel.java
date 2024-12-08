package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.item.armor.WolfSchoolArmor;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class WolfSchoolArmorModel extends GeoModel<WolfSchoolArmor> {
    @Override
    public Identifier getModelResource(WolfSchoolArmor object) {
        return Identifier.of(MOD_ID, "geo/wolven_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WolfSchoolArmor armor) {
        var textureId = armor.getFirstLayerId();
        return Identifier.of(MOD_ID, "textures/armor/"+ textureId.getPath() + ".png");
    }

    @Override
    public Identifier getAnimationResource(WolfSchoolArmor animatable) {
        return null;
    }
}


package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.model.GeoModel;
import net.minecraft.util.Identifier;
import net.witcher_rpg.WitcherClassMod;
import net.witcher_rpg.item.armor.GriffinSchoolArmor;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class GriffinSchoolArmorModel extends GeoModel<GriffinSchoolArmor> {
    @Override
    public Identifier getModelResource(GriffinSchoolArmor object) {
        return Identifier.of(WitcherClassMod.MOD_ID, "geo/griffin_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(GriffinSchoolArmor armor) {
        var textureId = armor.getFirstLayerId();
        return Identifier.of(MOD_ID, "textures/armor/"+ textureId.getPath() + ".png");
    }

    @Override
    public Identifier getAnimationResource(GriffinSchoolArmor animatable) {
        return null;
    }
}
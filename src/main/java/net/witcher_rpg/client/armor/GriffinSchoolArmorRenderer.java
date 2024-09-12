package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import net.witcher_rpg.item.armor.GriffinSchoolArmor;

public class GriffinSchoolArmorRenderer extends GeoArmorRenderer<GriffinSchoolArmor> {
    public GriffinSchoolArmorRenderer() {
        super(new GriffinSchoolArmorModel());
    }
}

package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.witcher_rpg.item.armor.BearSchoolArmor;

public class BearSchoolArmorRenderer extends GeoArmorRenderer<BearSchoolArmor> {
    public BearSchoolArmorRenderer () {
        super(new BearSchoolArmorModel());
    }
}


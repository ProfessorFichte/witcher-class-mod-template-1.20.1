package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import net.witcher_rpg.item.armor.CatSchoolArmor;

public class CatSchoolArmorRenderer extends GeoArmorRenderer<CatSchoolArmor> {
    public CatSchoolArmorRenderer() {
        super(new CatSchoolArmorModel());
    }
}
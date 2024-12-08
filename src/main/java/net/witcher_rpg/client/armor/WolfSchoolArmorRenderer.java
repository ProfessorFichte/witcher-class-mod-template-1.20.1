package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import net.witcher_rpg.item.armor.WolfSchoolArmor;

public class WolfSchoolArmorRenderer extends GeoArmorRenderer<WolfSchoolArmor> {
    public WolfSchoolArmorRenderer() {
        super(new WolfSchoolArmorModel());
    }
}


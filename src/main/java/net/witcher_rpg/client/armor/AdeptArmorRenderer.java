package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.witcher_rpg.item.armor.AdeptArmor;

public class AdeptArmorRenderer extends GeoArmorRenderer<AdeptArmor> {
    public AdeptArmorRenderer() {
        super(new AdeptArmorModel());
    }
}
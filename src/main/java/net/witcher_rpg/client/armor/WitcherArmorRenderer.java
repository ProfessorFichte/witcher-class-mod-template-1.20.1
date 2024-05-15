package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.witcher_rpg.item.armor.WitcherArmor;

public class WitcherArmorRenderer extends GeoArmorRenderer<WitcherArmor> {
    public WitcherArmorRenderer() {
        super(new WitcherArmorModel());
    }
}

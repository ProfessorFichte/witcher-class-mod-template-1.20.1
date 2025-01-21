package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRendererConfig;
import net.minecraft.util.Identifier;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class BearSchoolArmorRenderer extends AzArmorRenderer {
    public static BearSchoolArmorRenderer ursine() {
        return new BearSchoolArmorRenderer("ursine_armor", "ursine");
    }
    public static BearSchoolArmorRenderer enhanced_ursine() {
        return new BearSchoolArmorRenderer("ursine_armor", "enhanced_ursine");
    }
    public static BearSchoolArmorRenderer superior_ursine() {
        return new BearSchoolArmorRenderer("ursine_armor", "superior_ursine");
    }

    public BearSchoolArmorRenderer(String modelName, String textureName) {
        super(AzArmorRendererConfig.builder(
                Identifier.of(MOD_ID, "geo/" + modelName + ".geo.json"),
                Identifier.of(MOD_ID, "textures/armor/" + textureName + ".png")
        ).build());
    }
}



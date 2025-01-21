package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRendererConfig;
import net.minecraft.util.Identifier;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class GriffinSchoolArmorRenderer extends AzArmorRenderer {
    public static GriffinSchoolArmorRenderer griffin() {
        return new GriffinSchoolArmorRenderer("griffin_armor", "griffin");
    }
    public static GriffinSchoolArmorRenderer enhanced_griffin() {
        return new GriffinSchoolArmorRenderer("griffin_armor", "enhanced_griffin");
    }
    public static GriffinSchoolArmorRenderer superior_griffin() {
        return new GriffinSchoolArmorRenderer("griffin_armor", "superior_griffin");
    }

    public GriffinSchoolArmorRenderer(String modelName, String textureName) {
        super(AzArmorRendererConfig.builder(
                Identifier.of(MOD_ID, "geo/" + modelName + ".geo.json"),
                Identifier.of(MOD_ID, "textures/armor/" + textureName + ".png")
        ).build());
    }
}

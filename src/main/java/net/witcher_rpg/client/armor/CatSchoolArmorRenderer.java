package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRendererConfig;
import net.minecraft.util.Identifier;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class CatSchoolArmorRenderer extends AzArmorRenderer {
    public static CatSchoolArmorRenderer feline() {
        return new CatSchoolArmorRenderer("feline_armor", "feline");
    }
    public static CatSchoolArmorRenderer enhanced_feline() {
        return new CatSchoolArmorRenderer("feline_armor", "enhanced_feline");
    }
    public static CatSchoolArmorRenderer superior_feline() {
        return new CatSchoolArmorRenderer("feline_armor", "superior_feline");
    }

    public CatSchoolArmorRenderer(String modelName, String textureName) {
        super(AzArmorRendererConfig.builder(
                Identifier.of(MOD_ID, "geo/" + modelName + ".geo.json"),
                Identifier.of(MOD_ID, "textures/armor/" + textureName + ".png")
        ).build());
    }
}

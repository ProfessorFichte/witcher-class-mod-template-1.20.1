package net.witcher_rpg.client.armor;

import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRendererConfig;
import net.minecraft.util.Identifier;
import static net.witcher_rpg.WitcherClassMod.MOD_ID;

public class WolfSchoolArmorRenderer extends AzArmorRenderer {
    public static WolfSchoolArmorRenderer wolven() {
        return new WolfSchoolArmorRenderer("wolven_armor", "wolven");
    }
    public static WolfSchoolArmorRenderer enhanced_wolven() {
        return new WolfSchoolArmorRenderer("wolven_armor", "enhanced_wolven");
    }
    public static WolfSchoolArmorRenderer superior_wolven() {
        return new WolfSchoolArmorRenderer("wolven_armor", "superior_wolven");
    }

    public WolfSchoolArmorRenderer(String modelName, String textureName) {
        super(AzArmorRendererConfig.builder(
                Identifier.of(MOD_ID, "geo/" + modelName + ".geo.json"),
                Identifier.of(MOD_ID, "textures/armor/" + textureName + ".png")
        ).build());
    }
}

package net.witcher_rpg.entity.attribute;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.witcher_rpg.WitcherClassMod;

public class WitcherAttributes {
    public static EntityAttribute SIGN_INTENSITY = createAttribute(
            "sign_intensity", 0.0, 0.0, 1024.0);
    public static EntityAttribute ADRENALINE_MODIFIER = createAttribute(
            "adrenaline_modifier", 100.0, 100.0, 1024.0);
    public static EntityAttribute AARD_INTENSITY = createAttribute(
            "aard_intensity", 0.0, 0.0, 1024.0);
    public static EntityAttribute AXII_INTENSITY = createAttribute(
            "axii_intensity", 0.0, 0.0, 1024.0);
    public static EntityAttribute IGNI_INTENSITY = createAttribute(
            "igni_intensity", 0.0, 0.0, 1024.0);
    public static EntityAttribute QUEN_INTENSITY = createAttribute(
            "quen_intensity", 0.0, 0.0, 1024.0);
    public static EntityAttribute YRDEN_INTENSITY = createAttribute(
            "yrden_intensity", 0.0, 0.0, 1024.0);


    public static void registerAttributes(){
        register("sign_intensity", SIGN_INTENSITY);
        register("adrenaline_modifier", ADRENALINE_MODIFIER);
        register("aard_intensity", AARD_INTENSITY);
        register("axii_intensity", AXII_INTENSITY);
        register("igni_intensity", IGNI_INTENSITY);
        register("quen_intensity", QUEN_INTENSITY);
        register("yrden_intensity", YRDEN_INTENSITY);
    }


    public static EntityAttribute register(String id, EntityAttribute attribute){
        return Registry.register(Registries.ATTRIBUTE, new Identifier(WitcherClassMod.MOD_ID, id), attribute);
    }
    private static EntityAttribute createAttribute(final String name, double base, double min, double max){
        return new ClampedEntityAttribute("attribute.name.generic." + WitcherClassMod.MOD_ID + '.' +name, base, min, max).setTracked(true);
    }
}

package net.witcher_rpg.client.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.witcher_rpg.WitcherClassMod.MOD_ID;
public class Particles {
    public static final DefaultParticleType IGNI_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType YRDEN_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType AARD_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType QUEN_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType AXII_SIGN = FabricParticleTypes.simple();
    public static final DefaultParticleType YRDEN_IMPACT = FabricParticleTypes.simple();
    public static final DefaultParticleType YRDEN_CLOUD = FabricParticleTypes.simple();




    public static void register(){
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "igni_sign_cast"), IGNI_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "yrden_sign_cast"), YRDEN_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "aard_sign_cast"), AARD_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "quen_sign_cast"), QUEN_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "axii_sign_cast"), AXII_SIGN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "yrden_impact"), YRDEN_IMPACT);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "yrden_cloud"), YRDEN_CLOUD);
    }
}

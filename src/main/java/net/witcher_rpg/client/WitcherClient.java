package net.witcher_rpg.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.*;
import net.spell_engine.api.effect.CustomModelStatusEffect;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.render.CustomModels;
import net.witcher_rpg.client.effect.AxiiParticles;
import net.witcher_rpg.client.effect.QuenActiveShieldRenderer;
import net.witcher_rpg.client.entity.YrdenMagicTrapRenderer;
import net.witcher_rpg.client.entity.YrdenRenderer;
import net.witcher_rpg.client.particle.Particles;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.YrdenEntity;
import net.witcher_rpg.entity.YrdenMagicTrapEntity;


import java.util.List;

@Environment(EnvType.CLIENT)
public class WitcherClient implements ClientModInitializer {

    public void  onInitializeClient(){
        CustomModels.registerModelIds(List.of(
        YrdenRenderer.modelId,
        YrdenMagicTrapRenderer.modelId,
        QuenActiveShieldRenderer.modelId
        ));

        ParticleFactoryRegistry.getInstance().register(Particles.IGNI_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(Particles.YRDEN_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(Particles.AARD_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(Particles.QUEN_SIGN, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(Particles.AXII_SIGN, FireworksSparkParticle.ExplosionFactory::new);
        ParticleFactoryRegistry.getInstance().register(Particles.YRDEN_IMPACT, DamageParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(Particles.YRDEN_CLOUD, DragonBreathParticle.Factory::new);

        CustomParticleStatusEffect.register(Effects.AXII, new AxiiParticles(1));

        CustomModelStatusEffect.register(Effects.QUEN_ACTIVE, new QuenActiveShieldRenderer());

        EntityRendererRegistry.register(YrdenEntity.ENTITY_TYPE,YrdenRenderer::new);
        EntityRendererRegistry.register(YrdenMagicTrapEntity.ENTITY_TYPE,YrdenMagicTrapRenderer::new);
    }


}

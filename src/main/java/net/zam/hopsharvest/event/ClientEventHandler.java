package net.zam.hopsharvest.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zam.hopsharvest.HopsHarvest;
import net.zam.hopsharvest.particles.YellowBubbleParticles;
import net.zam.hopsharvest.registry.ZAMParticles;

@Mod.EventBusSubscriber(modid = HopsHarvest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ZAMParticles.YELLOW_BUBBLES.get(), YellowBubbleParticles.Provider::new);
    }
}


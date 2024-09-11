package net.zam.hopsharvest.event.handler;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zam.hopsharvest.HopsHarvest;
import net.zam.hopsharvest.registry.ZAMEffects;
import net.zam.hopsharvest.registry.ZAMSounds;

@Mod.EventBusSubscriber(modid = HopsHarvest.MOD_ID, value = Dist.DEDICATED_SERVER)
public class StardropEffectHandler {
    @SubscribeEvent
    public static void onPotionAdded(MobEffectEvent.Added event) {
        if (event.getEffectInstance().getEffect() == ZAMEffects.STARDROP.get()) {
            LivingEntity entity = event.getEntity();
            if (!entity.level().isClientSide) {
                if (entity instanceof ServerPlayer) {
                    ServerLevel serverWorld = (ServerLevel) entity.level();
                    serverWorld.playSound(null, entity.blockPosition(), ZAMSounds.STARDROP.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                    HopsHarvest.LOGGER.info("Played Stardrop sound for player: " + entity.getName().getString());
                }
            }
        }
    }
}

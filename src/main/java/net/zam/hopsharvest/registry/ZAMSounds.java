package net.zam.hopsharvest.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zam.hopsharvest.HopsHarvest;

public class ZAMSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HopsHarvest.MOD_ID);


    //Faded
    public static final RegistryObject<SoundEvent> FADED_EFFECT_BEGIN = registerSoundEvent("potion_effect_begin");
    public static final RegistryObject<SoundEvent> FADED_EFFECT_END = registerSoundEvent("potion_effect_end");


    //Stardrop
    public static final RegistryObject<SoundEvent> STARDROP = registerSoundEvent("stardrop");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(HopsHarvest.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

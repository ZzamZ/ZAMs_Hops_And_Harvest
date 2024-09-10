package net.zam.hopandharvest;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.zam.hopandharvest.event.ClientEventHandler;
import net.zam.hopandharvest.gui.keg.KegScreen;
import net.zam.hopandharvest.registry.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HopsHarvest.MOD_ID)
public class HopsHarvest {
    public static final String MOD_ID = "hopsharvest";
    public static final Logger LOGGER = LogManager.getLogger();

    public HopsHarvest() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ZAMItems.register(modEventBus);
        ZAMBlocks.register(modEventBus);
        ZAMBlockEntities.register(modEventBus);
        ZAMSounds.register(modEventBus);
        ZAMCreativeModeTab.register(modEventBus);
        ZAMEffects.register(modEventBus);
        ZAMMenuTypes.register(modEventBus);
        ZAMParticles.register(modEventBus);
        ZAMRecipes.register(modEventBus);
        ZAMLootModifiers.register(modEventBus);

        modEventBus.addListener(this::setupClient);

        MinecraftForge.EVENT_BUS.register(this);

    }
    private void setupClient(final FMLClientSetupEvent event) {
        MenuScreens.register(ZAMMenuTypes.KEG_MENU.get(), KegScreen::new);
    }
}

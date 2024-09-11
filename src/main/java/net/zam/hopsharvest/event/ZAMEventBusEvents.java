package net.zam.hopsharvest.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.zam.hopsharvest.HopsHarvest;
import net.zam.hopsharvest.recipes.KegRecipe;

@Mod.EventBusSubscriber(modid = HopsHarvest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZAMEventBusEvents {
    @SubscribeEvent
    public static void registerRecipeTypes(final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, (helper) -> {
            helper.register(KegRecipe.Type.ID, KegRecipe.Type.INSTANCE);
        });
    }
}
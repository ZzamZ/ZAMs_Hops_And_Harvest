package net.zam.hopandharvest.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zam.hopandharvest.HopsHarvest;

@Mod.EventBusSubscriber(modid = HopsHarvest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput packOutput = generator.getPackOutput();


            generator.addProvider(event.includeClient(), new ZAMGlobalLootModifierProvider(packOutput));
    }
}

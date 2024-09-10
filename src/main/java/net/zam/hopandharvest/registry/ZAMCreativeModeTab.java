package net.zam.hopandharvest.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zam.hopandharvest.HopsHarvest;

public class ZAMCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            HopsHarvest.MOD_ID);

    public static RegistryObject<CreativeModeTab> HOPSHARVEST = CREATIVE_MODE_TABS.register("hopsharvest", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ZAMItems.MUG_OF_ICE_BEER.get())).title(Component.literal("Hops & Harvest")).displayItems((displayParameters, output) -> {
                output.accept(ZAMItems.HOP.get());
                output.accept(ZAMItems.HOP_SEEDS.get());
                output.accept(ZAMItems.DRY_SEEDS.get());
                output.accept(ZAMItems.MUG_EMPTY.get());
                output.accept(ZAMItems.MUG_OF_CHORUS_ALE.get());
                output.accept(ZAMItems.MUG_OF_DIGGER_BITTER.get());
                output.accept(ZAMItems.MUG_OF_DROWNED_ALE.get());
                output.accept(ZAMItems.MUG_OF_ICE_BEER.get());
                output.accept(ZAMItems.MUG_OF_KVASS.get());
                output.accept(ZAMItems.MUG_OF_LEPRECHAUN_CIDER.get());
                output.accept(ZAMItems.MUG_OF_MAGNET_PILSNER.get());
                output.accept(ZAMItems.MUG_OF_NETHER_PORTER.get());
                output.accept(ZAMItems.MUG_OF_NIGHT_RAUCH.get());
                output.accept(ZAMItems.MUG_OF_SUN_PALE_ALE.get());
                output.accept(ZAMItems.MUG_OF_WITHER_STOUT.get());
                output.accept(ZAMItems.MUG_OF_NIMBUS_NECTAR.get());
                output.accept(ZAMItems.MUG_OF_STARDROP_SPARKLE.get());
                output.accept(ZAMBlocks.KEG.get());
            }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}

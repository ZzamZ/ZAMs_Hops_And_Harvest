package net.zam.hopandharvest.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zam.hopandharvest.HopsHarvest;
import net.zam.hopandharvest.item.MugItem;
import net.zam.hopandharvest.misc.ZAMBeerProperties;

public class ZAMItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HopsHarvest.MOD_ID);


    //Beer
    public static final RegistryObject<Item> HOP = ITEMS.register("hop", () -> new Item(new Item.Properties().food(ZAMBeerProperties.HOP)));
    public static final RegistryObject<Item> HOP_SEEDS = ITEMS.register("hop_seeds", () -> new ItemNameBlockItem(ZAMBlocks.HOP.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRY_SEEDS = ITEMS.register("dry_seeds", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MUG_EMPTY = ITEMS.register("mug_empty", () -> new MugItem(ZAMBlocks.MUG_EMPTY.get(), new Item.Properties()));
    public static final RegistryObject<Item> MUG_OF_CHORUS_ALE = ITEMS.register("mug_of_chorus_ale", () -> new MugItem(ZAMBlocks.MUG_OF_CHORUS_ALE.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.CHORUS_ALE)));
    public static final RegistryObject<Item> MUG_OF_DIGGER_BITTER = ITEMS.register("mug_of_digger_bitter", () -> new MugItem(ZAMBlocks.MUG_OF_DIGGER_BITTER.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.DIGGER_BITTER)));
    public static final RegistryObject<Item> MUG_OF_DROWNED_ALE = ITEMS.register("mug_of_drowned_ale", () -> new MugItem(ZAMBlocks.MUG_OF_DROWNED_ALE.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.DROWNED_ALE)));
    public static final RegistryObject<Item> MUG_OF_ICE_BEER = ITEMS.register("mug_of_ice_beer", () -> new MugItem(ZAMBlocks.MUG_OF_ICE_BEER.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.ICE_BEER)));
    public static final RegistryObject<Item> MUG_OF_KVASS = ITEMS.register("mug_of_kvass", () -> new MugItem(ZAMBlocks.MUG_OF_KVASS.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.KVASS)));
    public static final RegistryObject<Item> MUG_OF_LEPRECHAUN_CIDER = ITEMS.register("mug_of_leprechaun_cider", () -> new MugItem(ZAMBlocks.MUG_OF_LEPRECHAUN_CIDER.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.LEPRECHAUN_CIDER)));
    public static final RegistryObject<Item> MUG_OF_MAGNET_PILSNER = ITEMS.register("mug_of_magnet_pilsner", () -> new MugItem(ZAMBlocks.MUG_OF_MAGNET_PILSNER.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.MAGNET_PILSNER)));
    public static final RegistryObject<Item> MUG_OF_NETHER_PORTER = ITEMS.register("mug_of_nether_porter", () -> new MugItem(ZAMBlocks.MUG_OF_NETHER_PORTER.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.NETHER_PORTER)));
    public static final RegistryObject<Item> MUG_OF_NIGHT_RAUCH = ITEMS.register("mug_of_night_rauch", () -> new MugItem(ZAMBlocks.MUG_OF_NIGHT_RAUCH.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.NIGHT_RAUCH)));
    public static final RegistryObject<Item> MUG_OF_SUN_PALE_ALE = ITEMS.register("mug_of_sun_pale_ale", () -> new MugItem(ZAMBlocks.MUG_OF_SUN_PALE_ALE.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.SUN_PALE_ALE)));
    public static final RegistryObject<Item> MUG_OF_WITHER_STOUT = ITEMS.register("mug_of_wither_stout", () -> new MugItem(ZAMBlocks.MUG_OF_WITHER_STOUT.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.WITHER_STOUT)));
    public static final RegistryObject<Item> MUG_OF_NIMBUS_NECTAR = ITEMS.register("mug_of_nimbus_nectar", () -> new MugItem(ZAMBlocks.MUG_OF_NIMBUS_NECTAR.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.NIMBUS_NECTAR)));
    public static final RegistryObject<Item> MUG_OF_STARDROP_SPARKLE = ITEMS.register("mug_of_stardrop_sparkle", () -> new MugItem(ZAMBlocks.MUG_OF_STARDROP_SPARKLE.get(), new Item.Properties().stacksTo(16).food(ZAMBeerProperties.STARDROP_SPARKLE)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

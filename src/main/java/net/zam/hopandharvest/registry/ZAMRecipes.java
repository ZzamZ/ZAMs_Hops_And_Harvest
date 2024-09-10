package net.zam.hopandharvest.registry;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zam.hopandharvest.HopsHarvest;
import net.zam.hopandharvest.recipes.KegRecipe;

public class ZAMRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, HopsHarvest.MOD_ID);

    public static final RegistryObject<RecipeSerializer<KegRecipe>> KEG_SERIALIZER =
            SERIALIZERS.register("beer_brewing", () -> KegRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}

package net.zam.hopandharvest.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.zam.hopandharvest.recipes.KegRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return null;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new KegCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<KegRecipe> recipes = manager.getAllRecipesFor(KegRecipe.Type.INSTANCE);

        registration.addRecipes(new RecipeType<>(KegCategory.UID, KegRecipe.class), recipes);
    }
}
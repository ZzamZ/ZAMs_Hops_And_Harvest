package net.zam.hopsharvest.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.LiteralContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.zam.hopsharvest.HopsHarvest;
import net.zam.hopsharvest.recipes.KegRecipe;
import net.zam.hopsharvest.registry.ZAMBlocks;

public class KegCategory implements IRecipeCategory<KegRecipe> {

    public final static ResourceLocation UID = new ResourceLocation(HopsHarvest.MOD_ID, "beer_brewing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(HopsHarvest.MOD_ID, "textures/gui/jei_gui.png");

    private static final RecipeType<KegRecipe> TYPE = new RecipeType<>(UID, KegRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public KegCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 48);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ZAMBlocks.KEG.get()));
    }

    @Override
    public ResourceLocation getRegistryName(KegRecipe kegRecipe) {
        return UID;
    }

    @Override
    public RecipeType<KegRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return MutableComponent.create(new LiteralContents("Keg"));
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, KegRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 12, 16).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 36, 16).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 60, 16).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 84, 16).addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 148, 16).addItemStack(recipe.getResultItem());
    }
}
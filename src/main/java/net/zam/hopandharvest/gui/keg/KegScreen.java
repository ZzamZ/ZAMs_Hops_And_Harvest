package net.zam.hopandharvest.gui.keg;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.zam.hopandharvest.HopsHarvest;

public class KegScreen extends AbstractContainerScreen<KegMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(HopsHarvest.MOD_ID, "textures/gui/keg_gui.png");
    private static final ResourceLocation OVERLAY =
            new ResourceLocation(HopsHarvest.MOD_ID, "textures/gui/keg_overlay.png");
    private static final ResourceLocation BG =
            new ResourceLocation(HopsHarvest.MOD_ID, "textures/gui/dark_bg.png");

    private static final Fluid fluid = Fluids.WATER;

    private static final int[] BUBBLELENGTHS = new int[]{28, 24, 20, 16, 11, 6, 0};

    public KegScreen(KegMenu kegMenu, Inventory inventory, Component component) {
        super(kegMenu, inventory, component);
    }

    public static int rawColorFromRGB(int red, int green, int blue) {
        int rgb = Math.max(Math.min(0xFF, red), 0);
        rgb = (rgb << 8) + Math.max(Math.min(0xFF, green), 0);
        rgb = (rgb << 8) + Math.max(Math.min(0xFF, blue), 0);
        return rgb;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        // Using vanilla color codes for labels
        int titleColor = rawColorFromRGB(215, 171, 121);
        int inventoryColor = 0x404040;
        int timeColorShadow = rawColorFromRGB(97, 69, 36);
        int timeColor = rawColorFromRGB(215, 171, 121);

        // Title and inventory labels
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, titleColor, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, inventoryColor, false);

        // Timer label
        int timeX = 144 - 1;
        int timeY = 50 - 1;

        if (!menu.isCrafting()) {
            guiGraphics.drawString(this.font, "00:00", timeX + 1, timeY + 1, timeColorShadow, false);
            guiGraphics.drawString(this.font, "00:00", timeX, timeY, timeColor, false);
        } else {
            int time = this.menu.getProgress() / 20;
            int minutes = time / 60;
            int seconds = time % 60;

            String min = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);
            String sec = (seconds < 10) ? "0" + seconds : String.valueOf(seconds);

            guiGraphics.drawString(this.font, min + ":" + sec, timeX + 1, timeY + 1, timeColorShadow, false);
            guiGraphics.drawString(this.font, min + ":" + sec, timeX, timeY, timeColor, false);
        }
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        // Background
        RenderSystem.setShaderTexture(0, BG);

        int x = (width - imageWidth) / 2 + 3;
        int y = (height - imageHeight) / 2 + 3;

        guiGraphics.blit(BG, x, y, 0, 0, imageWidth - 6, imageHeight - 6);

        // Input fluid
        Fluid guiFluid = fluid;
        IClientFluidTypeExtensions fluidTypeExtensions = IClientFluidTypeExtensions.of(fluid);
        ResourceLocation location = fluidTypeExtensions.getStillTexture();
        TextureAtlasSprite sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(location);
        int color = fluidTypeExtensions.getTintColor();

        int z = this.menu.getWaterlevel();
        x = (width - sprite.contents().width()) / 2 - 80;
        y = (height - sprite.contents().height()) / 2 - 19 - z;

        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
        RenderSystem.setShaderColor(((color >> 16) & 0xFF) / 255f, ((color >> 8) & 0xFF) / 255f,
                (color & 0xFF) / 255f, ((color >> 24) & 0xFF) / 255f);

        for (int j = 0; j <= 3; j++) {
            for (int i = 0; i <= 8; i++) {
                guiGraphics.blit(x + 16 * i, y + 16 * j, 0, 16, 16, sprite);
            }
        }

        location = fluidTypeExtensions.getStillTexture();
        sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(location);

        z = this.menu.getBeerLevel();
        x = (width - sprite.contents().width()) / 2 - 80;
        y = (height - sprite.contents().height()) / 2 - 19 - z;

        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);

        if (menu.getBeerType() == 1) {
            RenderSystem.setShaderColor(222f / 255f, 167f / 255f, 81f / 255f, 1.0f);
        } else if (menu.getBeerType() == 2) {
            RenderSystem.setShaderColor(201f / 255f, 125f / 255f, 31f / 255f, 1.0f);
        } else if (menu.getBeerType() == 3) {
            RenderSystem.setShaderColor(107f / 255f, 30f / 255f, 5f / 255f, 1.0f);
        } else if (menu.getBeerType() == 4) {
            RenderSystem.setShaderColor(29f / 255f, 5f / 255f, 3f / 255f, 1.0f);
        } else if (menu.getBeerType() == 5) {
            RenderSystem.setShaderColor(170f / 255f, 14f / 255f, 1f / 255f, 1.0f);
        } else if (menu.getBeerType() == 6) {
            RenderSystem.setShaderColor(75f / 255f, 165f / 255f, 128f / 255f, 1.0f);
        } else if (menu.getBeerType() == 7) {
            RenderSystem.setShaderColor(58f / 255f, 70f / 255f, 123f / 255f, 1.0f);
        } else if (menu.getBeerType() == 8) {
            RenderSystem.setShaderColor(143f / 255f, 181f / 255f, 246f / 255f, 1.0f);
        } else if (menu.getBeerType() == 9) {
            RenderSystem.setShaderColor(188f / 255f, 137f / 255f, 39f / 255f, 1.0f);
        } else if (menu.getBeerType() == 10) {
            RenderSystem.setShaderColor(69f / 255f, 201f / 255f, 72f / 255f, 1.0f);
        } else if (menu.getBeerType() == 11) {
            RenderSystem.setShaderColor(142f / 255f, 102f / 255f, 141f / 255f, 1.0f);
        } else if (menu.getBeerType() == 12) {
            RenderSystem.setShaderColor(230f / 255f, 230f / 255f, 200f / 255f, 1.0f);
        } else if (menu.getBeerType() == 13) {
            RenderSystem.setShaderColor(219f / 255f, 112f / 255f, 147f / 255f, 1.0f);
        }

        for (int j = 0; j <= 3; j++) {
            for (int i = 0; i <= 8; i++) {
                guiGraphics.blit(x + 16 * i, y + 16 * j, 0, 16, 16, sprite);
            }
        }

        // Gui
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        x = (width - imageWidth) / 2;
        y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight + 2);

        if (this.menu.isCrafting()) {
            int i1 = this.menu.getProgress();
            int j1 = BUBBLELENGTHS[i1 / 2 % 7];

            guiGraphics.blit(TEXTURE, x + 150, y + 17 + 28 - j1, 176, 28 - j1, 11, j1);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}

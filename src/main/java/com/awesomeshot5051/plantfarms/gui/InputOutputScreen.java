package com.awesomeshot5051.plantfarms.gui;

import com.awesomeshot5051.corelib.inventory.*;
import com.awesomeshot5051.plantfarms.*;
import net.minecraft.client.gui.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;

public abstract class InputOutputScreen<T extends AbstractContainerMenu> extends ScreenBase<T> {
    public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(Main.MODID, "assets/plant_farms/textures/gui/container/input_output.png");
    private final Inventory playerInventory;

    public InputOutputScreen(T container, Inventory playerInventory, Component name) {
        super(BACKGROUND, container, playerInventory, name);
        this.playerInventory = playerInventory;
        imageWidth = 176;
        imageHeight = 164;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int x, int y) {
        drawCentered(guiGraphics, getTopText(), 9, FONT_COLOR);
        drawCentered(guiGraphics, getBottomText(), 40, FONT_COLOR);
        guiGraphics.drawString(font, playerInventory.getDisplayName().getVisualOrderText(), 8F, (float) (imageHeight - 96 + 3), FONT_COLOR, false);
    }

    protected abstract MutableComponent getTopText();

    protected abstract MutableComponent getBottomText();
}
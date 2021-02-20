package dev.nova.jclient.module.modules.hud;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.gui.hud.HudModule;
import dev.nova.jclient.gui.hud.HudPlacement;
import dev.nova.jclient.gui.hud.HudPosition;
import dev.nova.jclient.util.HudUtil;
import net.minecraft.client.Minecraft;

public class Fps extends HudModule {
    public Fps () {
        super("Fps", "Displays current frames per second", HudPlacement.BOTLEFT);
    }

    @Override
    public void render () {
        String fps = ChatFormatting.GREEN + "FPS " + ChatFormatting.WHITE + Minecraft.getDebugFPS();

        HudPosition hudPosition = HudUtil.getPosition(getHudPlacement(),mc.fontRenderer.FONT_HEIGHT, mc.fontRenderer.getStringWidth(fps));

        mc.fontRenderer.drawStringWithShadow(fps, hudPosition.getX(), hudPosition.getY(), -1);
    }
}

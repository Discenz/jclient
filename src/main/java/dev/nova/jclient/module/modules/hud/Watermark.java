package dev.nova.jclient.module.modules.hud;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.gui.hud.HudModule;
import dev.nova.jclient.gui.hud.HudPlacement;
import dev.nova.jclient.gui.hud.HudPosition;
import dev.nova.jclient.util.HudUtil;

public class Watermark extends HudModule {

    public Watermark () {
        super("Watermark", "Displays client name", HudPlacement.TOPLEFT);
    }

    @Override
    public void render () {
        String watermark = ChatFormatting.GREEN + JClient.NAME + " " + ChatFormatting.WHITE + JClient.VERSION;

        HudPosition hudPosition = HudUtil.getPosition(getHudPlacement(),mc.fontRenderer.FONT_HEIGHT, mc.fontRenderer.getStringWidth(watermark));

        mc.fontRenderer.drawStringWithShadow(watermark, hudPosition.getX(), hudPosition.getY(), -1);

    }
}

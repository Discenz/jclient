package dev.nova.jclient.module.modules.hud;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.gui.hud.HudModule;
import dev.nova.jclient.gui.hud.HudPlacement;
import dev.nova.jclient.gui.hud.HudPosition;
import dev.nova.jclient.util.HudUtil;

public class Ping extends HudModule {
    public Ping () {
        super("Ping", "Displays current latency", HudPlacement.BOTLEFT);
    }

    @Override
    public void render () {
        String ping = ChatFormatting.GREEN + "MS " + ChatFormatting.WHITE + mc.getConnection().getPlayerInfo(mc.player.getUniqueID()).getResponseTime();

        HudPosition hudPosition = HudUtil.getPosition(getHudPlacement(),mc.fontRenderer.FONT_HEIGHT, mc.fontRenderer.getStringWidth(ping));

        mc.fontRenderer.drawStringWithShadow(ping, hudPosition.getX(), hudPosition.getY(), -1);
    }
}

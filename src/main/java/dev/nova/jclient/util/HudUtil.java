package dev.nova.jclient.util;

import dev.nova.jclient.gui.hud.HudPlacement;
import dev.nova.jclient.gui.hud.HudPosition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class HudUtil {
    public static int TOPLEFT, BOTLEFT, TOPRIGHT, BOTRIGHT;

    public static int padding = 2;

    public static void refresh() {
        TOPLEFT = padding; BOTLEFT = padding; TOPRIGHT = padding; BOTRIGHT = padding;
    }

    public static HudPosition getPosition (HudPlacement placement, int height, int width) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());

        if(placement == HudPlacement.BOTLEFT) {
            HudPosition hudPosition = new HudPosition(padding, scaledResolution.getScaledHeight() - BOTLEFT - padding - height);
            BOTLEFT += padding + height;
            return hudPosition;
        }
        else if(placement == HudPlacement.BOTRIGHT) {
            HudPosition hudPosition = new HudPosition(scaledResolution.getScaledWidth()-padding-width, scaledResolution.getScaledHeight()-BOTRIGHT-padding-height);
            BOTRIGHT += padding + height;
            return hudPosition;
        }
        else if(placement == HudPlacement.TOPLEFT){
            HudPosition hudPosition = new HudPosition(padding, TOPLEFT);
            TOPLEFT += padding + height;
            return hudPosition;
        }
        else if(placement == HudPlacement.TOPRIGHT){
            HudPosition hudPosition = new HudPosition(scaledResolution.getScaledWidth()-padding-width, TOPRIGHT);
            TOPRIGHT += padding + height;
            return hudPosition;
        }
        else {
            return null;
        }
    }
}

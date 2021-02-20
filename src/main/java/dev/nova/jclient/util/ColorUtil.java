package dev.nova.jclient.util;

import java.awt.*;

public class ColorUtil {

    public static int getRGBColor() {
        float hue = (float) (System.currentTimeMillis() % 11520L) / 11520.0f;
        int rgb = Color.HSBtoRGB(hue, 1.0f, 1.0f);
        return rgb;
    }
}

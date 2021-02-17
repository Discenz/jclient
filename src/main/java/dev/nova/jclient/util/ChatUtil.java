package dev.nova.jclient.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;

public class ChatUtil {
    private static String chatPrefix = "[JC]";
    private static String chatSuffix;

    private static final EntityPlayerSP player = Minecraft.getMinecraft().player;

    public static void sendRawMessage(String message) {
        player.sendMessage(new TextComponentString(message));
    }

    public static void sendMessage(String message) {
        sendRawMessage(chatPrefix + " " + message);
    }
}

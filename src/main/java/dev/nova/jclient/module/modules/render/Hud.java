package dev.nova.jclient.module.modules.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class Hud extends Module {
    public Hud() {
        super("Hud", "User interface for client", Category.RENDER);
    }

    @Override
    public void onEnable () {
        System.out.println("Hud was enabled >:)");
        super.onEnable();
    }

    @EventHandler
    private Listener<RenderGameOverlayEvent> onClientChat = new Listener<>(event -> {
        String watermark = ChatFormatting.GREEN + JClient.NAME + " " + ChatFormatting.WHITE + JClient.VERSION;
        mc.fontRenderer.drawStringWithShadow(watermark, 2, 2, -1);
    });
}
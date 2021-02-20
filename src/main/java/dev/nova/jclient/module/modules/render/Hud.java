package dev.nova.jclient.module.modules.render;

import dev.nova.jclient.JClient;
import dev.nova.jclient.gui.hud.HudModule;
import dev.nova.jclient.util.HudUtil;
import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class Hud extends Module {

    public Hud() {
        super("Hud", "User interface for client", Category.RENDER);
    }

    @EventHandler
    private Listener<RenderGameOverlayEvent.Post> onRenderGameOverlay = new Listener<>(event -> {
        HudUtil.refresh();

        for(Module module: JClient.moduleManager.getModules(Category.HUD)) {
            HudModule hudModule = (HudModule) module;
            if(hudModule.isToggled()) hudModule.render();
        }

    });

    
}
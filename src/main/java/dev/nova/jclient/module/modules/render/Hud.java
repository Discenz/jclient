package dev.nova.jclient.module.modules.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.util.ColorUtil;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class Hud extends Module {
    private int padding = 2;

    public Hud() {
        super("Hud", "User interface for client", Category.RENDER);
    }

    @EventHandler
    private Listener<RenderGameOverlayEvent.Post> onRenderGameOverlay = new Listener<>(event -> {
        final ScaledResolution resolution = new ScaledResolution(mc);

        //Watermark
        String watermark = ChatFormatting.GREEN + JClient.NAME + " " + ChatFormatting.WHITE + JClient.VERSION;
        mc.fontRenderer.drawStringWithShadow(watermark, 2, 2, -1);

        //Arraylist
        int moduleHeight = padding;
        for(Module module: JClient.moduleManager.getModules()){
            if(module.isToggled() && !module.isHidden()) {
                String name = module.getName();
                mc.fontRenderer.drawStringWithShadow(name, resolution.getScaledWidth() - mc.fontRenderer.getStringWidth(name) - padding, moduleHeight, ColorUtil.getRGBColor());
                moduleHeight += padding + mc.fontRenderer.FONT_HEIGHT;
            }
        }

    });

    
}
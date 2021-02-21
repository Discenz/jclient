package dev.nova.jclient.module.modules.hud;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.gui.hud.HudModule;
import dev.nova.jclient.gui.hud.HudPlacement;
import dev.nova.jclient.gui.hud.HudPosition;
import dev.nova.jclient.setting.ToggleSetting;
import dev.nova.jclient.util.HudUtil;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.util.ColorUtil;
import net.minecraft.client.gui.ScaledResolution;

public class Arraylist extends HudModule {

    public Arraylist () {
        super("Arraylist", "Displays list of enabled modules", HudPlacement.TOPRIGHT, new ToggleSetting("Rainbow", true));
    }

    @Override
    public void render () {
        ScaledResolution resolution = new ScaledResolution(mc);

        for(Module module: JClient.moduleManager.getModules()){
            if(module.isToggled() && !module.isHidden()) {
                String name = module.getName();
                HudPosition hudPosition = HudUtil.getPosition(getHudPlacement(), mc.fontRenderer.FONT_HEIGHT, mc.fontRenderer.getStringWidth(name));

                int color = ColorUtil.getRGBColor();

                if(getSetting("Rainbow").getValue().equals(false)) {
                    color = -1;
                    name = ChatFormatting.GREEN + name;
                }

                mc.fontRenderer.drawStringWithShadow(name, hudPosition.getX(), hudPosition.getY(), color);
            }
        }

    }
}

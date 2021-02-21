package dev.nova.jclient.gui.hud;

import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.setting.Setting;

public class HudModule extends Module {

    private HudPlacement hudPlacement;

    public HudModule (String name, String description, Setting... settings) {
        super(name, description, Category.HUD, settings);
        super.setHidden(true);
        this.hudPlacement = HudPlacement.OTHER;
    }

    public HudModule (String name, String description, HudPlacement hudPlacement, Setting... settings) {
        super(name, description, Category.HUD, settings);
        super.setHidden(true);
        this.hudPlacement = hudPlacement;
    }

    public void render () {

    }

    @Override
    public void setHidden(boolean hidden) {

    }

    public HudPlacement getHudPlacement() {
        return hudPlacement;
    }

    public void setHudPlacement(HudPlacement hudPlacement) {
        this.hudPlacement = hudPlacement;
    }
}

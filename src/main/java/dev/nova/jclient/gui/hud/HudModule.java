package dev.nova.jclient.gui.hud;

import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;

public class HudModule extends Module {

    private HudPlacement hudPlacement;

    public HudModule (String name, String description) {
        super(name, description, Category.HUD);
        super.setHidden(true);
        this.hudPlacement = HudPlacement.OTHER;
    }

    public HudModule (String name, String description, HudPlacement hudPlacement) {
        super(name, description, Category.HUD);
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

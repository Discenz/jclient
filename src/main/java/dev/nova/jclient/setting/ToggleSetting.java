package dev.nova.jclient.setting;

public class ToggleSetting extends Setting<Boolean>{
    public ToggleSetting(Object parent, String name, Boolean value) {
        super(parent, name, value);
        this.type = "Toggle";
    }

    public void toggle () {
        value = !value;
    }
}

package dev.nova.jclient.setting;

public class ToggleSetting extends Setting<Boolean>{
    public ToggleSetting(String name, Boolean value) {
        super(name, value);
        this.type = "Toggle";
    }

    public void toggle () {
        value = !value;
    }
}

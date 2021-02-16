package dev.nova.jclient.setting;

public class ModeSetting extends Setting<Integer> {

    private String[] modes;

    public ModeSetting (Object parent, String name, Integer value, String... modes) {
        super(parent, name, value);
        this.modes = modes;
        this.type = "Mode";
    }

    public String[] getModes() {
        return modes;
    }

    public void setModes(String[] modes) {
        this.modes = modes;
    }

    public String getMode () {
        return modes[value];
    }

    public void next () {
        value++;
        if(value == modes.length) value = 0;
    }
}

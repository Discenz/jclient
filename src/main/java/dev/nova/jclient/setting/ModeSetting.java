package dev.nova.jclient.setting;

public class ModeSetting extends Setting<Integer> {

    private String[] modes;

    public ModeSetting (String name, Integer value, String... modes) {
        super(name, value);
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

    public boolean setMode (String name) {
        int i = 0;
        for(String mode: modes){
            if(mode.equalsIgnoreCase(name)){
                value = i;
                return true;
            }
            i++;
        }
        return false;
    }

    public void next () {
        value++;
        if(value == modes.length) value = 0;
    }
}

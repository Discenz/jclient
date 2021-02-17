package dev.nova.jclient.module;

import dev.nova.jclient.JClient;
import dev.nova.jclient.setting.Setting;
import me.zero.alpine.listener.Listenable;

public class Module implements Listenable {
    private String name, description;
    private Category category;
    private int key;
    private boolean toggled, hidden;
    private Setting[] settings;

    public Module(String name, String description, Category category, Setting... settings) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.settings = settings;
        this.key = 0;
        this.hidden = false;
        this.toggled = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        if(this.toggled) onEnable();
        else onDisable();
    }

    public void toggle () {
        this.toggled = !this.toggled;
        if(this.toggled) onEnable();
        else onDisable();
    }

    public void onEnable () {
        JClient.eventBus.subscribe(this);
    }

    public void onDisable () {
        JClient.eventBus.unsubscribe(this);
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Setting[] getSettings() {
        return settings;
    }

    public void setSettings(Setting[] settings) {
        this.settings = settings;
    }

    public Setting getSetting(String name) {
        for (Setting setting: settings){
            if(setting.getName().equalsIgnoreCase(name)){
                return setting;
            }
        }
        return null;
    }
}

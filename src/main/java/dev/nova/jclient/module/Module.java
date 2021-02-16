package dev.nova.jclient.module;

import dev.nova.jclient.setting.Setting;

public class Module {
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

    public Module(String name, String description, Category category, int key, boolean toggled, boolean hidden, Setting[] settings) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.key = key;
        this.toggled = toggled;
        this.hidden = hidden;
        this.settings = settings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

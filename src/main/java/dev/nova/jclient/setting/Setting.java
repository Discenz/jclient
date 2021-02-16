package dev.nova.jclient.setting;

public class Setting<T> {
    protected String name;
    protected Object parent;
    protected T value;
    protected String type;

    public Setting(Object parent, String name, T value) {
        this.name = name;
        this.value = value;
        this.parent = parent;
        this.type = value.getClass().toString().split(" ")[1];
    }

    public T getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getType() {
        return this.type;
    }
}

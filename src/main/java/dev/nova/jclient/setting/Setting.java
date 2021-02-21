package dev.nova.jclient.setting;

public class Setting<T> {
    protected String name;
    protected T value;
    protected String type;

    public Setting(String name, T value) {
        this.name = name;
        this.value = value;
        this.type = value.getClass().toString().split(" ")[1];
    }

    public T getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public void setValue(T value) {
        this.value = value;
    }

    public String getType() {
        return this.type;
    }
}

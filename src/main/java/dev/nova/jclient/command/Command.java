package dev.nova.jclient.command;

public class Command {
    String name, description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void run (String[] args) {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

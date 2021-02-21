package dev.nova.jclient.command;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;

public class Command {
    private String name, description, usage;

    public Command(String name, String description, String usage) {
        this.name = name;
        this.description = description;
        this.usage = usage;
    }

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
        this.usage = null;
    }

    public void run (String[] args) {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage () {
        return usage;
    }

    public String getUsageChat() {
        if(usage == null) return JClient.PREFIX + ChatFormatting.GREEN + name.toLowerCase();
        return JClient.PREFIX + ChatFormatting.GREEN + name.toLowerCase() + ChatFormatting.WHITE + " " + usage;
    }
}

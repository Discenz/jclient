package dev.nova.jclient.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.command.Command;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.util.ChatUtil;

public class Info extends Command {
    public Info () {
        super("Info", "Information on module or command", "[command/module]");
    }

    @Override
    public void run (String[] args){

        if(args.length < 2) {
            ChatUtil.sendMessage(getUsageChat());
            return;
        }

        Module module = JClient.moduleManager.getModule(args[1]);
        Command command = JClient.commandManager.getCommand(args[1]);

        if(module != null) {
            ChatUtil.sendMessage(ChatFormatting.GREEN + module.getName() + ChatFormatting.WHITE + ": " + module.getDescription());
            return;
        }

        if(command != null) {
            ChatUtil.sendMessage(ChatFormatting.GREEN + command.getName() + ChatFormatting.WHITE + ": " + command.getDescription());
            return;
        }

        ChatUtil.sendMessage(ChatFormatting.GREEN + args[1] + ChatFormatting.WHITE + " is not a module or command");


    }
}

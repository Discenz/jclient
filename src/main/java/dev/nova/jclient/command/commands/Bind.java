package dev.nova.jclient.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.command.Command;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.util.ChatUtil;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {
    public Bind () {
        super("Bind", "Bind modules to a certain key", "[module] [key]");
    }

    @Override
    public void run (String[] args){
        if(args.length < 3) {
            ChatUtil.sendMessage(getUsageChat());
            return;
        }

        Module module = JClient.moduleManager.getModule(args[1]);

        if(module == null) {
            ChatUtil.sendMessage(ChatFormatting.GREEN + args[1] + ChatFormatting.WHITE + " is not a module");
            return;
        }

        try {
            module.setKey(Keyboard.getKeyIndex(args[2].toUpperCase()));
            ChatUtil.sendMessage(ChatFormatting.GREEN + module.getName() + ChatFormatting.WHITE + " was bound to " + args[2].toUpperCase());
        } catch (Exception e) {
            ChatUtil.sendMessage(ChatFormatting.GREEN + module.getName() + ChatFormatting.WHITE + " could not be bound to " + ChatFormatting.GREEN + args[2].toUpperCase());
            e.printStackTrace();
        }

    }
}


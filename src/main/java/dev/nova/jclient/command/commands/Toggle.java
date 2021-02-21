package dev.nova.jclient.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.command.Command;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.util.ChatUtil;

public class Toggle extends Command {
    public Toggle () {
        super("Toggle", "Turn modules on and off", "[module]");
    }

    @Override
    public void run (String[] args){

        if(args.length < 2) {
            ChatUtil.sendMessage(getUsageChat());
            return;
        }

        Module module = JClient.moduleManager.getModule(args[1]);

        if(module == null) {
            ChatUtil.sendMessage(ChatFormatting.GREEN + args[1] + ChatFormatting.WHITE + " is not a module");
            return;
        }

        module.toggle();

        String state = "disabled";
        if (module.isToggled()) state = "enabled";

        ChatUtil.sendMessage(ChatFormatting.GREEN + module.getName() + ChatFormatting.WHITE + " was " + state);
    }
}

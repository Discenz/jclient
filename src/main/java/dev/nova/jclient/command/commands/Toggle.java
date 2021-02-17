package dev.nova.jclient.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.command.Command;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.util.ChatUtil;

public class Toggle extends Command {
    public Toggle () {
        super("Toggle", "Turn modules on and off");
    }

    @Override
    public void run (String[] args){
        Module module = JClient.moduleManager.getModule(args[1]);

        if(module == null) {
            ChatUtil.sendMessage(ChatFormatting.GREEN + args[1] + " is not a module");
            return;
        }

        module.toggle();

        String state = "disabled";
        if (module.isToggled()) state = "enabled";

        ChatUtil.sendMessage(ChatFormatting.GREEN + module.getName() + ChatFormatting.WHITE + " was " + state);
    }
}

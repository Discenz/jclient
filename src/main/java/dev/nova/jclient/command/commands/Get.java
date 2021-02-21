package dev.nova.jclient.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.command.Command;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.setting.Setting;
import dev.nova.jclient.util.ChatUtil;

public class Get extends Command {
    public Get () {
        super("Get", "Get module's value", "[module] [setting]");
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

        Setting setting = module.getSetting(args[2]);

        if(setting == null) {
            ChatUtil.sendMessage(ChatFormatting.GREEN + args[2] + ChatFormatting.WHITE + " is not a setting for " + module.getName());
            return;
        }

        ChatUtil.sendMessage(ChatFormatting.GREEN + setting.getName() + ChatFormatting.WHITE + " is set to " + setting.getValue());
    }
}


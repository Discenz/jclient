package dev.nova.jclient.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.command.Command;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.setting.ModeSetting;
import dev.nova.jclient.setting.Setting;
import dev.nova.jclient.setting.SliderSetting;
import dev.nova.jclient.setting.ToggleSetting;
import dev.nova.jclient.util.ChatUtil;

public class Set extends Command {
    public Set () {
        super("Set", "Modify module's value", "[module] [setting] [value]");
    }

    @Override
    public void run (String[] args){
        if(args.length < 4) {
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

        if(setting.getType() == "Slider") {
            SliderSetting s = (SliderSetting) setting;

            try {
                Double value = Double.parseDouble(args[3]);

                if(value < s.getMin() || value > s.getMax()){
                    ChatUtil.sendMessage(ChatFormatting.GREEN + args[3] + ChatFormatting.WHITE + " is not a valid value for " + s.getName());
                    return;
                }

                s.setValue(value);

                ChatUtil.sendMessage(ChatFormatting.GREEN + s.getName() + ChatFormatting.WHITE + " set to " + setting.getValue());

            } catch (Exception e) {
                ChatUtil.sendMessage(ChatFormatting.GREEN + args[3] + ChatFormatting.WHITE + " is not a valid value for " + s.getName());
                return;
            }
        }

        else if(setting.getType() == "Toggle") {
            ToggleSetting s = (ToggleSetting) setting;

            try {
                Boolean value = Boolean.parseBoolean(args[3]);
                s.setValue(value);

                ChatUtil.sendMessage(ChatFormatting.GREEN + s.getName() + ChatFormatting.WHITE + " set to " + setting.getValue());

            } catch (Exception e) {
                ChatUtil.sendMessage(ChatFormatting.GREEN + args[3] + ChatFormatting.WHITE + " is not a valid value for " + s.getName());
                return;
            }
        }

        else if(setting.getType() == "Mode") {
            ModeSetting s = (ModeSetting) setting;

            if(s.setMode(args[3])){
                ChatUtil.sendMessage(ChatFormatting.GREEN + s.getName() + ChatFormatting.WHITE + " set to " + s.getMode());
            }
            else{
                ChatUtil.sendMessage(ChatFormatting.GREEN + args[3] + ChatFormatting.WHITE + " is not a valid value for " + s.getName());
                return;
            }
        }

    }
}


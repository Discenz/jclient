package dev.nova.jclient.manager;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.command.Command;
import dev.nova.jclient.command.commands.*;
import dev.nova.jclient.util.ChatUtil;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import net.minecraftforge.client.event.ClientChatEvent;

import java.util.ArrayList;

public class CommandManager implements Listenable {
    private ArrayList<Command> commands;

    public CommandManager () {
        JClient.eventBus.subscribe(this);
        commands = new ArrayList<>();

        commands.add(new Toggle());
        commands.add(new Bind());
        commands.add(new Set());
        commands.add(new Get());
        commands.add(new Info());

    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public Command getCommand (String name) {
        for (Command command: commands) {
            if(command.getName().equalsIgnoreCase(name)){
                return command;
            }
        }
        return null;
    }

    @EventHandler
    private Listener<ClientChatEvent> onClientChat = new Listener<>(event -> {
        String message = event.getMessage();

        if(!message.startsWith(JClient.PREFIX)) return;

        event.setCanceled(true);

        String[] args = message.split(" ");
        String commandName = args[0].substring(1);

        for (Command command: commands) {
            if(command.getName().equalsIgnoreCase(commandName)) {
                command.run(args);
                return;
            }
        }

        ChatUtil.sendMessage(ChatFormatting.GREEN + commandName + ChatFormatting.WHITE + " is not recognized");
    });

}

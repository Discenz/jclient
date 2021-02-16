package dev.nova.jclient.manager;

import dev.nova.jclient.JClient;
import dev.nova.jclient.command.Command;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

public class CommandManager {
    private ArrayList<Command> commands;

    public CommandManager () {
        MinecraftForge.EVENT_BUS.register(this);
        commands = new ArrayList<>();

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

    //Temp forge event until event system implemented >:)
    @SubscribeEvent
    public void chatEvent(ClientChatEvent event) {
        String message = event.getMessage();

        if(!message.startsWith(JClient.PREFIX)) return;

        String[] args = message.split(" ");
        String commandName = args[0].substring(1);

        for (Command command: commands) {
            if(command.getName().equalsIgnoreCase(commandName)) {
                command.run(args);
                return;
            }
        }
    }

}

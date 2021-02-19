package dev.nova.jclient.module.modules.chat;

import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class NoRntz extends Module {

    public NoRntz() {
        super("NoRntz", "Removes rntz from existance", Category.CHAT);
    }

    @EventHandler
    private Listener<ClientChatReceivedEvent> onClientChatRecieved = new Listener<>(event -> {
        String message = event.getMessage().getUnformattedText();
        if(message.contains("rntz")) event.setCanceled(true);
    });
}

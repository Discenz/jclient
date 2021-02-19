package dev.nova.jclient.event;

import dev.nova.jclient.JClient;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//This class posts Forge Events to JClient's Event Bus

public class ForgeEventsLoader {

    public ForgeEventsLoader () {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientChat (ClientChatEvent event) {
        JClient.eventBus.post(event);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        JClient.eventBus.post(event);
    }

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {
        JClient.eventBus.post(event);
    }

}

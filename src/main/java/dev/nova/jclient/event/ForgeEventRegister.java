package dev.nova.jclient.event;

import dev.nova.jclient.JClient;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

//This class posts Forge Events to JClient's Event Bus

public class ForgeEventRegister {

    public ForgeEventRegister() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        JClient.eventBus.post(event);
    }

    @SubscribeEvent
    public void onClientChat (ClientChatEvent event) {
        JClient.eventBus.post(event);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if(event.isCanceled()) return;
        JClient.eventBus.post(event);
    }

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent event) {
        JClient.eventBus.post(event);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        JClient.eventBus.post(event);
    }

}

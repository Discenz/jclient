package dev.nova.jclient.manager;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nova.jclient.JClient;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.util.ChatUtil;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeybindManager implements Listenable {


    public KeybindManager () {
        JClient.eventBus.subscribe(this);
    }

    @EventHandler
    private Listener<InputEvent.KeyInputEvent> onKeyPress = new Listener<>(event -> {
        for (Module module: JClient.moduleManager.getModules()) {
            if (Keyboard.isKeyDown(module.getKey())) {
                module.toggle();
                return;
            }
        }
    });

}

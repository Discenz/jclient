package dev.nova.jclient.module.modules.chat;

import dev.nova.jclient.JClient;
import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.util.ChatUtil;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraftforge.client.event.ClientChatEvent;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ChatSuffix extends Module {

    public ChatSuffix() {
        super("ChatSuffix", "Adds a suffix to your chat message", Category.CHAT);
    }

    Map<String, String> smallText = new HashMap<String, String>()
    {
        {
            put("a", "\u1D00");
            put("b", "\u0299");
            put("c", "\u1D04");
            put("d", "\u1D05");
            put("e", "\u1D07");
            put("f", "\u0493");
            put("g", "\u0262");
            put("h", "\u029C");
            put("i", "\u026A");
            put("j", "\u1D0A");
            put("k", "\u1D0B");
            put("l", "\u029F");
            put("m", "\u1D0D");
            put("n", "\u0274");
            put("o", "\u1D0F");
            put("p", "\u1D18");
            put("q", "\u01EB");
            put("r", "\u0280");
            put("s", "\uA731");
            put("t", "\u1D1B");
            put("u", "\u1D1C");
            put("v", "\u1D20");
            put("w", "\u1D21");
            put("x", "\u0078");
            put("y", "\u028F");
            put("z", "\u1D22");
            put("|", "\u23D0");
            put("-", "\u2013");
            put("!", "\uFF01");
            put("?", "\uFF1F");
        }
    };

    public String getSmallChar(String character){
        for ( String key : smallText.keySet() ) {
            if(key.equals(character)) return smallText.get(key);
        }
        return null;
    }

    public String convert(String text) {
        String converted = text;
        for(char c : converted.toLowerCase().toCharArray()) {
            String character = String.valueOf(c);
            converted = StringUtils.replaceIgnoreCase(converted, character, getSmallChar(character));
        }
        return converted;
    }

    @EventHandler
    private Listener<ClientChatEvent> onClientChat = new Listener<>(event -> {
        String message = event.getMessage();

        if(message.startsWith("/") || message.startsWith(JClient.PREFIX)) return;

        event.setMessage(message + convert(ChatUtil.chatSuffix));
    });

}

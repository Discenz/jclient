package dev.nova.jclient.manager;

import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.module.modules.chat.ChatSuffix;
import dev.nova.jclient.module.modules.chat.NoRntz;
import dev.nova.jclient.module.modules.hud.Arraylist;
import dev.nova.jclient.module.modules.hud.Fps;
import dev.nova.jclient.module.modules.hud.Ping;
import dev.nova.jclient.module.modules.hud.Watermark;
import dev.nova.jclient.module.modules.render.Hud;

import java.util.ArrayList;

public class ModuleManager {
    private ArrayList<Module> modules;

    public ModuleManager() {
        modules = new ArrayList<>();

        // RENDER MODULES
        modules.add(new Hud());
        // CHAT MODULES
        modules.add(new ChatSuffix());
        modules.add(new NoRntz());
        // HUD MODULES
        modules.add(new Watermark());
        modules.add(new Arraylist());
        modules.add(new Fps());
        modules.add(new Ping());
    }

    public Module getModule (String name) {
        for(Module module: modules) {
            if(module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }
        return null;
    }

    public ArrayList<Module> getModules () {
        return modules;
    }

    public ArrayList<Module> getModules (Category category) {
        ArrayList<Module> m = new ArrayList<>();
        for(Module module: modules) {
            if(module.getCategory().equals(category)){
                m.add(module);
            }
        }
        return m;
    }

}

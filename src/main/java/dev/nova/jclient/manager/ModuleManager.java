package dev.nova.jclient.manager;

import dev.nova.jclient.module.Category;
import dev.nova.jclient.module.Module;
import dev.nova.jclient.module.modules.render.Hud;

import java.util.ArrayList;

public class ModuleManager {
    private ArrayList<Module> modules;

    public ModuleManager() {
        modules = new ArrayList<>();

        modules.add(new Hud());
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

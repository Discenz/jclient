package dev.nova.jclient;

import dev.nova.jclient.manager.CommandManager;
import dev.nova.jclient.manager.ModuleManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = JClient.MODID, name = JClient.NAME, version = JClient.VERSION)
public class JClient
{
    public static final String MODID = "jclient";
    public static final String NAME = "JClient";
    public static final String VERSION = "1.0";
    public static final String PREFIX = "-";

    public static ModuleManager moduleManager;
    public static CommandManager commandManager;

    public static final Logger logger = LogManager.getLogger("JC");

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info(NAME + " Initializing");
        Display.setTitle(NAME + " " + VERSION);
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
    }
}

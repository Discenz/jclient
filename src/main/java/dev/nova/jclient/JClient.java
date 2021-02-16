package dev.nova.jclient;

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

    private static Logger logger;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger = LogManager.getLogger("JC");
        logger.info("JClient Initializing");
        Display.setTitle(NAME + " "+ VERSION);
    }
}

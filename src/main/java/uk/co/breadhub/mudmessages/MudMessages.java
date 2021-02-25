package uk.co.breadhub.mudmessages;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.breadhub.mudmessages.listeners.DeathListener;

import javax.security.auth.login.LoginException;

public class MudMessages extends JavaPlugin {

    private static MudMessages instance;
    private static JDA jda;

    public static JDA getJda() {
        return jda;
    }

    public static MudMessages getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new DeathListener(), instance);

        //discord Login
        try {
            JDABuilder builder = JDABuilder.createDefault(getConfig().getString("plugin.token"));

            // Disable parts of the cache
            builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
            // Enable the bulk delete event
            builder.setBulkDeleteSplittingEnabled(false);
            // Disable compression (not recommended)
            builder.setCompression(Compression.NONE);
            // Set activity (like "playing Something")
            builder.setActivity(Activity.watching("Mud Die"));

            jda = builder.build();
        }
        catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}

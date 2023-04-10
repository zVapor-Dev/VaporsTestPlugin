package xyz.zvapor.vaportest;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.zvapor.vaportest.commands.CountdownCommand;
import xyz.zvapor.vaportest.commands.DieCommand;
import xyz.zvapor.vaportest.listeners.JoinLeaveListener;


public final class VaporTest extends JavaPlugin {

    private static VaporTest plugin;

    public int number = 10;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        final FileConfiguration config = this.getConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents((new JoinLeaveListener()), this);

        System.out.println("VaporTest has started. Listening to whomever runs commands!");


        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getCommand("countdown").setExecutor(new CountdownCommand());
        getCommand("die").setExecutor(new DieCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("VaporTest has stopped. Goodbye cruel world.");
    }

    public static VaporTest getPlugin() {
        return plugin;
    }
}

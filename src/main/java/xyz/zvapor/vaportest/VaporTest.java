package xyz.zvapor.vaportest;

import me.kodysimpson.commandarguments.commands.FartCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.zvapor.vaportest.commands.*;
import xyz.zvapor.vaportest.listeners.MenuListener;
import xyz.zvapor.vaportest.listeners.JoinLeaveListener;
import xyz.zvapor.vaportest.listeners.SpawnListeners;


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

        // Listeners
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new SpawnListeners(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        // Commands
        getCommand("countdown").setExecutor(new CountdownCommand());
        getCommand("die").setExecutor(new DieCommand());
        getCommand("repeat").setExecutor(new RepeatCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("fart").setExecutor(new FartCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("menu").setExecutor(new MenuCommand());

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

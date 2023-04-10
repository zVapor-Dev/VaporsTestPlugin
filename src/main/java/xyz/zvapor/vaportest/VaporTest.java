package xyz.zvapor.vaportest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.zvapor.vaportest.commands.CountdownCommand;
import xyz.zvapor.vaportest.commands.DieCommand;
import xyz.zvapor.vaportest.listeners.onPlayerJoin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


public final class VaporTest extends JavaPlugin implements Listener {

    public int number = 10;
    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("VaporTest has started. Listening to whomever runs commands!");


        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);
        getCommand("countdown").setExecutor(new CountdownCommand(this));
        getCommand("die").setExecutor(new DieCommand());

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        System.out.println("VaporTest > A player has joined the server.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("VaporTest has stopped. Goodbye cruel world.");
    }
}

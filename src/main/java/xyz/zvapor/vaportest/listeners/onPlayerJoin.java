package xyz.zvapor.vaportest.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        System.out.println("VaporTest > A player has joined the server.");
        event.setJoinMessage("Welcome to the server player! Hope you enjoy!");
    }
}

package xyz.zvapor.vaportest.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.zvapor.vaportest.VaporTest;

public class JoinLeaveListener implements Listener {
    private final VaporTest plugin;
    public JoinLeaveListener(VaporTest plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        e.setQuitMessage(plugin.getConfig().getString("LeaveMessage").replace("%player%", e.getPlayer().getName()));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.setJoinMessage(plugin.getConfig().getString("JoinMessage").replace("%player%", e.getPlayer().getName()));
    }
    
    
}

package xyz.zvapor.vaportest.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import xyz.zvapor.vaportest.VaporTest;

public class SpawnListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!player.hasPlayedBefore()) {
            Location location = VaporTest.getPlugin().getConfig().getLocation("spawn");

            if (location != null) {
                player.teleport(location);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Location location = VaporTest.getPlugin().getConfig().getLocation("spawn");

        if(location != null){
            e.setRespawnLocation(location);
        }
    }
}

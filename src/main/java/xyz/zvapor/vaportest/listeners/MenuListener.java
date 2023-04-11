package xyz.zvapor.vaportest.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {


        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Test Menu")){
            e.setCancelled(true);

            if(e.getCurrentItem() == null){
                return;
            }

            if(e.getCurrentItem().getType() == Material.DIAMOND_HOE){
                e.getWhoClicked().sendMessage(ChatColor.GREEN + "You clicked the test item!");
                e.getWhoClicked().closeInventory();
            } else {
                e.getWhoClicked().sendMessage(ChatColor.RED + "You clicked something else!");
            }
        }



    }

}

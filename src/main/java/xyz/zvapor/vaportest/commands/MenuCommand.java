package xyz.zvapor.vaportest.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {
            Inventory inventory = Bukkit.createInventory(p, 27, ChatColor.RED + "Test Menu");

            ItemStack item = new ItemStack(Material.DIAMOND_HOE, 1);
            ItemMeta itemMeta = item.getItemMeta();

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "Test Lore");
            lore.add(ChatColor.RED + ("This is now Red"));
            lore.add(ChatColor.BLUE + ("This is now Blue"));


            itemMeta.setDisplayName(ChatColor.GREEN + "Test Item");
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);

            inventory.setItem(13, item);

            p.openInventory(inventory);

        }


        return true;
    }
}

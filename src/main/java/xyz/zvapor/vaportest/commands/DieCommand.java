package xyz.zvapor.vaportest.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DieCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.setHealth(0.0);
            p.sendMessage(ChatColor.RED + "You have opted to die.");
        } else {
            System.out.println(ChatColor.RED + "You have to be a player to run this command!");
        }
        return true;
    }
}

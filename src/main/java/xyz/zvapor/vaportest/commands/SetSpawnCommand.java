package xyz.zvapor.vaportest.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.zvapor.vaportest.VaporTest;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            if(player.hasPermission("vaportest.spawn.set")) {
                Location location = player.getLocation();

                VaporTest.getPlugin().getConfig().set("spawn", location);
                VaporTest.getPlugin().saveConfig();

                player.sendMessage(ChatColor.GREEN + "Spawn set to your current location.");
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }

        } else {
            commandSender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
        }

        return true;
    }
}

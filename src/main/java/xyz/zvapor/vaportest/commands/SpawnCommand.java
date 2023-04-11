package xyz.zvapor.vaportest.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.zvapor.vaportest.VaporTest;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {

            if (player.hasPermission("vaportest.spawn.teleport")) {
                Location location = VaporTest.getPlugin().getConfig().getLocation("spawn");

                if (location != null) {
                    player.teleport(location);
                    player.sendMessage(ChatColor.GREEN + "Teleported to spawn.");
                } else {
                    player.sendMessage(ChatColor.RED + "Spawn has not been set yet. Use /setspawn to set it.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }

        } else {
            commandSender.sendMessage("You must be a player to use this command.");
        }


        return true;
    }
}

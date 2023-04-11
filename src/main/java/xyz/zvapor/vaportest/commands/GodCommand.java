package xyz.zvapor.vaportest.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (player.hasPermission("vaportest.god")) {
                if (strings.length > 1) {
                    player.sendMessage(ChatColor.RED + "Too many arguments!");
                    return true;
                } else if (strings.length == 0) {

                    if (player.isInvulnerable()) {
                        player.setInvulnerable(false);
                        player.sendMessage(ChatColor.RED + "God mode disabled");
                    } else if (!player.isInvulnerable()) {
                        player.setInvulnerable(true);
                        player.sendMessage(ChatColor.GREEN + "God mode enabled");
                    }

                } else if (strings.length == 1) {

                    Player target = player.getServer().getPlayer(strings[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.RED + "Player not found!");
                    } else {
                        if (target.isInvulnerable()) {
                            target.setInvulnerable(false);
                            player.sendMessage(ChatColor.RED + "God mode disabled for " + target.getDisplayName());
                            target.sendMessage(ChatColor.RED + "God mode disabled by " + player.getDisplayName());
                        } else if (!target.isInvulnerable()) {
                            target.setInvulnerable(true);
                            player.sendMessage(ChatColor.GREEN + "God mode enabled for " + target.getDisplayName());
                            target.sendMessage(ChatColor.GREEN + "God mode enabled by " + player.getDisplayName());
                        }
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }


        }

        return true;
    }
}

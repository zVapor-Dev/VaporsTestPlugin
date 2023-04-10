package xyz.zvapor.vaportest.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            if (strings.length == 0) {
                player.sendMessage((ChatColor.RED + "You must specify a message to repeat!"));
                player.sendMessage((ChatColor.RED + "Usage: /repeat <message>"));
            } else if(strings.length == 1) {
                String word = strings[0];

                player.sendMessage(ChatColor.GREEN + "Your magic word is " + word);
            } else if(strings.length > 1) {
                StringBuilder builder = new StringBuilder();

                for(int i = 0; i < strings.length; i++) {
                    builder.append(strings[i]);
                    builder.append(" ");
                }

                String finalMessage = builder.toString();
                finalMessage = finalMessage.stripTrailing();

                player.sendMessage(ChatColor.GREEN + "Message: " + finalMessage);

            }
        } else {
            System.out.println("You are not a player!");
        }


        return true;
    }
}

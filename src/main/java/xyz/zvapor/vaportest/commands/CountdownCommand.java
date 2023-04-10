package xyz.zvapor.vaportest.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import xyz.zvapor.vaportest.VaporTest;

public class CountdownCommand implements CommandExecutor {
    public int number = 10;
    private final VaporTest plugin;
    public CountdownCommand(VaporTest plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
           plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
               @Override
               public void run() {
                   if (number != -1){
                       if(number != 0){
                           Bukkit.broadcastMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Delta " + ChatColor.BOLD.toString() + ChatColor.WHITE + "» " + ChatColor.BOLD.toString() + ChatColor.AQUA + number);
                           number--;
                       } else {
                           Bukkit.broadcastMessage(ChatColor.RED.toString() + ChatColor.BOLD + "Delta " + ChatColor.BOLD.toString() + ChatColor.WHITE + "» " + ChatColor.AQUA + "§bI am now done counting down!");
                           number--;
                       }
                   }
               }
           },0,20);



        return true;
    }
}

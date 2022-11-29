//SIMPLE FREEZE PLUGIN 

//MAIN CLASS

package me.alessandev.simplefeedplugin;

import me.alessandev.simplefeedplugin.Comandi.Feed;
import me.alessandev.simplefeedplugin.Comandi.Simplefeed;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    public void Commands(){

        getCommand("feed").setExecutor(new Feed());
        getCommand("simplefeed").setExecutor(new Simplefeed());
        Commands();}

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[Simplefeedplugin] by Alessandev enabled");


    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[Simplefeedplugin] by Alessandev disabled");
    }
}

//FEED COMMAND



package me.alessandev.simplefeedplugin.Comandi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender, Command command,  String label, String[] args) {


            if(sender instanceof Player) {
                Player p = (Player) sender;

                if (p.hasPermission("simplefeed.use")) {
                    p.setFoodLevel(20);
                    p.sendMessage("§eYou have been satied.");

                } else {
                    p.sendMessage("§cYou are missing the permission §bsimplefeed.use");
                }
            }else{
                sender.sendMessage("§cOnly in-game players can run this command");
            }


            return false;
        }
    }

//SIMPLEFEED COMMAND


package me.alessandev.simplefeedplugin.Comandi;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Simplefeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;
            p.sendMessage("§6§l[SimpleFeedPlugin] §7By Alessan§3dev§7 is running §acorrectly\n§7Use the command §b/feed");

        } else {

            sender.sendMessage("§6§l[SimpleFeedPlugin] §7By Alessan§3dev§7 is running §acorrectly\n§7Use the command §b/feed");

        }   return false;

    }

}

//PLUGIN.YML

name: SimpleFeedPlugin
version: '${project.version}'
main: me.alessandev.simplefeedplugin.Main
api-version: 1.19
authors: [ Alessandev ]
description: Simple Feed Plugin
commands:
  Feed:
    description: "Feed Command"
    aliases: [ sazia ]
  Simplefeed:
    description: "Info command"

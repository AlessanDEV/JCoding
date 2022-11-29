//PLUGIN BY ALESSANDEV & ANDRY


//COMMAND FREEZE

package me.ghostdevelopment.factionfreeze.commands;

import me.ghostdevelopment.factionfreeze.FactionFreeze;
import me.ghostdevelopment.factionfreeze.Utils;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFreeze implements CommandExecutor {
   LuckPerms luckPerms;
   FactionFreeze plugin;

   public CommandFreeze(FactionFreeze freeze) {
      this.plugin = this.plugin;
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("onlyPlayer")));
      }

      if (!sender.hasPermission("factionfreeze.freeze") && !sender.hasPermission("factionfreeze.*") && !sender.hasPermission("*")) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("noPerms")));
      }

      if (args.length == 0) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("freeze.usage")));
         return false;
      } else {
         Player target = Bukkit.getPlayer(args[0]);
         if (target == null) {
            sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("freeze.player-not-found")).replace("%player%", target.getName()));
            return false;
         } else {
            if (args.length == 1) {
               if (target.getWalkSpeed() == 0.0F) {
                  sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("freeze.already-frozen")));
               } else {
                  target.setWalkSpeed(0.0F);
                  sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("freeze.player-freeze").replace("%player%", target.getName())));
               }
            }

            return true;
         }
      }
   }
}

//COMMAND FINISH

package me.ghostdevelopment.factionfreeze.commands;

import me.ghostdevelopment.factionfreeze.FactionFreeze;
import me.ghostdevelopment.factionfreeze.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFinish implements CommandExecutor {
   FactionFreeze plugin;

   public CommandFinish(FactionFreeze plugin) {
      this.plugin = plugin;
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("onlyPlayer")));
      }

      if (!sender.hasPermission("factionfreeze.freeze") && !sender.hasPermission("factionfreeze.*") && !sender.hasPermission("*")) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("noPerms")));
      }

      if (args.length == 0) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("finish.usage")));
         return false;
      } else {
         Player target = Bukkit.getPlayer(args[0]);
         Player p = (Player)sender;
         if (target == null) {
            sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("finish.player-not-found")).replace("%player%", target.getName()));
            return false;
         } else {
            if (args.length == 1) {
               sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("finish.spefify-finish")));
            }

            if (args.length == 2) {
               if (args[1] != "ammissione" && args[1] != "rifiuto" && args[1] != "slog" && args[1] != "positivo") {
                  sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("finish.spefify-finish")));
               } else if (args[1] == "rifiuto") {
                  p.performCommand(this.plugin.getConfig().getString("finish.commands.rifiuto").replace("%player%", target.getName()));
               } else if (args[1] == "slog") {
                  p.performCommand(this.plugin.getConfig().getString("finish.commands.slog").replace("%player%", target.getName()));
               } else if (args[1] == "positivo") {
                  p.performCommand(this.plugin.getConfig().getString("finish.commands.positivo").replace("%player%", target.getName()));
               } else if (args[1] == "ammissione") {
                  p.performCommand(this.plugin.getConfig().getString("finish.commands.ammissione").replace("%player%", target.getName()));
               }
            }

            return true;
         }
      }
   }
}

//COMMAND UNFREEZE


package me.ghostdevelopment.factionfreeze.commands;

import me.ghostdevelopment.factionfreeze.FactionFreeze;
import me.ghostdevelopment.factionfreeze.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUnfreeze implements CommandExecutor {
   FactionFreeze plugin;

   public CommandUnfreeze(FactionFreeze freeze) {
      this.plugin = this.plugin;
   }

   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (sender instanceof Player) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("onlyPlayer")));
      }

      if (!sender.hasPermission("factionfreeze.freeze") && !sender.hasPermission("factionfreeze.*") && !sender.hasPermission("*")) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("noPerms")));
      }

      if (args.length == 0) {
         sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("unfreeze.usage")));
         return false;
      } else {
         Player target = Bukkit.getPlayer(args[0]);
         if (target == null) {
            sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("unfreeze.player-not-found")).replace("%player%", target.getName()));
            return false;
         } else {
            if (args.length == 1) {
               if (target.getWalkSpeed() != 0.0F) {
                  sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("unfreeze.not-frozen")));
               } else {
                  target.setWalkSpeed(2.0F);
                  sender.sendMessage(Utils.Color(this.plugin.getConfig().getString("unfreeze.player-unfreeze").replace("%player%", target.getName())));
               }
            }

            return true;
         }
      }
   }
  
  
  //PLAYER MOVE EVENT
  
  package me.ghostdevelopment.factionfreeze.listner;

import me.ghostdevelopment.factionfreeze.FactionFreeze;
import me.ghostdevelopment.factionfreeze.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListner implements Listener {
   FactionFreeze plugin;

   @EventHandler
   public void onPlayerMove(PlayerMoveEvent event) {
      Player p = event.getPlayer();
      if (p.hasMetadata("frozen")) {
         event.callEvent();
         p.sendMessage(Utils.Color(this.plugin.getConfig().getString("freeze.frozen-message")));
      }

   }
}

  
  
//MAIN CLASS
  
  package me.ghostdevelopment.factionfreeze;

import me.ghostdevelopment.factionfreeze.commands.CommandFinish;
import me.ghostdevelopment.factionfreeze.commands.CommandFreeze;
import me.ghostdevelopment.factionfreeze.commands.CommandUnfreeze;
import me.ghostdevelopment.factionfreeze.listner.PlayerMoveListner;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class FactionFreeze extends JavaPlugin {
   public void onEnable() {
      System.out.println(ChatColor.DARK_PURPLE + "  _____            _             _ _ _ \n / ____|          | |           | | (_)\n| |     ___  _ __ | |_ _ __ ___ | | |_ \n| |    / _ \\| '_ \\| __| '__/ _ \\| | | |\n| |___| (_) | | | | |_| | | (_) | | | |\n \\_____\\___/|_| |_|\\__|_|  \\___/|_|_|_|\n                                       \n                                       ");
      System.out.println(ChatColor.LIGHT_PURPLE + "Controlli by GhostAndry");
      this.getConfig().options().copyDefaults();
      this.saveDefaultConfig();
      this.registerCommands();
      this.registerEvent();
   }

   public void onDisable() {
   }

   void registerCommands() {
      this.getCommand("freeze").setExecutor(new CommandFreeze(this));
      this.getCommand("unfreeze").setExecutor(new CommandUnfreeze(this));
      this.getCommand("finish").setExecutor(new CommandFinish(this));
   }

   void registerEvent() {
      this.getServer().getPluginManager().registerEvents(new PlayerMoveListner(), this);
   }
}

  
 //UTILS CLASS
  
  package me.ghostdevelopment.factionfreeze;

import org.bukkit.ChatColor;

public class Utils {
   public static String Color(String s) {
      return ChatColor.translateAlternateColorCodes('&', s);
   }
}
  
  //CONFIG.YML
  
  onlyPlayer: "&cOnly players."
noPerms: "&cNo Perms"

freeze:
  usage: "&cUsage: /freeze <player>"
  player-not-found: "&cL'utente %player% non e stato trovato."
  player-freeze: "&aHai congelato %player%"
  already-frozen: "&c%player% e' gia congelato"

  # METTERE NEL FINE D'AVVIO PRIMA DI -jar -Dfile.encoding=UTF8
  frozen-message: |-
    &7
    &7█████████
    &7████&c█&7████                      &4&lWARNING!
    &7███&c█&0█&c█&7███
    &7██&c█&6█&0█&6█&c█&7██
    &7██&c█&6█&0█&6█&c█&7██       &cSei stato freezzato. Non sloggare!
    &7█&c█&6██&0█&6██&c█&7█       &cse esci dal server verrai &4&lBANNATO!
    &7█&c█&6█████&c█&7█      &cEntra nel nostro TeamSpeak
    &c█&6███&0█&6███&c█      &7(ts.vantey.it) 
    &c█████████
    &7█████████
    &7

unfreeze:
  usage: "&cUsage: /unfreeze <player>"
  player-not-found: "&cL'utente %player% non e stato trovato."
  player-unfreeze: "&aHai sccongelato %player%"
  not-frozen: "&c%player% e' gia sccongelato"
finish:
    usage: "&cUsage: /finish <player> <posotivo|slog|rifiuto|ammissione>"
    player-not-found: "&cL'utente %player% non e stato trovato."
    specify-finish: "&cDevi specificare il motivo tra uno dei seguenti motivi &7&o(positivo|slog|rifiuto|ammissione)"

    commands:
      rifiuto: "ban %player% 30d Rifiuto controllo hack -s"
      slog: "ban %player% 30d Rifiuto controllo hack -s"
      positivo: "ban %player% 30d Cheating -s"
      ammissione: "ban %player% 14d Ammissione cheating"
      
        
  
  
  onlyPlayer: "&cOnly players."
noPerms: "&cNo Perms"

freeze:
  usage: "&cUsage: /freeze <player>"
  player-not-found: "&cL'utente %player% non e stato trovato."
  player-freeze: "&aHai congelato %player%"
  already-frozen: "&c%player% e' gia congelato"

  # METTERE NEL FINE D'AVVIO PRIMA DI -jar -Dfile.encoding=UTF8
  frozen-message: |-
    &7
    &7█████████
    &7████&c█&7████                      &4&lWARNING!
    &7███&c█&0█&c█&7███
    &7██&c█&6█&0█&6█&c█&7██
    &7██&c█&6█&0█&6█&c█&7██       &cSei stato freezzato. Non sloggare!
    &7█&c█&6██&0█&6██&c█&7█       &cse esci dal server verrai &4&lBANNATO!
    &7█&c█&6█████&c█&7█      &cEntra nel nostro TeamSpeak
    &c█&6███&0█&6███&c█      &7(ts.vantey.it) 
    &c█████████
    &7█████████
    &7

unfreeze:
  usage: "&cUsage: /unfreeze <player>"
  player-not-found: "&cL'utente %player% non e stato trovato."
  player-unfreeze: "&aHai sccongelato %player%"
  not-frozen: "&c%player% e' gia sccongelato"
finish:
    usage: "&cUsage: /finish <player> <posotivo|slog|rifiuto|ammissione>"
    player-not-found: "&cL'utente %player% non e stato trovato."
    specify-finish: "&cDevi specificare il motivo tra uno dei seguenti motivi &7&o(positivo|slog|rifiuto|ammissione)"

    commands:
      rifiuto: "ban %player% 30d Rifiuto controllo hack -s"
      slog: "ban %player% 30d Rifiuto controllo hack -s"
      positivo: "ban %player% 30d Cheating -s"
      ammissione: "ban %player% 14d Ammissione cheating"
      
        
  //PLUGIN.YML
        
        
        name: FactionFreeze
version: '1.0'
main: me.ghostdevelopment.factionfreeze.FactionFreeze
authors: [ GhostAndry ]

commands:
  freeze:
    aliases: ss
    description:
  unfreeze:
    description:
  finish:
    description:

 

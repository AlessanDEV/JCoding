//VANISH COMMAND


package ultrastaffmode.me.alessandev.me.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ultrastaffmode.me.alessandev.me.engineers.VanishEngineer;

public class Vanish implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (!(sender instanceof Player)) {
         System.out.println("Errore solo i player possono usare questo comando");
         return true;
      } else {
         Player player = (Player)sender;
         if (player.hasPermission("staff.use.engineers")) {
            VanishEngineer.VanishEgineer(player);
         } else {
            sender.sendMessage("§e[Staff] §7Nessun permesso.");
         }

         return false;
      }
   }
}

//VANISH ENGINEER

package ultrastaffmode.me.alessandev.me.engineers;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ultrastaffmode.me.alessandev.me.utils.Utils;

public class VanishEngineer {
   public static void VanishEgineer(Player player) {
      Iterator var1;
      Player users;
      if (Utils.getHiddenPlayers().contains(player)) {
         player.sendMessage("§e[Staff] §7Hai la vanish §cdisabilitata");
         Utils.getHiddenPlayers().remove(player);
         var1 = Bukkit.getOnlinePlayers().iterator();

         while(var1.hasNext()) {
            users = (Player)var1.next();
            users.showPlayer(player);
         }
      } else {
         Utils.getHiddenPlayers().add(player);
         player.sendMessage("§e[Staff] §7Hai la vanish §aabilitata");
         var1 = Bukkit.getOnlinePlayers().iterator();

         while(var1.hasNext()) {
            users = (Player)var1.next();
            if (!users.hasPermission("staff.skipvanish.use")) {
               users.hidePlayer(player);
            }
         }
      }

   }
  
  //UTILS 

package ultrastaffmode.me.alessandev.me.utils;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;

public class Utils {
   static List<Player> hiddenPlayers = new ArrayList();
   static List<Player> freezedPlayer = new ArrayList();

   public static List<Player> getFreezedPlayer() {
      return freezedPlayer;
   }

   public static List<Player> getHiddenPlayers() {
      return hiddenPlayers;
   }
}

  //STAFF COMMAND

package ultrastaffmode.me.alessandev.me.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Staff implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      if (!(sender instanceof Player)) {
         System.out.println("Errore solo i player possono usare questo comando");
      } else {
         Player var5 = (Player)sender;
      }

      return false;
   }
}

  //MAIN
  
  package ultrastaffmode.me.alessandev.me;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ultrastaffmode.me.alessandev.me.commands.Vanish;

public final class Main extends JavaPlugin {
   public void onEnable() {
      Bukkit.getServer().getConsoleSender().sendMessage("§e[Staff] §7Plugin abilitato");
      this.Commands();
   }

   public void Commands() {
      this.getCommand("vanish").setExecutor(new Vanish());
   }
}

  
  
  //PLUGIN.YML
  
  
  

name: me.Alessandev
version: '1.0'
main: ultrastaffmode.me.alessandev.me.Main
load: STARTUP
authors: [ ALESSANDEV ]

commands:
  vanish:
    aliases: [v , vanish]

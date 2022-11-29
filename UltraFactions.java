//MAIN


package me.alessandev.ultrafactions;

import me.alessandev.ultrafactions.Events.Droghe;
import me.alessandev.ultrafactions.Events.OnJoin;
import me.alessandev.ultrafactions.Events.OnLeave;
import me.alessandev.ultrafactions.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public void Commands() {

        getCommand("prova").setExecutor(new prova());
        getCommand("droghe").setExecutor(new me.alessandev.ultrafactions.commands.Droghe());
        getCommand("ultrafactions").setExecutor(new UltraFactions());
        getCommand("help").setExecutor(new Help());
        getCommand("discord").setExecutor(new Discord());
        getCommand("teamspeak").setExecutor(new TeamSpeak());
        getCommand("telegram").setExecutor(new Telegram());
        getCommand("website").setExecutor(new Website());
    }

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("§9[UltraFactions] §fPlugin §aabilitato");
        Bukkit.getLogger().info("§9[UltraFactions] §fStai usando l'ulitima §aversione");
        Bukkit.getLogger().info("§9[UltraFactions] §fCreato da §aAlessandev");
        Events();
        Commands();
    }

    public void Events() {

        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(new OnLeave(), this);
        getServer().getPluginManager().registerEvents(new Droghe(), this);


    }

}

//JOIN EVENT


package me.alessandev.ultrafactions.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        event.setJoinMessage(null);

        event.setJoinMessage("§3[Fazioni] §a+ §7" + player.getName());

    }

}


//QUIT EVENT


package me.alessandev.ultrafactions.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLeave implements Listener {

    @EventHandler
    public void OnLeave(PlayerQuitEvent event){

        Player player = event.getPlayer();

        event.setQuitMessage(null);

        event.setQuitMessage("§3[Fazioni] §c- §7" + player.getName());

    }

}


//DROGHE


package me.alessandev.ultrafactions.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Droghe implements Listener {


    @EventHandler
    public void Azione(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final ItemStack stack = p.getInventory().getItemInHand();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && stack.getType() == Material.SUGAR) {
            final short data = ((ItemStack) stack).getDurability();
            final ItemStack old = new ItemStack(e.getPlayer().getItemInHand().getType(), e.getPlayer().getItemInHand().getAmount() - 1, data);
            e.getPlayer().setItemInHand(old);
            e.getPlayer().updateInventory();
            p.setFoodLevel(20);
            p.sendMessage("§3[Fazioni] §7Hai assunto della §fcocaina§7 inizi a sentirti piu §fveloce");
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 210, 2));
        }
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && stack.getType() == Material.SLIME_BALL) {
            final short data = stack.getDurability();
            final ItemStack old = new ItemStack(e.getPlayer().getItemInHand().getType(), e.getPlayer().getItemInHand().getAmount() - 1, data);
            e.getPlayer().setItemInHand(old);
            e.getPlayer().updateInventory();
            p.setFoodLevel(20);
            p.sendMessage("§3[Fazioni] §7Hai usato dell'§2Hashish§7 ora ti senti piu §2forte");
            p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 210, 2));
        }
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && stack.getType() == Material.BLAZE_POWDER) {
            final short data = stack.getDurability();
            final ItemStack old = new ItemStack(e.getPlayer().getItemInHand().getType(), e.getPlayer().getItemInHand().getAmount() - 1, data);
            e.getPlayer().setItemInHand(old);
            e.getPlayer().updateInventory();
            p.setFoodLevel(20);
            p.sendMessage("§3[Fazioni] §7Hai usato dell'§cMdma§7 inizi a sentirti §crigenerato");
            p.removePotionEffect(PotionEffectType.REGENERATION);
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 210, 1));
        }

    }


}


//ULTRA FACTIONS COMMAND

package me.alessandev.ultrafactions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UltraFactions implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
                Player player = (Player) sender;{

                    sender.sendMessage("§9[UltraFactions] §7By Alessan§3dev");
                } return true;
        } else {
            sender.sendMessage("§9[UltraFactions] §7By Alessan§3dev");
        } return false;

    }

  //

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

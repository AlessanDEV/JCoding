package org.onedevelopment.dragonanticheat.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.onedevelopment.dragonanticheat.DragonAntiCheat;
import org.onedevelopment.dragonanticheat.Utils.ColorUtil;

public class DragonAC implements CommandExecutor {

    DragonAntiCheat plugin;
    public DragonAC(DragonAntiCheat plugin){this.plugin=plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)){
            System.out.println(ColorUtil.Color(plugin.getConfig().getString("messages.only-player")));
            return false;
        }
        if (!(sender.hasPermission("dragonanticheat.command")||sender.hasPermission("dragonanticheat.*")||sender.hasPermission("*"))){
            sender.sendMessage(ColorUtil.Color(plugin.getConfig().getString("messages.noPerms")));
            return false;
        }

        if(args.length==0) {
            sender.sendMessage(ColorUtil.Color("&cDragonAnticheat &e by OneDevelopment\n\n" +
                    "&eBy GhostAndry & ALESSANDEV &c<3"));
        } else if (args.length == 1) {
            if(args[0]=="reload") {
                if (!(sender.hasPermission("dragonanticheat.command.reload")||sender.hasPermission("dragonanticheat.command.*"))) {
                    sender.sendMessage(ColorUtil.Color(plugin.getConfig().getString("noPerms")));
                    return false;
                }
                plugin.reloadConfig();
                sender.sendMessage(ColorUtil.Color("&aPlugin reloaded"));
            }else if (args[0] == "help"){
                if (!(sender.hasPermission("dragonanticheat.help"))) {
                    sender.sendMessage(ColorUtil.Color(plugin.getConfig().getString("noPerms")));
                    return false;
                }

                sender.sendMessage(ColorUtil.Color(plugin.getConfig().getString("messages.help-message")));
            }
        } else if (args [0] == "info") {
            if (!(sender.hasPermission("dragonanticheat.info"))){
                sender.sendMessage(ColorUtil.Color(plugin.getConfig().getString("noPerms")));
                return false;
            }
            sender.sendMessage(ColorUtil.Color(
                    "Dragon AntiCheat\n\n"+
                            "&7Dragon was created by &e2&7 devs\n" +
                            "&eALESSANDEV &7and &eGhostAndry\n" +
                            "&7In 2022 when the anticheats in the &eecommerce\n" +
                            "&7were not the &ebest &7our &cac&7 is the best in the &emarket &7atm.\n"
            ));
        } else if (args [0] == "cps") {

            Player target = Bukkit.getPlayer(args[1]);

            if(target==null){
                sender.sendMessage(ColorUtil.Color("&cUsage: /dragonac cps <target>"));
                return false;
            }
            if (target==sender){
                return false;
            }
            if (!(sender.hasPermission("dragonac.cps")));{
                sender.sendMessage(ColorUtil.Color("&cSoon"));}

        }
        return true;
    }
}

package me.darklife12345.eaglerplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            switch (args.length) {
                case 0:
                    sender.sendMessage(colorize("&4&lEagler &b&o: &4You need to specify a player."));
                    sender.sendMessage(colorize("&4&lEagler &b&o: &e/heal &b<player>."));
                    break;
                case 1:
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        sender.sendMessage(colorize("&4&lEagler &b&o: &4This player is offline."));
                    } else {
                        target.setHealth(20);
                        target.sendMessage(colorize("&4&lEagler &b&o: &aYou've been healed by the &e&oConsole&a."));
                        sender.sendMessage(colorize("&4&lEagler &b&o: &aYou've healed &e&o" + target.getName() + "&a."));
                    }
                    break;
            }
        } else {
            sender.sendMessage(colorize("Not ready yet"));
        }

        return true;
    }
    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

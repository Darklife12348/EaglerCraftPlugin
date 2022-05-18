package me.darklife12345.eaglerplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            switch (args.length) {
                case 0:
                    sender.sendMessage(colorize("&4&lEagler &b&o: &4You need to specify a player."));
                    sender.sendMessage(colorize("&4&lEagler &b&o: &e/fly &b<player>."));
                    break;
                case 1:
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        sender.sendMessage(colorize("&4&lEagler &b&o: &4This player is offline."));
                    } else {
                        if (target.getAllowFlight()) {
                            target.setAllowFlight(false);
                            target.sendMessage(colorize("&4&lEagler &b&o: &aYou can't fly anymore."));
                            sender.sendMessage(colorize("&4&lEagler &b&o: &aYou have &4&lDisabled &aflight for &e&o" + target.getName() + "&a."));
                        } else {
                            target.setAllowFlight(true);
                            target.sendMessage(colorize("&4&lEagler &b&o: &aYou can now fly."));
                            sender.sendMessage(colorize("&4&lEagler &b&o: &aYou have &a&lEnabled&r &aflight for &e&o" + target.getName() + "&a."));
                        }
                    }
                    break;
                case 2:
                    if (args[1].equalsIgnoreCase("enable")) {
                        target = Bukkit.getPlayerExact(args[0]);
                        target.setAllowFlight(true);
                        target.sendMessage(colorize("&4&lEagler &b&o: &aYou can now fly."));
                        sender.sendMessage(colorize("&4&lEagler &b&o: &aYou have &a&lEnabled&r &aflight for &e&o" + target.getName() + "&a."));
                    } else if (args[1].equalsIgnoreCase("disable")) {
                        target = Bukkit.getPlayerExact(args[0]);
                        target.setAllowFlight(false);
                        target.sendMessage(colorize("&4&lEagler &b&o: &aYou can't fly anymore."));
                        sender.sendMessage(colorize("&4&lEagler &b&o: &aYou have &4&lDisabled &aflight for &e&o" + target.getName() + "&a."));
                    }
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

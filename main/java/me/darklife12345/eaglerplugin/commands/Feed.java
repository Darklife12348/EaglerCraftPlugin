package me.darklife12345.eaglerplugin.commands;

import me.darklife12345.eaglerplugin.EaglerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {
    public EaglerPlugin plugin;

    public Feed(final EaglerPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            switch (args.length) {
                case 0:
                    sender.sendMessage(colorize("&4&lEagler &b&o: &4You need to specify a player."));
                    sender.sendMessage(colorize("&4&lEagler &b&o: &e/feed &b<player>."));
                    break;
                case 1:
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        sender.sendMessage(colorize("&4&lEagler &b&o: &4This player is offline."));
                    } else {

                        target.setFoodLevel(20);
                        target.sendMessage(colorize("&4&lEagler &b&o: &aYou've been fed by the &e&oConsole&a."));
                        sender.sendMessage(colorize("&4&lEagler &b&o: &aYou've fed &e&o" + target.getName() + "&a."));
                    }
                    break;
            }
        } else {
            Player player = (Player) sender;
            player.setFoodLevel(20);
            player.sendMessage(colorize("&4&lEagler &b&o: &aYou've been fed."));
        }

        return true;
    }
    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

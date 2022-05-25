package me.darklife12345.eaglerplugin.commands;

import me.darklife12345.eaglerplugin.EaglerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class MultiSummon implements CommandExecutor {
    public EaglerPlugin plugin;

    public MultiSummon(EaglerPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {

        } else {
            Player player = (Player) sender;
            switch (args.length) {
                case 0:
                    sender.sendMessage(colorize("&4&lEagler &b&o: &4You need to specify an entity and an amount."));
                    sender.sendMessage(colorize("&4&lEagler &b&o: &e/ms &e&o<entity> <amount>"));
                    break;
                case 1:
                    sender.sendMessage(colorize("&4&lEagler &b&o: &4You need to specify an amount."));
                    sender.sendMessage(colorize("&4&lEagler &b&o: &e/ms <entity> &e&o<amount>"));
                    break;
                case 2:
                    try {
                        EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                        int amount = Integer.parseInt(args[1]);
                        for (int i = 0; i < amount; i++) {
                            player.getWorld().spawnEntity(player.getLocation(), entity);
                        }

                        sender.sendMessage(colorize("&4&lEagler &b&o: &aYou summon &b&o"));
                    } catch (IllegalArgumentException e) {
                        player.sendMessage(colorize("&4&lEagler &b&o: &4This is not an entity."));
                    }
                    break;
            }
        }

        return true;
    }

    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

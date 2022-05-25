package me.darklife12345.eaglerplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Eagler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (command.getName().equalsIgnoreCase("eagler")) {
            switch (args.length) {
                case 0:
                    sender.sendMessage(colorize("EaglerCraft is a minecraft based client made to run 1.5.2 on chrome."));
                    break;
                case 1:
                    if (args[0].equalsIgnoreCase("server")) {
                        String eaglerServer = Bukkit.getServerName();
                        sender.sendMessage(colorize(eaglerServer));
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

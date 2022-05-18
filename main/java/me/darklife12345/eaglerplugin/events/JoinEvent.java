package me.darklife12345.eaglerplugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage("");
        if (player.hasPlayedBefore()) {
            Bukkit.broadcastMessage(colorize("&4Eagler &b&o: &eWelcome back &e&o" + player.getName()));
        } else {
            Bukkit.broadcastMessage(colorize("&4Eagler &b&o: &e&o" + player.getName() + "&e has joined for the first time!"));
        }

    }

    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

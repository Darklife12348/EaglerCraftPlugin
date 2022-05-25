package me.darklife12345.eaglerplugin.events;

import me.darklife12345.eaglerplugin.EaglerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    public EaglerPlugin plugin;

    public JoinEvent(EaglerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String firstJoinMessage = this.plugin.getConfig().getString("FirstJoinMsg");
        String welcomeBackMessage = this.plugin.getConfig().getString("WelcomeBackMsg");
        String newFirstJoinMessage = firstJoinMessage.replace("{player}", player.getName());
        String newWelcomeBackMessage = welcomeBackMessage.replace("{player}", player.getName());
        if (player.hasPlayedBefore()) {
            Bukkit.broadcastMessage(colorize(newWelcomeBackMessage));
        } else {
            Bukkit.broadcastMessage(colorize(newFirstJoinMessage));
        }
        e.setJoinMessage("");
    }

    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

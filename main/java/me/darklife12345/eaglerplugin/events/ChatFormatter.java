package me.darklife12345.eaglerplugin.events;

import me.darklife12345.eaglerplugin.EaglerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatter implements Listener {
    public EaglerPlugin plugin;

    public ChatFormatter(EaglerPlugin plugin) {
        this.plugin = plugin;
    }

    public void onChatSend(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        // Strings/Booleans
        boolean formattedChat = Boolean.parseBoolean(String.valueOf(this.plugin.getConfig().getBoolean("FormattedChat")));
        String getMessage = this.plugin.getConfig().getString("ChatFormat");

        String sendMessage = getMessage.replace("{player}", player.getName()).replace("{message}", e.getMessage());
        Bukkit.broadcastMessage(colorize(sendMessage));

        // Some Code
        e.setCancelled(true);

    }
    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}

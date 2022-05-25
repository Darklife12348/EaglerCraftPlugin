package me.darklife12345.eaglerplugin.events;

import me.darklife12345.eaglerplugin.EaglerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    public EaglerPlugin plugin;

    public LeaveEvent(EaglerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String leaveMessage = this.plugin.getConfig().getString("LeaveMsg");
        String newLeaveMessage = leaveMessage.replace("{player}", player.getName());

        Bukkit.broadcastMessage(colorize(newLeaveMessage));
        e.setQuitMessage("");
    }

    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

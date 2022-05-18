package me.darklife12345.eaglerplugin;

import me.darklife12345.eaglerplugin.commands.Feed;
import me.darklife12345.eaglerplugin.commands.Fly;
import me.darklife12345.eaglerplugin.commands.Heal;
import me.darklife12345.eaglerplugin.commands.Starve;
import me.darklife12345.eaglerplugin.events.JoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EaglerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Config
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();

        // Start Message

        this.getServer().getConsoleSender().sendMessage(this.colorize("&4&lEagler &b&o: &aStarting &e&oEaglerPlugin"));

        //Commands
        (this.getCommand("fly")).setExecutor(new Fly());
        (this.getCommand("heal")).setExecutor(new Heal());
        (this.getCommand("feed")).setExecutor(new Feed(this));
        (this.getCommand("starve")).setExecutor(new Starve());

        //Events
        final PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new JoinEvent(), this);
    }

    @Override
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(this.colorize("&4&lEagler &b&o: &4Stopping &e&oEaglerPlugin"));

    }

    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


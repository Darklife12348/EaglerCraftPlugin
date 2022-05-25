package me.darklife12345.eaglerplugin;

import me.darklife12345.eaglerplugin.commands.*;
import me.darklife12345.eaglerplugin.events.ChatFormatter;
import me.darklife12345.eaglerplugin.events.JoinEvent;
import me.darklife12345.eaglerplugin.events.LeaveEvent;
import org.bukkit.Bukkit;
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
        Bukkit.getConsoleSender().sendMessage(colorize("&4&lEagler &b&o: &aStarting &e&oEaglerPlugin"));

        //Commands
        (this.getCommand("fly")).setExecutor(new Fly());
        (this.getCommand("feed")).setExecutor(new Feed(this));
        (this.getCommand("starve")).setExecutor(new Starve());
        (this.getCommand("eagler")).setExecutor(new Eagler());
        (this.getCommand("multisummon")).setExecutor(new MultiSummon(this));
        this.getCommand("multisummon").setTabCompleter(new TabCompletion());


        //Events
        final PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new JoinEvent(this), this);
        pm.registerEvents(new LeaveEvent(this), this);
        pm.registerEvents(new ChatFormatter(this), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(colorize("&4&lEagler &b&o: &4Stopping &e&oEaglerPlugin"));
    }

    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


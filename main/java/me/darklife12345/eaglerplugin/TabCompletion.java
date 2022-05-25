package me.darklife12345.eaglerplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TabCompletion implements TabCompleter {

    List<String> arguments = new ArrayList<>();

    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        if (command.getName().equalsIgnoreCase("multisummon")) {
            if (args.length != 1) return Collections.emptyList();
            if (!sender.hasPermission("server.multisummon")) return Collections.emptyList();

            return StringUtil.copyPartialMatches(args[0], Stream.of(EntityType.values()).map(Enum::name).map(String::toLowerCase).collect(Collectors.toList()), new ArrayList<>());
        } else if (command.getName().equalsIgnoreCase("fly")) {
            if (args.length != 1) return Collections.emptyList();
            if (!sender.hasPermission("server.fly")) return Collections.emptyList();

            arguments.add("enable");
            arguments.add("disable");
        }

        List<String> result = new ArrayList<>();
        if (args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }

        return null;
    }
}

package org.spigotmc.Economyplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RankCommand implements CommandExecutor{
    private Ranks ranks;

    public RankCommand(Ranks ranks) {
        this.ranks = ranks;
    }

    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        if (args.length != 2) {
            cs.sendMessage(ChatColor.RED + "Not enough Args have been used.");
            cs.sendMessage(ChatColor.GREEN + "Usage: /rank <add/remove/set> <player> <Rank> (The rank must be uppercase!)");
            return true;
        }
        String addRmoveSet = args[0];
        String player = args[1];
        switch (addRmoveSet) {
            case "add":
                break;
            case "remove":
                break;
            case "set":
                if (!ranks.hasRank(player)) {
                    cs.sendMessage(ChatColor.RED + "Error: Player " + player + " does not exist");
                    return true;
                }
                String rank = args[2];
                ranks.setRank(player, rank);
                break;
        }
        return true;
    }
}



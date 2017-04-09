package org.spigotmc.Economyplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StatusCommand implements CommandExecutor {
    private Ranks ranks;
    private Balances balances;

    public StatusCommand(Ranks ranks, Balances balances) {
        this.ranks = ranks;
        this.balances = balances;
    }

    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        if (args.length != 1) {
            cs.sendMessage(ChatColor.RED + "Not enough Args have been used.");
            cs.sendMessage(ChatColor.GREEN + "Usage: /status <playername>");
            return true;
        }
        String player = args[0];
        if (!ranks.hasRank(player) || !balances.hasBalance(player)) {
            cs.sendMessage(ChatColor.RED + "Error: Player missing rank and/or balance");
            return true;
        }
        try {
            cs.sendMessage(ChatColor.BLUE + "Balance: " + balances.getBalance(player) + " Ducat(s)," + " Rank:" + ranks.getRank(player));
            return true;
        } catch (Exception e) {
            cs.sendMessage(ChatColor.RED + "Invalid command, try /balance.");
            return true;
        }

    }
}

	
		


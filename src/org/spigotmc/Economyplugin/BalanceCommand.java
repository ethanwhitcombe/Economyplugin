package org.spigotmc.Economyplugin;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BalanceCommand implements CommandExecutor {
    private Balances balances;

    public BalanceCommand(Balances balances) {
        this.balances = balances;
    }

    private boolean usage(CommandSender cs) {
        cs.sendMessage(ChatColor.RED + "Not enough Args have been used.");
        cs.sendMessage(ChatColor.GREEN + "Usage: /econ <add/remove/set> <player> [<amount>]");
        return true;
    }

    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        if (args.length < 3) {
            return usage(cs);
        }

        String player = args[1];
        if (!balances.hasBalance(player)) {
            cs.sendMessage(ChatColor.RED + "Error: Player " + player + " does not have an account");
            return true;
        }
        double amount = 0.0;
        try {
            amount = Double.parseDouble(args[2]);
        } catch (NumberFormatException nfe) {
            cs.sendMessage(ChatColor.RED + "You need to enter a number.");
            return true;
        }
        switch (args[0]) {
            case "add":
                balances.addBalance(player, amount);
                break;
            case "remove":
                balances.subtractBalance(player, amount);
                break;
            case "set":
                balances.setBalance(player, amount);
                break;
            default:
                return usage(cs);
        }
        return true;
    }
}

	
		



	

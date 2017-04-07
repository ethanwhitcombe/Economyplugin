package org.spigotmc.Economyplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EconomyCommand2 implements CommandExecutor
{
	public boolean onCommand(CommandSender cs, Command command, String s, String[] args)
	{
		if(args.length != 1)
		{
			cs.sendMessage(ChatColor.RED+"Not enough Args have been used.");
			cs.sendMessage(ChatColor.GREEN+"Usage: /balance <playername>");
			return true;
		}
		if(!Economymanager.hasAccount(args[0]))
			{cs.sendMessage(ChatColor.RED+"Error: Player does not have an account");
			return true;
			}
			double bal = Economymanager.getRunningBalance(args[0]);
			String rank = Rankmanager.getRunningBalance(args[0]);
			try
			{
				cs.sendMessage(ChatColor.BLUE+ "Balance: "+ bal + " Ducat(s)," +" Rank:"+ rank);
				return true;
			}catch (Exception e)
			{
				cs.sendMessage(ChatColor.RED+"Invalid command, try /balance.");
				return true;
			}

	}
	}

	
		


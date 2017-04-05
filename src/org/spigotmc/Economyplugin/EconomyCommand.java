package org.spigotmc.Economyplugin;



import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EconomyCommand implements CommandExecutor
{
	public boolean onCommand(CommandSender cs, Command command, String s, String[] args)
	{
	  if(args.length != 3)
		{
			cs.sendMessage(ChatColor.RED+"Not enough Args have been used.");
			cs.sendMessage(ChatColor.GREEN+"Usage: /econ <add/remove/set> <player> <amount>");
			return true;
		}
		if(args[0].equalsIgnoreCase("add"))
		{
			if(!Economymanager.hasAccount(args[1]))
			{cs.sendMessage(ChatColor.RED+"Error: Player does not have an account");
			return true;
			}
			double amount = 0;
			try
			{
				amount = Double.parseDouble(args[2]);
			}catch (Exception e)
			{
				cs.sendMessage(ChatColor.RED+"You need to enter a number.");
				return true;
			}
			Economymanager.setBalance(args[1], Economymanager.getRunningBalance(args[1]) + amount);
		}else if (args[0].equalsIgnoreCase("remove"))
		{
			if(!Economymanager.hasAccount(args[1]))
			{cs.sendMessage(ChatColor.RED+"Error: Player does not have an account");
			return true;
			}
			double amount = 0;
			try
			{
				amount = Double.parseDouble(args[2]);
			}catch (Exception e)
			{
				cs.sendMessage(ChatColor.RED+"You need to enter a number.");
				return true;
			}
			Economymanager.setBalance(args[1], Economymanager.getRunningBalance(args[1]) - amount);
			
		}else if (args[0].equalsIgnoreCase("set"))
		{
			if(!Economymanager.hasAccount(args[1]))
			{cs.sendMessage(ChatColor.RED+"Error: Player does not have an account");
			return true;
			}
			double amount = 0;
			try
			{
				amount = Double.parseDouble(args[2]);
			}catch (Exception e)
			{
				cs.sendMessage(ChatColor.RED+"You need to enter a number.");
				return true;
			}
			Economymanager.setBalance(args[1], amount);
			
		}else if (args[0].equalsIgnoreCase("Balance"))
		{
			if(!Economymanager.hasAccount(args[1]))
			{cs.sendMessage(ChatColor.RED+"Error: Player does not have an account");
			return true;
			}
			double bal = Economymanager.getRunningBalance(args[1]);
			try
			{
				cs.sendMessage(ChatColor.BLUE+ "Balance"+ bal );
				return true;
			}catch (Exception e)
			{
				cs.sendMessage(ChatColor.RED+"Invalid command, try /balance.");
				return true;
			}
		}else
		{
			cs.sendMessage(ChatColor.RED+"Incorrect argument");
			return true;
		}
		return true;
	}
	}

	
		



	

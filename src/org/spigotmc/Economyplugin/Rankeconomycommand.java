package org.spigotmc.Economyplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Rankeconomycommand 
	{
		public boolean onCommand(CommandSender cs, Command command, String s, String[] args)
		{
		  if(args.length != 3)
			{
				cs.sendMessage(ChatColor.RED+"Not enough Args have been used.");
				cs.sendMessage(ChatColor.GREEN+"Usage: /econ <add/remove/set> <player> <Rank> (The rank must be uppercase!)");
				return true;
			}
			if(args[0].equalsIgnoreCase("set"))
			{
				if(!Rankmanager.hasAccount(args[1]))
				{cs.sendMessage(ChatColor.RED+"Error: Player does not exist");
				return true;
				}
				String amount = "";
				try
				{
					amount = (args[2]);
				}catch (Exception e)
				{
					cs.sendMessage(ChatColor.RED+"You need to enter a rank.");
					return true;
				}
				Rankmanager.setBalance(args[1], amount);
				Rankmanager.setBalance(args[1], Rankmanager.getRunningBalance(args[1]) + amount);
			}else
			{
				cs.sendMessage(ChatColor.RED+"Incorrect argument");
				return true;
			}
			return true;
		}
		}



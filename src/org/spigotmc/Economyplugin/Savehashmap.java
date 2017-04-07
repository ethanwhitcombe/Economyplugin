package org.spigotmc.Economyplugin;

public class Savehashmap
{
	private static Main plugin = Economymanager.getPlugin();

	
public static void saveBalances()
	{
	
		for(String player : Economymanager.getBalanceMap().keySet())
		{
			
			plugin.getConfig().set("balance."+player, Economymanager.getBalanceMap().get(player));
		}
		plugin.saveConfig();
		return;
	}
}

	
		




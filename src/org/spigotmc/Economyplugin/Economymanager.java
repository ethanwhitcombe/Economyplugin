package org.spigotmc.Economyplugin;
import java.util.HashMap;



public class Economymanager 
{
	private static Main plugin;
	public Economymanager(Main instance)
	{
		plugin = instance;
	}
	public static HashMap<String, Double> bal = new HashMap<String, Double>(); //{PlayerName, Balance}
	public static void loadPermBalance()
	{
		for(String player : Loadhashmap.getPermBalanceMap().keySet())
		{
			bal.put("balance."+player, Loadhashmap.getPermBalanceMap().get(player));
		}
		return;
	}
	public static void setBalance(String player, double amount)
	{
		bal.put(player, amount);
	}
	public static Double getRunningBalance(String player)
	{
		return bal.get(player);
	}
	public static boolean hasAccount(String player)
	{
		return bal.containsKey(player);
	}
	public static HashMap<String, Double> getBalanceMap()
	{
		return bal;
	}
	public static Main getPlugin()
	{
		return plugin;
	}
		
}



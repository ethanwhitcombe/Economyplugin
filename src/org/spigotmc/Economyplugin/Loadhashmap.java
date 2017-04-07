package org.spigotmc.Economyplugin;

import java.util.HashMap;

public class Loadhashmap 
{
	private static Main hell;
	public static HashMap<String, Double> permbal = new HashMap<String, Double>();
	{
	}
	public Loadhashmap(Main instance)
	{
		hell = instance;
		for(String player : hell.getConfig().getConfigurationSection("balance").getKeys(false))
		{   		
			//permbal.get(player + "balance");
			permbal.put(player, hell.getConfig().getDouble("balance."+player));
			
		}
		//return;
	}

	public static HashMap<String, Double> getPermBalanceMap()
	{
		//permbal.put()
		return permbal;
	}
	public static Main gethell()
	{
		return hell;
	}
}

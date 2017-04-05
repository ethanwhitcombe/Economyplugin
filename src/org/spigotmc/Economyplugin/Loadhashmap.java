package org.spigotmc.Economyplugin;

import java.util.HashMap;

public class Loadhashmap 
{
	private static Main hell;
	public Loadhashmap(Main instance)
	{
		hell = instance;
	}
	public static HashMap<String, Double> permbal = new HashMap<String, Double>();
	{
		//if(hell.getConfig().contains("balance."))
			//{
				for(String player : hell.getConfig().getConfigurationSection("balance").getKeys(false))
					{   		
						permbal.get(player + "balance");
					}
	        
			//}
	}
	public static HashMap<String, Double> getPermBalanceMap()
	{
		return permbal;
	}
	public static Main gethell()
	{
		return hell;
	}
}

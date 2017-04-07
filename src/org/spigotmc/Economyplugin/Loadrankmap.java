package org.spigotmc.Economyplugin;

import java.util.HashMap;

public class Loadrankmap
{
	private static Main hell;
	public static HashMap<String, String> permrank = new HashMap<String, String>();
	{
	}
	public Loadrankmap(Main instance)
	{
		hell = instance;
		for(String player : hell.getConfig().getConfigurationSection("rank").getKeys(false))
		{   		
			//permbal.get(player + "balance");
			permrank.put(player, hell.getConfig().getString("rank."+player));
			
		}
		//return;
	}

	public static HashMap<String, String> getPermRankMap()
	{
		//permbal.put()
		return permrank;
	}
	public static Main gethell()
	{
		return hell;
	}
}

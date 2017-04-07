package org.spigotmc.Economyplugin;

import java.util.HashMap;

public class Rankmanager 
	{
		private static Main plugin;
		public static HashMap<String, String> bal = new HashMap<String, String>(); //{PlayerName, Balance}
		public Rankmanager(Main instance)
		{
			plugin = instance;
			for(String player : Loadrankmap.getPermRankMap().keySet())
			{
				bal.put(player, Loadrankmap.getPermRankMap().get(player));
			}
		}
		public static void setBalance(String player, String rank)
		{
			bal.put(player, rank);
		}
		public static String getRunningBalance(String player)
		{
			return bal.get(player);
		}
		public static boolean hasAccount(String player)
		{
			return bal.containsKey(player);
		}
		public static HashMap<String, String> getRankMap()
		{
			return bal;
		}
		public static Main getPlugin()
		{
			return plugin;
		}
			
	}


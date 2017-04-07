package org.spigotmc.Economyplugin;

public class Saverankmap 	
	{
		private static Main plugin = Rankmanager.getPlugin();

		public static void saveRanks()
		{
	for(String player : Rankmanager.getRankMap().keySet())
	{
		
		plugin.getConfig().set("rank."+player, Rankmanager.getRankMap().get(player));
	}
	plugin.saveConfig();
	return;
}}


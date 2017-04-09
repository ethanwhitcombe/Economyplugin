package org.spigotmc.Economyplugin;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

public class Ranks
{
	private static HashMap<String, String> playerRanks = new HashMap<String, String>();

	private static Ranks ranks;

	public static Ranks getInstance(Main plugin){
		if(ranks == null)
			ranks = new Ranks(plugin);
		return ranks;
	}

	private Ranks(Main plugin)
	{
		ConfigurationSection section = plugin.getConfig().getConfigurationSection("rank");
		if(section != null) {
			for (String player : section.getKeys(false)) {
				playerRanks.put(player, section.getString(player));
			}
		}
	}

	public boolean hasRank(String player) {
		return playerRanks.containsKey(player);
	}

	public String getRank(String player) {
		return playerRanks.get(player);
	}

	public void setRank(String player, String rank) {
		playerRanks.put(player, rank);
	}

	public void saveRanks(Main plugin) {
		ConfigurationSection section = plugin.getConfig().getConfigurationSection("rank");
		if(section == null)
			section = plugin.getConfig().createSection("rank");
		for(String player : playerRanks.keySet())
		{
			section.set(player, getRank(player));
		}
		plugin.saveConfig();
	}
}

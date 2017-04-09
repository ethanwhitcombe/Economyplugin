package org.spigotmc.Economyplugin;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

public class Balances
{
	private static HashMap<String, Double> playerBalances = new HashMap<String, Double>();

	private static Balances balances;

	public static Balances getInstance(Main plugin) {
		if(balances == null)
			balances = new Balances(plugin);
		return balances;
	}

	private Balances(Main instance)
	{
		ConfigurationSection section = instance.getConfig().getConfigurationSection("balance");
		if(section != null) {
			for (String player : section.getKeys(false)) {
				playerBalances.put(player, section.getDouble(player));
			}
		}
		else {

		}
	}

	public boolean hasBalance(String player) {
		return playerBalances.containsKey(player);
	}

	public void addBalance(String player, double amount) {
		playerBalances.put(player, playerBalances.get(player) + amount);
	}

	public void subtractBalance(String player, double amount) {
		playerBalances.put(player, playerBalances.get(player) - amount);
	}

	public void setBalance(String player, double amount) {
		playerBalances.put(player, amount);
	}

	public Double getBalance(String player) {
		return playerBalances.get(player);
	}

	public void saveBalances(Main plugin) {
		ConfigurationSection section = plugin.getConfig().getConfigurationSection("balance");
		if(section == null)
			section = plugin.getConfig().createSection("balance");
		for(String player : playerBalances.keySet()) {
			section.set(player, getBalance(player));
		}
		plugin.saveConfig();
	}
}

package org.spigotmc.Economyplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin 
{
	Balances balances;
	Ranks ranks;

    @Override
    public void onEnable() {
		balances = Balances.getInstance(this);
		ranks = Ranks.getInstance(this);
		getCommand("econ").setExecutor(new BalanceCommand(balances));
		getCommand("balance").setExecutor(new StatusCommand(ranks, balances));
		getCommand("rank").setExecutor(new RankCommand(ranks));

		this.getServer().getPluginManager().registerEvents(new PlayerJoin(ranks, balances), this);
    }
   
    @Override
    public void onDisable() {
    	if(balances != null)
    		balances.saveBalances(this);
    	if(ranks != null)
    		ranks.saveRanks(this);
    }

}

package org.spigotmc.Economyplugin;

//import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;




public class Main extends JavaPlugin 
{
    @Override
    public void onEnable() {
		getCommand("econ").setExecutor(new EconomyCommand());
		getCommand("balance").setExecutor(new EconomyCommand2());
		new Loadhashmap(this);
		new Economymanager(this);
		new Loadrankmap(this);
		new Rankmanager(this);

		this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }
   
    @Override
    public void onDisable() {
    	//public void savingloadingAPI.saveBalances();
    	Savehashmap.saveBalances();
    	Saverankmap.saveRanks();
    	
       
    }

}

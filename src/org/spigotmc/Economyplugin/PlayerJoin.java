package org.spigotmc.Economyplugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.player.PlayerJoinEvent;

	public class PlayerJoin implements Listener
	{
		@EventHandler
		public void onPlayerJoin(PlayerJoinEvent event){
			Double bal = Economymanager.getRunningBalance(event.getPlayer().getName());
			if(Economymanager.hasAccount(event.getPlayer().getName()))
			{event.getPlayer().sendMessage(ChatColor.BLUE+"Balance: "+ bal + " Ducat(s)");
			
			}
			else{
			if (!Economymanager.hasAccount(event.getPlayer().getName()))
			{
			event.getPlayer().sendMessage(ChatColor.RED+"Economy: Player does not have an account, creating one now...");
			Economymanager.setBalance(event.getPlayer().getName(), 200D);
			}
		}
}}


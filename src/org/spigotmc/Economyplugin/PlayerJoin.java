package org.spigotmc.Economyplugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    private Ranks ranks;
    private Balances balances;

    public PlayerJoin(Ranks ranks, Balances balances) {
        this.ranks = ranks;
        this.balances = balances;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String player = event.getPlayer().getName();
        if (ranks.hasRank(player) && balances.hasBalance(player)) {
            event.getPlayer().sendMessage(ChatColor.BLUE + "Player: " + player + "; Rank: " + ranks.getRank(player) + "; Balance: " + balances.getBalance(player) + " Ducat(s)");
        }
        else {
            event.getPlayer().sendMessage(ChatColor.RED + "Economy: Player " + player + " does not have an account, creating one now...");
            balances.setBalance(player, 200D);
            ranks.setRank(player, "Freeman");
            event.getPlayer().sendMessage(ChatColor.BLUE + "Rank: " + ranks.getRank(player) + "; Balance: " + balances.getBalance(player) + " Ducat(s)");
        }
    }
}


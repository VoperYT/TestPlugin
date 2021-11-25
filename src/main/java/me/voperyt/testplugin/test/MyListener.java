package me.voperyt.testplugin.test;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class MyListener implements Listener {

    private Player player;
    private ItemStack item;
    private Player killer;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        this.player = event.getPlayer();
        event.setJoinMessage("Welcome, " + player + "!");
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event){
        this.item = event.getItemDrop().getItemStack();
        item.setAmount(2);
        event.getPlayer().getInventory().addItem(item);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        event.setDeathMessage("Se Fudeu!");
        event.setKeepLevel(true);
        if (event.getEntity().getPlayer().getKiller() instanceof Player){
            this.killer = event.getEntity().getPlayer().getKiller();
            killer.giveExpLevels(10);
        }
    }
}

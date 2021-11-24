package me.voperyt.testplugin.test;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class MyListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("Welcome, " + player + "!");
    }

    @EventHandler
    public void onPlayerKill(PlayerDropItemEvent event){
        ItemStack item = event.getItemDrop().getItemStack();
        item.setAmount(2);
        event.getPlayer().getInventory().addItem(item);
    }
}

package me.voperyt.testplugin.test;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class MyListener implements Listener {

    private Player player;
    private ItemStack item;

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
}

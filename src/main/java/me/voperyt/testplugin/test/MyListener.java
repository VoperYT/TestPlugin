package me.voperyt.testplugin.test;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MyListener implements Listener {

    private Player player;
    private ItemStack item;
    private Player killer;
    private final ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET);
    private final ItemStack waterBucket = new ItemStack(Material.WATER_BUCKET);

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

    @EventHandler
    public void onPlayerBucketFill(PlayerBucketFillEvent event) {
        if (event.getItemStack().equals(waterBucket)) {
            event.setItemStack(lavaBucket);
        } else if (event.getItemStack().equals(lavaBucket)) {
            event.setItemStack(waterBucket);
        }
    }

    @EventHandler
    public void onHitByFluSword(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player damager = (Player)e.getDamager();
            if(damager.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(FluPotion.FLU_SWORD.getItemMeta().getPersistentDataContainer())){
                if(e.getEntity() instanceof LivingEntity) {
                    FluPotion.FLU_POTION_EFFECT.apply((LivingEntity)e.getEntity());
                }
            }
        }
    }

    @EventHandler
    public void onHitSupremeAxe(EntityDamageByEntityEvent e){
        if(!(e.getDamager() instanceof Player)){
            return;
        }
        Player attacker = (Player)e.getDamager();
        if(!(attacker.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().equals(SupremeAxe.SUPREME_AXE.getItemMeta().getPersistentDataContainer()))){
            return;
        }
        if(e.getEntity() instanceof LivingEntity){
            ((LivingEntity)e.getEntity()).addPotionEffect(FluPotion.FLU_POTION_EFFECT);
        }
    }
}

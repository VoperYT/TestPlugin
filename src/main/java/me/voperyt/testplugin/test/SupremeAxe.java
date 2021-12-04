package me.voperyt.testplugin.test;

import me.voperyt.testplugin.TestPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class SupremeAxe {

    private static final NamespacedKey supreme_axe_id = new NamespacedKey(TestPlugin.getInstance(),"supreme_axe_id");
    public static ItemStack SUPREME_AXE;

    private static void createSupremeAxe(){
        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§a§lSupreme Axe");

        List<String> lore = new ArrayList<>();
        lore.add(0,"§fThe most powerful axe");
        lore.add(1,"§ffor the strongest warrior!");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 4, true);
        meta.addEnchant(Enchantment.MENDING, 2, true);

        meta.getPersistentDataContainer().set(supreme_axe_id, PersistentDataType.STRING, "supreme_axe_tag");

        item.setItemMeta(meta);

        SUPREME_AXE = item;
    }

    public static void initialize(){
        createSupremeAxe();
    }
}

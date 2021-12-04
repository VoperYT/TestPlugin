package me.voperyt.testplugin.test;

import me.voperyt.testplugin.TestPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class FluPotion {

    public static ItemStack FLU_SWORD;
    public static final PotionEffect FLU_POTION_EFFECT = new PotionEffect(PotionEffectType.WEAKNESS,60*20,10);
    private static final NamespacedKey FLU_SWORD_KEY = new NamespacedKey(TestPlugin.getInstance(),"flu_sword_key");


    // Flu Sword
    private static void createFluSword(){

        // Creation of the flu sword
        ItemStack fluSword = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta fluMeta = fluSword.getItemMeta();

        fluMeta.addEnchant(Enchantment.DAMAGE_ALL,5,true);
        fluMeta.setDisplayName("&2Flu Sword");

        // Creating the Lore
        List<String> fluLore = new ArrayList<>();
        fluLore.add(0,"&aDo you want to avoid getting the flu?");
        fluLore.add(1,"&aDon't get hit by this sword then!");
        fluMeta.setLore(fluLore);

        fluMeta.getPersistentDataContainer().set(FLU_SWORD_KEY, PersistentDataType.STRING, "flu_sword_tag");

        fluSword.setItemMeta(fluMeta);

        FLU_SWORD = fluSword;

    }

    public static void initFlu(){
        createFluSword();
    }
}

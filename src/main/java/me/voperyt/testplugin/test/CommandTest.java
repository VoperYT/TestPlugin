package me.voperyt.testplugin.test;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            // Creating a diamond itemStack
            ItemStack diamond = new ItemStack(Material.DIAMOND);
            diamond.setAmount(640);

            /*// Creating a Netherite Sword itemStack
            ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD);

            // Sharpness 1000 + Fire aspect 50 + Knockback 50
            netheriteSword.addEnchantment(Enchantment.DAMAGE_ALL, 1000);
            netheriteSword.addEnchantment(Enchantment.FIRE_ASPECT,50);
            netheriteSword.addEnchantment(Enchantment.KNOCKBACK,100);*/

            player.getInventory().addItem(FluPotion.FLU_SWORD, SupremeAxe.SUPREME_AXE, diamond);

        }
        return true;
    }
}

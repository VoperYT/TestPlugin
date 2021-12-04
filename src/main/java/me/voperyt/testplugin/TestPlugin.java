package me.voperyt.testplugin;

import me.voperyt.testplugin.test.CommandTest;
import me.voperyt.testplugin.test.FluPotion;
import me.voperyt.testplugin.test.MyListener;
import me.voperyt.testplugin.test.SupremeAxe;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    private static TestPlugin INSTANCE;
    FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        INSTANCE = this;
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage("Test plugin enabled!");

        // Registering the /test command
        this.getCommand("test").setExecutor(new CommandTest());

        // Registering the events
        getServer().getPluginManager().registerEvents(new MyListener(),this);


        FluPotion.initFlu();
        SupremeAxe.initialize();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage("Test plugin disabled!");
    }

    public static TestPlugin getInstance(){
        return INSTANCE;
    }
}

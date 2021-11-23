package me.voperyt.testplugin;

import me.voperyt.testplugin.test.CommandTest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin {

    FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Registering the /test command
        this.getCommand("test").setExecutor(new CommandTest());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

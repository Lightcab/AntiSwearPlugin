package me.lightcab;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiSwearPluginMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("The plugin has been enabled!");
        getServer().getPluginManager().registerEvents(new AntiSwearPluginListener(this), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled!");
    }

}

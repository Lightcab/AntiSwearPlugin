package me.lightcab;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiSwearPluginMain extends JavaPlugin {
    protected static AntiSwearPluginMain instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("The plugin has been enabled!");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new AntiSwearPluginListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled!");
    }

}

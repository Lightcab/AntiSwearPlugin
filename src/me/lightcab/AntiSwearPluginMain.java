package me.lightcab;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiSwearPluginMain extends JavaPlugin {
    protected static AntiSwearPluginMain instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new AntiSwearPluginListener(this), this);
    }
}

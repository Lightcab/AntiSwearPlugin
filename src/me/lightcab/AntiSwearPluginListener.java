package me.lightcab;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiSwearPluginListener implements Listener {

    AntiSwearPluginMain plugin;

    public AntiSwearPluginListener(AntiSwearPluginMain instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage().toLowerCase();
        for (String x : plugin.getConfig().getStringList("bannedWords")) {
            if (message.contains(x.toLowerCase())) {
                if (plugin.getConfig().getBoolean("displayChat")) {
                    e.setMessage(plugin.getConfig().getString("replaceMessage"));
                } else {
                    e.setCancelled(true);
                    p.sendMessage(ChatColor.GREEN + "AntiSwear> " + ChatColor.WHITE + plugin.getConfig().getString("sendMessage"));
                }
            }

        }
    }
}
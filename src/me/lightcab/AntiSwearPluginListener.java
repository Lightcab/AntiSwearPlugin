package me.lightcab;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiSwearPluginListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        AntiSwearPluginMain plugin = AntiSwearPluginMain.instance;
        Player p = e.getPlayer();
        String message = e.getMessage().toLowerCase();
        for (String x : plugin.getConfig().getStringList("bannedWords")) {
            if (message.contains(x.toLowerCase())) {
                e.setMessage(plugin.getConfig().getString("replaceMessage"));
                if (plugin.getConfig().getBoolean("warnPlayer")) {
                    p.sendMessage(ChatColor.GREEN + "AntiSwear> " + ChatColor.WHITE + plugin.getConfig().getString("warnMessage"));
                }
                if (plugin.getConfig().getBoolean("setFire")) p.setFireTicks(plugin.getConfig().getInt("fireSecond") * 20);
                break;
            }

        }
    }
}

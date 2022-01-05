package me.isryman.freeze.listeners;

import me.isryman.freeze.Freeze;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeEvents implements Listener {

    private final Freeze freeze;

    public FreezeEvents(Freeze freeze) {
        this.freeze = freeze;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(freeze.getFrozenPlayers().contains(p.getUniqueId())) {
            e.setCancelled(true);
            p.sendMessage("§cYou are frozen... Please join Screenshare Waiting Room at our Discord.");
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if(freeze.getFrozenPlayers().contains(p.getUniqueId())) {
            e.setCancelled(true);
            p.sendMessage("§cYou are frozen... Please join Screenshare Waiting Room at our Discord.");
        }
    }
}

package me.isryman.freeze.listeners;

import me.isryman.freeze.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeEvents implements Listener {

    private final Main main;

    public FreezeEvents(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(main.getFrozenPlayers().contains(p.getUniqueId())) {
            e.setCancelled(true);
            p.sendMessage("§cYou are frozen... Please join Screenshare Waiting Room at our Discord.");
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if(main.getFrozenPlayers().contains(p.getUniqueId())) {
            e.setCancelled(true);
            p.sendMessage("§cYou are frozen... Please join Screenshare Waiting Room at our Discord.");
        }
    }
}

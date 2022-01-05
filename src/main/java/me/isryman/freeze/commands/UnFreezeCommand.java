package me.isryman.freeze.commands;

import me.isryman.freeze.Freeze;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnFreezeCommand implements CommandExecutor {

    private final Freeze freeze;

    public UnFreezeCommand(Freeze freeze) {
        this.freeze = freeze;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Player p = (Player) sender;
            if(p.hasPermission("freeze")) {
                if (args.length == 1) {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    if (t != null && !freeze.getFrozenPlayers().contains(t.getUniqueId())) {
                        freeze.getFrozenPlayers().remove(t.getUniqueId());
                        t.sendMessage("§aYou have been unfrozen... Thanks for your time.");
                    } else {
                        p.sendMessage("Player not found.");
                    }
                } else {
                    p.sendMessage("specify a player please.");
                }
            } else {
                p.sendMessage("§cYou don't have permission to execute that command.");
            }
        }
        return false;
    }
}

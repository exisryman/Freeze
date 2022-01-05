package me.isryman.freeze.commands;

import me.isryman.freeze.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {

    private final Main main;

    public FreezeCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player) || !sender.hasPermission("command.freeze")) { return false; }
        Player p = (Player) sender;
        if (args.length == 1) {
            Player t = Bukkit.getPlayerExact(args[0]);
            if (t != null && !main.getFrozenPlayers().contains(t)) {
                main.getFrozenPlayers().add(t);
                t.sendMessage("§cYou have been frozen by a staff member! §bPlease join Screenshare Waiting Room at our Discord");
            } else {
                p.sendMessage("Player not found.");
            }
        } else {
            p.sendMessage("specify a player please.");
        }
        return false;
    }
}

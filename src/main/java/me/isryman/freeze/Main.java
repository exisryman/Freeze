package me.isryman.freeze;

import me.isryman.freeze.commands.FreezeCommand;
import me.isryman.freeze.commands.UnFreezeCommand;
import me.isryman.freeze.listeners.FreezeEvents;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    private ArrayList<Player> frozenPlayers;

    @Override
    public void onEnable() {
        registerListeners();
        registerCommands();
        frozenPlayers = new ArrayList<>();
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new FreezeEvents(this), this);
    }

    private void registerCommands() {
        getCommand("freeze").setExecutor(new FreezeCommand(this));
        getCommand("unfreeze").setExecutor(new UnFreezeCommand(this));
    }

    public ArrayList<Player> getFrozenPlayers() {
        return frozenPlayers;
    }
}

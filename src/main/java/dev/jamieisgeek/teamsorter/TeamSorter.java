package dev.jamieisgeek.teamsorter;

import dev.jamieisgeek.CommandRegisterer;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

public final class TeamSorter extends JavaPlugin {
    private static Configuration config = null;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        try {
            new CommandRegisterer(this, getClass().getPackage().getName(), "Commands").registerCommands();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        getLogger().info("TeamSorter has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TeamSorter has been disabled!");
    }

    public static Configuration returnConfig() {
        return config;
    }
}

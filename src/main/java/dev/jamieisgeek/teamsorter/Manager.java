package dev.jamieisgeek.teamsorter;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private static Manager instance;
    private ArrayList<Team> teams = new ArrayList<>();
    private HashMap<Player, Team> playerTeams = new HashMap<>();
    public Manager() {
        instance = this;

    }

    public static Manager getInstance() {
        return instance;
    }

    public void teleportTeams() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (playerTeams.containsKey(player)) {
                player.teleport(playerTeams.get(player).teamSpawnLocation());
            } else {
                Bukkit.getLogger().severe("Player " + player.getName() + " does not have a team!");
            }
        }
    }

    public void sort() {
        Configuration config = TeamSorter.returnConfig();

        config.getConfigurationSection("teams").getKeys(false).forEach(teamKey -> {
            config.getConfigurationSection("teams." + teamKey).getKeys(false).forEach(team -> {

                String teamName = config.getString("teams." + teamKey + "." + ".name");
                int teamSpawnX = config.getInt("teams." + teamKey + ".spawnLocation.x");
                int teamSpawnY = config.getInt("teams." + teamKey + ".spawnLocation.y");
                int teamSpawnZ = config.getInt("teams." + teamKey + ".spawnLocation.z");
                String teamSpawnWorld = config.getString("teams." + teamKey + "." + ".spawnLocation.world");
                Location teamSpawnLocation = new Location(
                        Bukkit.getWorld(teamSpawnWorld),
                        teamSpawnX,
                        teamSpawnY,
                        teamSpawnZ
                );

                teams.add(new Team(teamName, teamSpawnX, teamSpawnY, teamSpawnZ, teamSpawnWorld, teamSpawnLocation));
            });
        });

        // Sort all online players evenly into the different teams based on the size of the teams array
        Bukkit.getOnlinePlayers().stream().filter(player -> !player.hasPermission("teamsorters.noteam")).forEach(player -> {
            int teamIndex = (int) Math.floor(Bukkit.getOnlinePlayers().size() / teams.size());
            playerTeams.put(player, teams.get(teamIndex));
        });
    }
}

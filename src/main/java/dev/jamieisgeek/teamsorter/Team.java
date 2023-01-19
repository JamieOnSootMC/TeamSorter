package dev.jamieisgeek.teamsorter;

import org.bukkit.Location;

public record Team(String teamName, int teamSpawnX, int teamSpawnY, int teamSpawnZ, String teamSpawnWorld, Location teamSpawnLocation) {
}

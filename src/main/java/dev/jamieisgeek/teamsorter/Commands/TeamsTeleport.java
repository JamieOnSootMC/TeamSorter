package dev.jamieisgeek.teamsorter.Commands;

import dev.jamieisgeek.CommandHandler;
import dev.jamieisgeek.CommandInfo;
import dev.jamieisgeek.teamsorter.Manager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "teamsteleport", permission = "teamsorter.teamsteleport", requiresPlayer = false)
public class TeamsTeleport extends CommandHandler {
    public void execute(CommandSender sender, String[] args) {
        new Manager().teleportTeams();
        sender.sendMessage(ChatColor.BLUE + "TeamSorter " + ChatColor.WHITE + "| Teams have all been teleported to their respective areas");
    }
}

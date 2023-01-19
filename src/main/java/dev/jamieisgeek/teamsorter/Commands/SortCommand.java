package dev.jamieisgeek.teamsorter.Commands;

import dev.jamieisgeek.CommandHandler;
import dev.jamieisgeek.CommandInfo;
import dev.jamieisgeek.teamsorter.Manager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "sort", permission = "teamsorter.sort", requiresPlayer = false)
public class SortCommand extends CommandHandler {
    public void execute(CommandSender sender, String[] args) {
        new Manager().sort();
        sender.sendMessage(ChatColor.BLUE + "TeamSorter " + ChatColor.WHITE + "| Teams have been sorted. Use /teamsteleport to teleport players to their designated areas");
    }
}

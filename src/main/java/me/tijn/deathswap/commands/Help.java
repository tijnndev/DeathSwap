package me.tijn.deathswap.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§c----------- §f§lDeathSwap Help §c-----------\n§c§l/dstart: §f§lStart the DeathSwap\n§c§l/dhelp: §f§lGet this help menu");
        return false;
    }
}

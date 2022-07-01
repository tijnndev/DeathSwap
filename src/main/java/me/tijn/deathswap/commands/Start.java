package me.tijn.deathswap.commands;

import me.tijn.deathswap.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start implements CommandExecutor {

    private Main m = Main.getInstance();
    public static Player player1;

    public static Player player2;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if((sender instanceof Player)) {
            if(Bukkit.getOnlinePlayers().size() < 2 || Bukkit.getOnlinePlayers().size() > 2) {
                Bukkit.broadcastMessage("§l§cThis plugin requires 2 players.");
                return false;
            }
            player1 = (Player) Bukkit.getOnlinePlayers().toArray()[0];
            player2 = (Player) Bukkit.getOnlinePlayers().toArray()[1];
            startTimer();
            Bukkit.broadcastMessage("§aDeath Swap has started!");
        } else {
            sender.sendMessage("This is an player only command");
        }

        return false;
    }
    private void startTimer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("§aSwapping in 10 seconds!");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.broadcastMessage("§aSwapping in 9 seconds!");
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Bukkit.broadcastMessage("§aSwapping in 8 seconds!");
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        Bukkit.broadcastMessage("§aSwapping in 7 seconds!");
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                Bukkit.broadcastMessage("§aSwapping in 6 seconds!");
                                                new BukkitRunnable() {
                                                    @Override
                                                    public void run() {
                                                        for(Player contestant : Bukkit.getOnlinePlayers()) {
                                                            contestant.sendTitle("§l§a5 §fSeconds remaining", "");

                                                        }
                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                for(Player contestant : Bukkit.getOnlinePlayers()) {
                                                                    contestant.sendTitle("§l§a4 §fSeconds remaining", "");
                                                                }
                                                                new BukkitRunnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        for(Player contestant : Bukkit.getOnlinePlayers()) {
                                                                            contestant.sendTitle("§l§a3 §fSeconds remaining", "");
                                                                        }
                                                                        new BukkitRunnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                for(Player contestant : Bukkit.getOnlinePlayers()) {
                                                                                    contestant.sendTitle("§l§a2 §fSeconds remaining", "");
                                                                                }
                                                                                new BukkitRunnable() {
                                                                                    @Override
                                                                                    public void run() {
                                                                                        for(Player contestant : Bukkit.getOnlinePlayers()) {
                                                                                            contestant.sendTitle("§l§a1 §fSeconds remaining", "");
                                                                                        }
                                                                                        new BukkitRunnable() {
                                                                                            @Override
                                                                                            public void run() {
                                                                                                        try {
                                                                                                            player1 = (Player) Bukkit.getOnlinePlayers().toArray()[0];
                                                                                                            player2 = (Player) Bukkit.getOnlinePlayers().toArray()[1];
                                                                                                            Location player1loc = player1.getLocation();
                                                                                                            Location player2loc = player2.getLocation();
                                                                                                            player1.teleport(player2loc);
                                                                                                            player2.teleport(player1loc);
                                                                                                        } catch (Exception e) {
                                                                                                            for (Player todos : Bukkit.getOnlinePlayers()) {
                                                                                                                todos.sendMessage("§c§lError occured while teleporting players, please check your server console");

                                                                                                            }
                                                                                                            m.c.sendMessage(String.valueOf(e));
                                                                                                        }
                                                                                                for(Player contestant : Bukkit.getOnlinePlayers()) {
                                                                                                    contestant.sendTitle("§l§aSwapped!", "");
                                                                                                }

                                                                                            }
                                                                                        }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                                                                                    }
                                                                                }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                                                                            }

                                                                        }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                                                                    }
                                                                }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                                                            }
                                                        }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                                                    }
                                                }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                                            }
                                        }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                                    }
                                }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                            }
                        }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
                    }
                }.runTaskLater(JavaPlugin.getPlugin(Main.class), 20);
            }
        }.runTaskLater(JavaPlugin.getPlugin(Main.class), 200);

    }
}

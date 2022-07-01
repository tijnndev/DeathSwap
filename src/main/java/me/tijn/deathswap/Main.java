package me.tijn.deathswap;

import me.tijn.deathswap.commands.Help;
import me.tijn.deathswap.commands.Start;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public ConsoleCommandSender c = Bukkit.getServer().getConsoleSender();
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }
    private void setInstance(Main instance) {
        Main.instance = instance;
    }
    @Override
    public void onEnable() {
        setInstance(this);
        c.sendMessage("§cDeathSwap §fhas been enabled");
        this.getConfig().addDefault("time-between", 300);
        this.getConfig().addDefault("prefix", "§b§lTijn.§f§lDev =>");
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        loadCommands();
    }
    public void loadCommands() {
        getCommand("dstart").setExecutor(new Start());
        getCommand("dhelp").setExecutor(new Help());
    }
    @Override
    public void onDisable() {
        c.sendMessage("§cDeathSwap §fhas been disabled");
    }
}

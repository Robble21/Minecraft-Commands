package de.robble.sudoplugin;

import de.robble.sudoplugin.commands.sudoCMD;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void Register() {
        Bukkit.getPluginCommand("sudo").setExecutor(new sudoCMD());
    }
}

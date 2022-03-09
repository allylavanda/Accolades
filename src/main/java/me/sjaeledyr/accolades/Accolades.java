package me.sjaeledyr.accolades;

import org.bukkit.plugin.java.JavaPlugin;

public final class Accolades extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[Accolades] Accolades by Sjaeledyr has been loaded!");
        System.out.print("[Accolades] Plugin Version 1.0-SNAPSHOT");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[Accolades] Accolades has been disabled!");
    }
}

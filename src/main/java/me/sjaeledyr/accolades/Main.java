package me.sjaeledyr.accolades;

import me.sjaeledyr.accolades.util.PlayerDataManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public PlayerDataManager data;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.data = new PlayerDataManager(this);
        this.saveDefaultConfig();
        System.out.println("[Accolades] Accolades by Sjaeledyr has been loaded!");
        System.out.print("[Accolades] Plugin Version 1.0-SNAPSHOT");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[Accolades] Accolades has been disabled!");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (label.equalsIgnoreCase("accolades")) {
            if (!sender.hasPermission("accolades.reload")){
                sender.sendMessage(ChatColor.RED + "You do not have permissions to run this command!");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Usage: /accolades reload");
                return true;
            }
            if (args.length > 0) {
                // /accolades reload
                if (args[0].equalsIgnoreCase("reload")) {
                    for(String msg : this.getConfig().getStringList("reload.message")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                    this.reloadConfig();
                }
            }
        }
        return false;
    }
}

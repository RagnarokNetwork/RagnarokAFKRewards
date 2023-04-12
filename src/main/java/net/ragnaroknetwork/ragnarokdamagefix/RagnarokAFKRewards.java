package net.ragnaroknetwork.ragnarokdamagefix;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RagnarokAFKRewards extends JavaPlugin implements Listener {


    public void onEnable() {
        this.getCommand("ragnarokafkrewards").setExecutor(new Command());
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {

    }

}


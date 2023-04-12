package net.ragnaroknetwork.ragnarokdamagefix;

import com.earth2me.essentials.Essentials;
import net.ess3.api.IEssentials;
import net.ess3.api.IUser;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Collections;

public class Command implements CommandExecutor {
    Plugin plugin = RagnarokAFKRewards.getPlugin(RagnarokAFKRewards.class);
    Essentials essentials = (Essentials) plugin.getServer().getPluginManager().getPlugin("Essentials");

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (!player.hasPermission("ragnarokafkrewards.admin")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l► &cYou do not have permission to execute this command!"));
                return true;
            }
        }

        if (args[0].equals("bronze")) {
            Player player = plugin.getServer().getPlayer(args[1]);
            IUser user = essentials.getUser(player);

            int amount = Integer.valueOf(args[2]);
            ItemStack item = new ItemStack(Material.CLAY_BRICK, amount);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6Bronze"));
            meta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', "&7Sell at spawn for money.")));

            item.setItemMeta(meta);

            if (user.isAfk()) player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4&lOUTPOST&8] &7You have been detected as AFK. You weren't given any rewards from outposts."));
            else {
                giveReward(item, player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Received &cbronze&7."));
            }

            return true;
        }

        if (args[0].equals("silver")) {
            Player player = plugin.getServer().getPlayer(args[1]);
            IUser user = essentials.getUser(player);

            int amount = Integer.valueOf(args[2]);
            ItemStack item = new ItemStack(Material.IRON_INGOT, amount);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSilver"));
            meta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', "&7Sell at spawn for money.")));

            item.setItemMeta(meta);

            if (user.isAfk()) player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4&lOUTPOST&8] &7You have been detected as AFK. You weren't given any rewards from outposts."));
            else {
                giveReward(item, player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Received &csilver&7."));
            }

            return true;
        }

        if (args[0].equals("gold")) {
            Player player = plugin.getServer().getPlayer(args[1]);
            IUser user = essentials.getUser(player);

            int amount = Integer.valueOf(args[2]);
            ItemStack item = new ItemStack(Material.GOLD_INGOT, amount);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&eGold"));
            meta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', "&7Sell at spawn for money.")));

            item.setItemMeta(meta);

            if (user.isAfk()) player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4&lOUTPOST&8] &7You have been detected as AFK. You weren't given any rewards from outposts."));
            else {
                giveReward(item, player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l► &7Received &cgold&7."));
            }

            return true;
        }
        return true;
    }

    public void giveReward(ItemStack reward, Player player) {
        if (player.getInventory().firstEmpty() == -1) player.getLocation().getWorld().dropItemNaturally(player.getLocation(), reward);
        else player.getInventory().addItem(reward);
    }
}

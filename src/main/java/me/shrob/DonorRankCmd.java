package me.shrob;

import me.shrob.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DonorRankCmd implements Listener, CommandExecutor {

    ItemStack donorank1 = ItemManager.donorank1;
    ItemStack donorank2 = ItemManager.donorank2;
    ItemStack donorank3 = ItemManager.donorank3;
    ItemStack donorank4 = ItemManager.donorank4;
    ItemStack donorank5 = ItemManager.donorank5;
    ItemStack donorank6 = ItemManager.donorank6;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("givevoucher")) {
            switch (args[0]) {
                case "squire":
                    player.getInventory().addItem(donorank1);
                    break;
                case "baron":
                    player.getInventory().addItem(donorank2);
                    break;
                case "earl":
                    player.getInventory().addItem(donorank3);
                    break;
                case "duke":
                    player.getInventory().addItem(donorank4);
                    break;
                case "grandduke":
                    player.getInventory().addItem(donorank5);
                    break;
                case "monarch":
                    player.getInventory().addItem(donorank6);
                    break;
            }

        }
        return false;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().isRightClick()) {

            if(player.getItemInHand() == null) {
                return;
            }
            if(!(player.getItemInHand().hasItemMeta())) return;

            if(!(player.getItemInHand().getItemMeta().hasDisplayName())) return;

            if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("{#c23ea3}&l[Squire] Rank Voucher"))) {
                event.setCancelled(true);
                player.getInventory().removeItem(donorank1);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add donorank1");
            } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("{#bc92e0}&l[Baron] Rank Voucher"))) {
                event.setCancelled(true);
                player.getInventory().removeItem(donorank2);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add donorank2");
            } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("{#a574c7}&l[Earl] Rank Voucher"))) {
                event.setCancelled(true);
                player.getInventory().removeItem(donorank3);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add donorank3");
            } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("{#389268}&l[Duke] Rank Voucher"))) {
                event.setCancelled(true);
                player.getInventory().removeItem(donorank4);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add donorank4");
            } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("{#17b86a}&l[Grand Duke] Rank Voucher"))) {
                event.setCancelled(true);
                player.getInventory().removeItem(donorank5);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add donorank5");
            } else if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("{#00ffc9}&l[Monarch] Rank Voucher"))) {
                event.setCancelled(true);
                player.getInventory().removeItem(donorank6);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add donorank6");
            }
        }
    }
}

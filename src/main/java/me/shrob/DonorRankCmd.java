package me.shrob;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class DonorRankCmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("givevoucher")) {
            if (args.length < 1) {
                player.sendMessage(Utils.color("&cIncorrect syntax. /givevoucher groupname"));
                return false;
            }
            if (!JoeyVouchers.vouchers.containsKey(args[0].toLowerCase())) {
                player.sendMessage(Utils.color("&cInvalid voucher."));
                return false;
            }
            Voucher voucher = JoeyVouchers.vouchers.get(args[0]);
            HashMap<Integer, ItemStack> leftover = player.getInventory().addItem(voucher.getItemStack());
            if (!leftover.isEmpty()) {
                for (ItemStack itemStack : leftover.values()) {
                    player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
                }
            }

        }
        return false;
    }
}

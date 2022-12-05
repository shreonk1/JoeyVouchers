package me.shrob;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Map;

public class VoucherListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().isRightClick()) {
            if (player.getItemInHand() == null || !(player.getItemInHand().hasItemMeta()) || !(player.getItemInHand().getItemMeta().hasDisplayName()))
                return;
            ItemStack hand = player.getItemInHand();
            if (getVoucher(hand) == null) {
                return;
            }
            Voucher voucher = getVoucher(hand);
            player.getInventory().remove(voucher.getItemStack());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add " + voucher.getGroupName());
        }
    }

    public Voucher getVoucher(ItemStack itemStack) {
        PersistentDataContainer pdc = itemStack.getItemMeta().getPersistentDataContainer();
        if (pdc.has(JoeyVouchers.instance.key, PersistentDataType.STRING)) {
            for (Map.Entry<String, Voucher> entry : JoeyVouchers.vouchers.entrySet()) {
                if (pdc.get(JoeyVouchers.instance.key, PersistentDataType.STRING).equalsIgnoreCase(entry.getValue().getName())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }
}

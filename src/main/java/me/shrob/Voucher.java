package me.shrob;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class Voucher {

    String name;
    String displayName;
    ItemStack itemStack;
    String groupName;

    public Voucher(String name, String groupName, String displayName) {
        this.name = name;
        this.groupName = groupName;
        this.displayName = displayName;
        ItemStack itemStack = new ItemStack(Material.BOOK, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(Utils.color(displayName));
        itemMeta.addEnchant(Enchantment.LUCK, 1, true);
        itemMeta.getPersistentDataContainer().set(JoeyVouchers.instance.key, PersistentDataType.STRING, name);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(itemMeta);
        this.itemStack = itemStack;
        JoeyVouchers.vouchers.put(name, this);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getName() {
        return name;
    }
}

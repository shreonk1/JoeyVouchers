package me.shrob.items;

import me.shrob.Utils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {

    public static ItemStack donorank1;
    public static ItemStack donorank2;
    public static ItemStack donorank3;
    public static ItemStack donorank4;
    public static ItemStack donorank5;
    public static ItemStack donorank6;

    public static void init() {
        donorank1 = new ItemStack(Material.BOOK);
        donorank2 = new ItemStack(Material.BOOK);
        donorank3 = new ItemStack(Material.BOOK);
        donorank4 = new ItemStack(Material.BOOK);
        donorank5 = new ItemStack(Material.BOOK);
        donorank6 = new ItemStack(Material.BOOK);

        ItemMeta meta1 = donorank1.getItemMeta();
        ItemMeta meta2 = donorank2.getItemMeta();
        ItemMeta meta3 = donorank3.getItemMeta();
        ItemMeta meta4 = donorank4.getItemMeta();
        ItemMeta meta5 = donorank5.getItemMeta();
        ItemMeta meta6 = donorank6.getItemMeta();

        meta1.setDisplayName(Utils.color("{#c23ea3}&l[Squire] Rank Voucher"));
        meta2.setDisplayName(Utils.color("{#bc92e0}&l[Baron] Rank Voucher"));
        meta3.setDisplayName(Utils.color("{#a574c7}&l[Earl] Rank Voucher"));
        meta4.setDisplayName(Utils.color("{#389268}&l[Duke] Rank Voucher"));
        meta5.setDisplayName(Utils.color("{#17b86a}&l[Grand Duke] Rank Voucher"));
        meta6.setDisplayName(Utils.color("{#00ffc9}&l[Monarch] Rank Voucher"));

        meta1.addEnchant(Enchantment.LUCK, 1, true);
        meta2.addEnchant(Enchantment.LUCK, 1, true);
        meta3.addEnchant(Enchantment.LUCK, 1, true);
        meta4.addEnchant(Enchantment.LUCK, 1, true);
        meta5.addEnchant(Enchantment.LUCK, 1, true);
        meta6.addEnchant(Enchantment.LUCK, 1, true);

        meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta6.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        donorank1.setItemMeta(meta1);
        donorank2.setItemMeta(meta2);
        donorank3.setItemMeta(meta3);
        donorank4.setItemMeta(meta4);
        donorank5.setItemMeta(meta5);
        donorank6.setItemMeta(meta6);
    }
}

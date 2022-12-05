package me.shrob;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class JoeyVouchers extends JavaPlugin {

    public static JoeyVouchers instance;
    public final NamespacedKey key = new NamespacedKey(this, "voucher");
    public static Map<String, Voucher> vouchers = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info("Joey Vouchers successfully enabled");
        getCommand("givevoucher").setExecutor(new DonorRankCmd());
        getCommand("givevoucher").setTabCompleter(new TabCompleter());
        Bukkit.getPluginManager().registerEvents(new VoucherListener(), this);
        Voucher squire = new Voucher("squire", "donorrank1", "{#c23ea3}&l[Squire] Rank Voucher");
        Voucher baron = new Voucher("baron", "donorrank2", "{#bc92e0}&l[Baron] Rank Voucher");
        Voucher earl = new Voucher("earl", "donorrank3", "{#a574c7}&l[Earl] Rank Voucher");
        Voucher duke = new Voucher("duke", "donorrank4", "{#389268}&l[Duke] Rank Voucher");
        Voucher grandduke = new Voucher("grandduke", "donorrank5", "{#17b86a}&l[Grand Duke] Rank Voucher");
        Voucher monarch = new Voucher("monarch", "donorrank6", "{#00ffc9}&l[Monarch] Rank Voucher");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

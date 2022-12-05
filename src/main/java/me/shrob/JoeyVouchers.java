package me.shrob;

import me.shrob.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoeyVouchers extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemManager.init();
        Bukkit.getLogger().info("Joey Vouchers successfully enabled");

        getCommand("givevoucher").setExecutor(new DonorRankCmd());
        Bukkit.getPluginManager().registerEvents(new DonorRankCmd(), this);
        getCommand("givevoucher").setTabCompleter(new TabCompleter());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

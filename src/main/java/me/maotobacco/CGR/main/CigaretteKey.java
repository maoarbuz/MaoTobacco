package me.maotobacco.CGR.main;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class CigaretteKey {

    public static NamespacedKey USAGE_KEY;

    static {
        USAGE_KEY = new NamespacedKey(JavaPlugin.getProvidingPlugin(CigaretteKey.class), "usage_count");
    }
}

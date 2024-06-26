package me.maotobacco;

import me.maotobacco.CGR.*;
import me.maotobacco.CGR.main.CigaretteKey;
import me.maotobacco.CGR.main.CigaretteRegistry;
import me.maotobacco.CMD.MTCCommand;
import me.maotobacco.EVENT.CigaretteInteractHandler;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class MaoTobacco extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getLogger().info("\n" +
                "▒█▀▄▀█ █▀▀█ █▀▀█ ▀▀█▀▀ █▀▀█ █▀▀▄ █▀▀█ █▀▀ █▀▀ █▀▀█ \n" +
                "▒█▒█▒█ █▄▄█ █░░█ ░▒█░░ █░░█ █▀▀▄ █▄▄█ █░░ █░░ █░░█ \n" +
                "▒█░░▒█ ▀░░▀ ▀▀▀▀ ░▒█░░ ▀▀▀▀ ▀▀▀░ ▀░░▀ ▀▀▀ ▀▀▀ ▀▀▀▀");
        this.getCommand("mtc").setExecutor(new MTCCommand());
        getServer().getPluginManager().registerEvents(new CigaretteInteractHandler(), this);
        CigaretteKey.USAGE_KEY = new NamespacedKey(this, "usage_count");
        CigaretteRegistry.registerCigarette(new ClassicCigarette());
        CigaretteRegistry.registerCigarette(new MentholCigarette());
        CigaretteRegistry.registerCigarette(new HerbalCigarette());
        CigaretteRegistry.registerCigarette(new StrongCigarette());
        CigaretteRegistry.registerCigarette(new MagicCigarette());
        CigaretteRegistry.registerCigarette(new UnpredictableCigarette());
        CigaretteRegistry.registerCigarette(new DangerCigarette());
        CigaretteRegistry.registerCigarette(new DecorativeCigarette());
    }

    @Override
    public void onDisable() {

    }
}

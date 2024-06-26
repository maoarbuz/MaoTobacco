package me.maotobacco.CGR;

import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DangerCigarette extends Cigarette {
    public DangerCigarette() {
        super("§cDanger Cigarette", 1000007);
    }

    @Override
    public void onInteract(Player player) {
        player.sendMessage("You've been smoking §cDanger Cigarette");
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 4));
        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0));
        spawnSmokeEffect(player);
        removeCigarette(player);
    }
}
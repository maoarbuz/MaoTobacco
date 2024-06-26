package me.maotobacco.CGR;

import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StrongCigarette extends Cigarette {
    public StrongCigarette() {
        super("§2Strong Cigarette", 1000004);
    }

    @Override
    public void onInteract(Player player) {
        player.sendMessage("You've been smoking §2Strong Cigarette");
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 80, 4));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
        spawnSmokeEffect(player);
        removeCigarette(player);
    }
}
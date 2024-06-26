package me.maotobacco.CGR;

import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ClassicCigarette extends Cigarette {
    public ClassicCigarette() {
        super("§7Classic Cigarette", 1000001);
    }

    @Override
    public void onInteract(Player player) {
        player.sendMessage("You've been smoking §7Classic Cigarette");
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 80, 4));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0));
        spawnSmokeEffect(player);
        removeCigarette(player);
    }
}

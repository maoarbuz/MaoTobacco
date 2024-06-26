package me.maotobacco.CGR;

import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MentholCigarette extends Cigarette {
    public MentholCigarette() {
        super("§bMenthol Cigarette", 1000002);
    }

    @Override
    public void onInteract(Player player) {
        player.sendMessage("You've been smoking §bMenthol Cigarette");
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 80, 4));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
        spawnSmokeEffect(player);
        removeCigarette(player);
    }
}
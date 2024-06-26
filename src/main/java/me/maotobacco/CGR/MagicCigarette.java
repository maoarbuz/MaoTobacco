package me.maotobacco.CGR;

import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MagicCigarette extends Cigarette {
    public MagicCigarette() {
        super("§5Magic Cigarette", 1000005);
    }

    @Override
    public void onInteract(Player player) {
        player.sendMessage("You've been smoking §5Magic Cigarette");
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 80, 4));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 80, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 0));
        spawnSmokeEffect(player);
        removeCigarette(player);
    }
}
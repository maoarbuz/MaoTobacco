package me.maotobacco.CGR;

import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DecorativeCigarette extends Cigarette {
    public DecorativeCigarette() {
        super("§dDecorative Cigarette", 1000008);
    }

    @Override
    public void onInteract(Player player) {
        player.sendMessage("You've been smoking §dDecorative Cigarette");
        spawnSmokeEffect(player);
        removeCigarette(player);
    }
}
package me.maotobacco.CGR;

import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HerbalCigarette extends Cigarette {
    public HerbalCigarette() {
        super("§aHerbal Cigarette", 1000003);
    }

    @Override
    public void onInteract(Player player) {
        player.sendMessage("You've been smoking §aHerbal Cigarette");
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 80, 4));
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 0));
        spawnSmokeEffect(player);
        removeCigarette(player);
    }
}
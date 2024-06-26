package me.maotobacco.CGR;

import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class UnpredictableCigarette extends Cigarette {
    private static final PotionEffectType[] EFFECTS = {
            PotionEffectType.SPEED,
            PotionEffectType.SLOW,
            PotionEffectType.FAST_DIGGING,
            PotionEffectType.SLOW_DIGGING,
            PotionEffectType.INCREASE_DAMAGE,
            PotionEffectType.HEAL,
            PotionEffectType.HARM,
            PotionEffectType.JUMP,
            PotionEffectType.CONFUSION,
            PotionEffectType.REGENERATION,
            PotionEffectType.DAMAGE_RESISTANCE,
            PotionEffectType.FIRE_RESISTANCE,
            PotionEffectType.WATER_BREATHING,
            PotionEffectType.INVISIBILITY,
            PotionEffectType.BLINDNESS,
            PotionEffectType.NIGHT_VISION,
            PotionEffectType.HUNGER,
            PotionEffectType.WEAKNESS,
            PotionEffectType.POISON,
            PotionEffectType.WITHER,
            PotionEffectType.HEALTH_BOOST,
            PotionEffectType.ABSORPTION,
            PotionEffectType.SATURATION,
            PotionEffectType.GLOWING,
            PotionEffectType.LEVITATION,
            PotionEffectType.LUCK,
            PotionEffectType.UNLUCK,
            PotionEffectType.SLOW_FALLING,
            PotionEffectType.CONDUIT_POWER,
            PotionEffectType.DOLPHINS_GRACE,
            PotionEffectType.BAD_OMEN,
            PotionEffectType.HERO_OF_THE_VILLAGE
    };

    public UnpredictableCigarette() {
        super("§eUnpredictable Cigarette", 1000006);
    }

    @Override
    public void onInteract(Player player) {
        player.sendMessage("You've been smoking §eUnpredictable Cigarette");
        Random random = new Random();
        PotionEffectType randomEffect = EFFECTS[random.nextInt(EFFECTS.length)];
        int duration = 200;
        int amplifier = 1;
        player.addPotionEffect(new PotionEffect(randomEffect, duration, amplifier));
        spawnSmokeEffect(player);
        removeCigarette(player);
    }
}

package me.maotobacco.CGR.main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public abstract class Cigarette {
    private final String name;
    private final int customModelData;

    public Cigarette(String name, int customModelData) {
        this.name = name;
        this.customModelData = customModelData;
    }

    public ItemStack toItemStack() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setCustomModelData(customModelData);
            meta.setDisplayName(name);
            meta.getPersistentDataContainer().set(CigaretteKey.USAGE_KEY, PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
        }

        return item;
    }

    public String getName() {
        return name;
    }

    public int getCustomModelData() {
        return customModelData;
    }

    public abstract void onInteract(Player player);

    public void spawnSmokeEffect(Player player) {
        Location loc = player.getLocation().add(0, 2, 0);
        player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc, 10, 0.2, 0.2, 0.2, 0.01);
    }

    protected void removeCigarette(Player player) {
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            Integer usageCount = meta.getPersistentDataContainer().get(CigaretteKey.USAGE_KEY, PersistentDataType.INTEGER);
            if (usageCount == null) {
                usageCount = 0;
            }
            usageCount++;
            if (usageCount >= 3) {
                player.getInventory().remove(item);
                player.sendMessage("The cigarette has been used up and disappeared.");
            } else {
                meta.getPersistentDataContainer().set(CigaretteKey.USAGE_KEY, PersistentDataType.INTEGER, usageCount);
                item.setItemMeta(meta);
            }
        }
    }
}

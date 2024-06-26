package me.maotobacco.EVENT;

import me.maotobacco.CGR.main.Cigarette;
import me.maotobacco.CGR.main.CigaretteRegistry;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CigaretteInteractHandler implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasCustomModelData()) {
                Cigarette cigarette = CigaretteRegistry.getCigaretteByCustomModelData(meta.getCustomModelData());
                if (cigarette != null) {
                    cigarette.onInteract(player);
                    event.setCancelled(true);
                }
            }
        }
    }
}

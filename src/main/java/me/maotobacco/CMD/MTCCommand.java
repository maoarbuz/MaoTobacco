package me.maotobacco.CMD;

import me.maotobacco.CGR.*;
import me.maotobacco.CGR.main.Cigarette;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MTCCommand implements CommandExecutor, TabCompleter {

    private static final Map<String, Cigarette> CIGARETTE_MAP = new HashMap<>();

    static {
        CIGARETTE_MAP.put("classic", new ClassicCigarette());
        CIGARETTE_MAP.put("menthol", new MentholCigarette());
        CIGARETTE_MAP.put("herbal", new HerbalCigarette());
        CIGARETTE_MAP.put("strong", new StrongCigarette());
        CIGARETTE_MAP.put("magic", new MagicCigarette());
        CIGARETTE_MAP.put("unpredictable", new UnpredictableCigarette());
        CIGARETTE_MAP.put("danger", new DangerCigarette());
        CIGARETTE_MAP.put("decorative", new DecorativeCigarette());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 3 || !"give".equalsIgnoreCase(args[0])) {
            sender.sendMessage("Usage: /mtc give <игрок> <сигарета>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        Cigarette cigarette = CIGARETTE_MAP.get(args[2].toLowerCase());
        if (cigarette == null) {
            sender.sendMessage("Cigarette not found. Cigarettes: " + String.join(", ", CIGARETTE_MAP.keySet()));
            return true;
        }

        ItemStack itemStack = cigarette.toItemStack();
        target.getInventory().addItem(itemStack);
        sender.sendMessage("You've given away " + target.getName() + " " + cigarette.getName() + ".");
        target.sendMessage("You've got " + cigarette.getName() + "!");

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Collections.singletonList("give");
        } else if (args.length == 3) {
            return Arrays.asList(CIGARETTE_MAP.keySet().toArray(new String[0]));
        }

        return Collections.emptyList();
    }
}

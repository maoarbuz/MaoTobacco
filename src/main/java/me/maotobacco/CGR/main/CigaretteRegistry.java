package me.maotobacco.CGR.main;

import java.util.HashMap;
import java.util.Map;

public class CigaretteRegistry {

    private static final Map<Integer, Cigarette> CIGARETTE_MAP = new HashMap<>();

    public static void registerCigarette(Cigarette cigarette) {
        CIGARETTE_MAP.put(cigarette.getCustomModelData(), cigarette);
    }

    public static Cigarette getCigaretteByCustomModelData(int customModelData) {
        return CIGARETTE_MAP.get(customModelData);
    }
}

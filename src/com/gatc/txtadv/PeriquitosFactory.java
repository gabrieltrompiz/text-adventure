package com.gatc.txtadv;

public class PeriquitosFactory {
    public static Periquitos getPeriquito(String type){
        if (type.equalsIgnoreCase("armor")) { return Pools.getRandomArmor(); }
        else if (type.equalsIgnoreCase("weapon")) { return Pools.getRandomWeapon(); }
        return null;
    }
}

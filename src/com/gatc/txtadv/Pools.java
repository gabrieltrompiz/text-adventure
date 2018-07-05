package com.gatc.txtadv;

public class Pools {
    public static Armor getRandomArmor(){
        double odds = (Math.random() * 10) + 1;
        if (odds >= 1 && odds < 6) { //60% chance
            return new Armor(new Double(Math.floor((Math.random() * 20) + 40)).intValue(), "common");
        }
        else if (odds >= 6 && odds < 9) { //30%
            return new Armor (new Double(Math.floor((Math.random() * 15) + 60)).intValue(), "rare");
        }
        else if (odds >= 9) { //20%
            return new Armor(new Double(Math.floor((Math.random() * 20) + 90)).intValue(), "epic");
        }
        return null;
    }

    public static Weapon getRandomWeapon(){
        double odds = (Math.random() * 10) + 1;
        return null;
    }
}

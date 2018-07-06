package com.gatc.txtadv;

public class Pools {
    public static Armor getRandomArmor(){
        double odds = (Math.random() * 10) + 1;
        if (odds >= 1 && odds < 6) { //60% chance
            return new Armor(getRandomNumber(40, 65), "common");
        }
        else if (odds >= 6 && odds < 9) { //30%
            return new Armor (getRandomNumber(70, 85), "rare");
        }
        else if (odds >= 9) { //20%
            return new Armor(getRandomNumber(90, 120), "epic");
        }
        return null;
    }

    public static Weapon getRandomWeapon(){
        double odds = (Math.random() * 10) + 1;
        if (odds >= 1 && odds < 6) { //60% chance
            return new Weapon(getRandomNumber(10, 20), (getRandomNumber(5, 6) / 10.0), "common");
        }
        else if (odds >= 6 && odds < 9) { //30%
            return new Weapon(getRandomNumber(20, 30), (getRandomNumber(7, 8) / 10.0), "rare");
        }
        else if (odds >= 9) { //20%
            return new Weapon(getRandomNumber(30, 40), (getRandomNumber(9, 10) / 10.0),"epic");
        }
        return null;
    }

    public static int getRandomNumber(double min, double max){ return new Double(min + (Math.random() * (max - min + 1))).intValue(); }
}

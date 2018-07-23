package com.gatc.txtadv;

public class Pools {
    public static Armor getRandomArmor(){
        double odds = (Math.random() * 10) + 1;
        if (odds >= 1 && odds < 3) { //20% chance
            return new Armor(2, "Sacred Shield");
        }
        else if (odds >= 3 && odds < 5) { //20%
            return new Armor (3, "Divine Shield");
        }
        else if (odds >= 5 && odds < 7) { //20%
            return new Armor(4, "Goddess Shield");
        }
        else if (odds >= 7 && odds < 9) {
            return new Armor (6, "Fortified Shield");
        }
        else if (odds >= 9) {
            return new Armor (10, "Hylian Shield");
        }
        return null;
    }

    public static Weapon getRandomWeapon(){
        double odds = (Math.random() * 10) + 1;
        if (odds >= 1 && odds < 3) { //30% chance
            return new Weapon(2, "Kokiri Sword");
        }
        else if (odds >= 3 && odds < 5) { //20%
            return new Weapon(3, "White Sword");
        }
        else if (odds >= 5 && odds < 7) { //20%
            return new Weapon(4,"Magical Sword");
        }
        else if(odds >= 7 && odds < 9) {
            return new Weapon(6, "Master Sword");
        }
        else if(odds >= 9) {
            return new Weapon(8, "Biggoron's Sword");
        }
        return null;
    }
}

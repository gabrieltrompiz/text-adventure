package com.gatc.txtadv;

public class Main {
    public static void main(String[] args){
        Character character = new Body(100);
        Periquitos newArmor = PeriquitosFactory.getPeriquito("armor");
        Periquitos newWeapon = PeriquitosFactory.getPeriquito("weapon");
        System.out.println(newArmor);
        System.out.println(newWeapon);
        character = new Armor (character, newArmor.getHitpoints(), newArmor.getQuality());
        character = new Weapon (character, newWeapon.getAD(), newWeapon.getAS(), newWeapon.getQuality());
        character.setup();
    }
}

package com.gatc.txtadv;

public class Main {
    public static void main(String[] args){
        Character character = new Body(100);
        Armor newArmor = Pools.getRandomArmor();
        System.out.println("Found " + newArmor.getArmorQuality() + " armor with " + newArmor.getArmorHitpoints() + " HP");
        character = new Armor(character, newArmor);
        character.setup();
    }
}

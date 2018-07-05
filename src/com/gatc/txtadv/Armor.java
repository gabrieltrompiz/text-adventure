package com.gatc.txtadv;

public class Armor extends Periquitos {

    private int armorHitpoints;
    private String quality;

    public Armor (int armorHitpoints, String quality){
        this.armorHitpoints = armorHitpoints;
        this.quality = quality;
    }

    public Armor (Character character, Armor armor){
        super(character);
        this.armorHitpoints = armor.getArmorHitpoints();
        this.quality = armor.getArmorQuality();
    }

    public int getArmorHitpoints(){ return this.armorHitpoints; }
    public String getArmorQuality() { return this.quality; }

    public void setup() {
        super.setup();
        System.out.println("Armor: " + this.armorHitpoints + " (" + this.quality + ")");
    }
}

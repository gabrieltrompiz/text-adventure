package com.gatc.txtadv;

public class Armor extends Periquitos {

    private int armorHitpoints;
    private String quality;

    public Armor (int armorHitpoints, String quality){
        this.armorHitpoints = armorHitpoints;
        this.quality = quality;
    }

    public Armor (Character character, int armorHitpoints, String quality){
        super(character);
        this.armorHitpoints = armorHitpoints;
        this.quality = quality;
    }

    public int getAD() { return 0; }
    public double getAS() { return 0; }
    public int getHitpoints(){ return this.armorHitpoints; }
    public String getQuality() { return this.quality; }

    public void setup() {
        super.setup();
        System.out.println("Armor: " + this.armorHitpoints + " (" + this.quality.toUpperCase() + ")");
    }

    @Override
    public String toString(){
        return ("Found " + this.getQuality() +  " armor with " + this.getHitpoints() + " HP");
    }
}

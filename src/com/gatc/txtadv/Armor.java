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

    public Character equipOn(Character character) {
        character = new Armor(character, this.getHitpoints(), this.getQuality());
        return character;
    }

    public Character unequipOn(Character character) {
        if(character.getClass().getSimpleName().equalsIgnoreCase("weapon")) {
            character = new Weapon(new Body(character.getCurrentHitpoints()), ((Weapon) character).getAD(), ((Weapon) character).getAS(), ((Weapon) character).getQuality());
            System.out.println("\nUnequipped " + this.getQuality() + " armor.\n");
        }
        else {
            character = new Body(character.getCurrentHitpoints());
            System.out.println("\nUnequipped " + this.getQuality() + " armor.\n");
        }
        return character;
    }

    public int getCurrentHitpoints() {
        return super.getCurrentHitpoints();
    }

    public void setup() {
        super.setup();
        System.out.println("Armor: " + this.armorHitpoints + " (" + this.quality.toUpperCase() + ")");
    }

    @Override
    public String toString(){
        return ("Found " + this.getQuality() +  " armor with " + this.getHitpoints() + " HP, want to grab it? (y/n)");
    }
}

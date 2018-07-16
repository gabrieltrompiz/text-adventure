package com.gatc.txtadv;

public class Weapon extends Periquitos {

    private int attackDmg;
    private double attackSpeed;
    private String quality;

    public Weapon(int attackDmg, double attackSpeed, String quality){
        this.attackDmg = attackDmg;
        this.attackSpeed = attackSpeed;
        this.quality = quality;
    }

    public Weapon(Character character, int attackDmg, double attackSpeed, String quality){
        super(character);
        this.attackDmg = attackDmg;
        this.attackSpeed = attackSpeed;
        this.quality = quality;
    }

    public int getHitpoints() { return 0; }
    public String getQuality() { return this.quality; }
    public int getAD(){ return this.attackDmg; }
    public double getAS() { return this.attackSpeed; }

    public Character equipOn(Character character) {
        character = new Weapon(character, this.getAD(), this.getAS(), this.getQuality());
        return character;
    }

    public Character unequipOn(Character character) {
        if(character.getClass().getSimpleName().equalsIgnoreCase("armor")) {
            character = new Armor(new Body(character.getCurrentHitpoints()), ((Armor) character).getHitpoints(), ((Armor) character).getQuality());
            System.out.println("\nUnequipped " + this.getQuality() + " weapon.\n");
        }
        else {
            character = new Body(character.getCurrentHitpoints());
            System.out.println("\nUnequipped " + this.getQuality() + " weapon.\n");
        }
        return character;
    }

    public int getCurrentHitpoints() {
        return super.getCurrentHitpoints();
    }

    public void setup(){
        super.setup();
        System.out.println("Weapon: AD: " + this.attackDmg + ", AS: " + this.attackSpeed + " (" + this.quality.toUpperCase() + ")");
    }

    @Override
    public String toString() {
        return ("Found " + this.getQuality() + " weapon with " + this.getAD() + " AD and " + this.getAS() + " AS, want to grab it? (y/n)");
    }
}

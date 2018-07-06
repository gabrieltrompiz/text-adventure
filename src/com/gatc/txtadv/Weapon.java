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

    public void setup(){
        super.setup();
        System.out.println("Weapon: AD: " + this.attackDmg + ", AS: " + this.attackSpeed + " (" + this.quality.toUpperCase() + ")");
    }

    @Override
    public String toString() {
        return ("Found " + this.getQuality() + " weapon with " + this.getAD() + " AD and " + this.getAS() + " AS");
    }
}

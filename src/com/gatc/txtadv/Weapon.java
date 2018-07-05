package com.gatc.txtadv;

public class Weapon extends Periquitos {

    private int attackDmg;
    private double attackSpeed;
    private String quality;

    public Weapon(Character character, int attackDmg, double attackSpeed, String quality){
        super(character);
        this.attackDmg = attackDmg;
        this.attackSpeed = attackSpeed;
        this.quality = quality;
    }

    public int getAttackDamage(){ return this.attackDmg; }

    public double getAttackSpeed(){ return this.attackSpeed; }

    public void setup(){
        super.setup();
        System.out.println("Weapon = AD: " + this.attackDmg + ", AS: " + this.attackSpeed + "(" + this.quality + ")");
    }
}
